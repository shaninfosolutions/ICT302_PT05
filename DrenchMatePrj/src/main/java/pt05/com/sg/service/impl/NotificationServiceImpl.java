package pt05.com.sg.service.impl;

import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import pt05.com.sg.data.dto.EligibleUsersToNotifyDto;
import pt05.com.sg.data.dto.NotiNoteSeverifyLevelDto;
import pt05.com.sg.data.dto.NotiRuleScoreCard;
import pt05.com.sg.data.dto.NotiTaskSummaryDto;
import pt05.com.sg.data.dto.NotificationNoteSummaryDto;
import pt05.com.sg.data.entity.User;
import pt05.com.sg.data.entity.FarmHouse;
import pt05.com.sg.data.entity.Notification;
import pt05.com.sg.data.jdbc.impl.NotificationJdbcImpl;
import pt05.com.sg.data.repository.FarmHouseRepository;
import pt05.com.sg.data.repository.NoteRepository;
import pt05.com.sg.data.repository.NotificationRepository;
import pt05.com.sg.data.repository.UserRepository;
import pt05.com.sg.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService{
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	
	private final String COLOR_RED="red";
	
	private final String COLOR_YELLOW="yellow";
	
	private final String COLOR_GREEN="green";
	
	private final String SEVERITY_LEVEL_1="S3";
	
	private final String SEVERITY_LEVEL_2="S2";
	
	private final String SEVERITY_LEVEL_3="S1";
	
	private final String TASK_DUE="DUE";
	
	private final String TASK_ONTIME="ON TIME";
	
	private final String TASK_OVER_DUE="OVER DUE";
	
	
	private final Long VALUE_ZERO=Long.valueOf(0);
	
	private final String NOTI_TYPE_NOTE="USER_NOTE";
	
	private final String NOTI_TYPE_TASK="USER_TASK";
	
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Autowired
	private NotificationRepository notificationRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FarmHouseRepository farmHouseRepository;
	

	
	
	
	@Autowired
	private EmailServiceImpl emailServiceImpl ;
	
	
	@Autowired
	private NotificationJdbcImpl notificationJdbcImpl;
	
	@Value("${notification.offset.one.day}")
	private  Long offsetOneDay;
	
	@Value("${notification.offset.days.to.notify}")
	private  Long offsetDaysToNotify;
	
	
	public List<Notification> getList() {
		return (List<Notification>) this.notificationRepository.findAll();
	}
	
	public Notification addOrUpdate(Notification notification) {
		return this.notificationRepository.save(notification);
	}
	
	public Map<String,String> addOrUpdateNotiTask(NotiTaskSummaryDto notiTaskSummaryDto,Long userId) {
		
		Map<String,String> responseMessage=new HashMap<String,String>();
		String message="";
		try {
				Notification noti=this.notificationRepository.
										findByNotificationId(notiTaskSummaryDto.getNotificationId()).get();
				if(noti!=null) {
					noti.setStatus(notiTaskSummaryDto.getStatus());
					User user=this.userRepository.findById(userId).get();
					
					noti.setLastUpdatedDate(new Date());
					noti.setLastUpdatedBy(user.getName());
					
					this.notificationRepository.save(noti);
					message="NotiTask has been Updated Successfully";
					responseMessage.put("status", "Success");
					responseMessage.put("message",message);
					
				}else {
					message="Notification not found to update";
					responseMessage.put("status", "Failed");
					responseMessage.put("message",message);
				}
		}catch(Exception e) {
			log.info("System Exception ");
			responseMessage.put("status", "Failed");
			message=e.getMessage();
			responseMessage.put("message",e.getMessage());
		}
		
		return responseMessage;
		
	}
	
	
public Map<String,String> addOrUpdateNotiNote(NotificationNoteSummaryDto notiTaskSummaryDto,Long userId) {
		
		Map<String,String> responseMessage=new HashMap<String,String>();
		String message="";
		try {
				Notification noti=this.notificationRepository.
										findByNotificationId(notiTaskSummaryDto.getNotificationId()).get();
				if(noti!=null) {
					noti.setStatus(notiTaskSummaryDto.getStatus());
					User user=this.userRepository.findById(userId).get();
					
					noti.setLastUpdatedDate(new Date());
					noti.setLastUpdatedBy(user.getName());
					
					this.notificationRepository.save(noti);
					message="Noti Note has been Updated Successfully";
					responseMessage.put("status", "Success");
					responseMessage.put("message",message);
					
				}else {
					message="Notification not found to update";
					responseMessage.put("status", "Failed");
					responseMessage.put("message",message);
				}
		}catch(Exception e) {
			log.info("System Exception ");
			responseMessage.put("status", "Failed");
			message=e.getMessage();
			responseMessage.put("message",e.getMessage());
		}
		
		return responseMessage;
		
	}
	
	
	
	public void processTaskNotification() {
		
		try {
        	log.info("Notification Service Process Begin:{TASK}");
        	//Long bestScore=this.notificationJdbcImpl.findNotiRuleScoreCard();
        	List<EligibleUsersToNotifyDto> list=this.notificationJdbcImpl.findEligibleTaskNotify(
        																	offsetOneDay);
        	list.forEach(u->System.out.println(u.getUserId()+":"+u.getFarmHouseId()));
        	if(list.size()>0) {
        		
        		for(EligibleUsersToNotifyDto dto:list) {
        			
        			
        		log.info("Trigger Task Notification Begin:"+dto.getUserId()+":FarmHouseid:"+dto.getFarmHouseId());
        	
        		
        			String message="Dear "+dto.getName()+"\n"
        					+ "This is alert notification to inform you have upcoming Task Schedule.\n"
        					+ "Thanks. "
        					+ "(System auto generate, no reply required)";
        			String subject="Drench Mate - Notification as of "+new Date();
        			
        			/*Trigger point to Send Email Notification*/
        			this.emailServiceImpl.sendEmail(dto.getEmail(), subject, message);
        			
        			User u=this.userRepository.findByUserId(dto.getUserId()).get();
        			
        			Optional<FarmHouse> optionalFarmHouse = this.farmHouseRepository.findByFarmHouseId(dto.getFarmHouseId());

        			Notification notification=new Notification();
        			notification.setUser(u);
        			notification.setMessage(message);
        			notification.setStatus("OPEN");
        			notification.setNotiType("USER_TASK");
        			notification.setRemarks("System Auto Generate");
        			
        			if (optionalFarmHouse.isPresent()) {
        			    FarmHouse farmhouse = optionalFarmHouse.get();
        			    // Use the farmhouse object
        			    notification.setFarmHouse(farmhouse);
        			} else {
        			    //throw Exception();
        			}
        			notification.setDateOfNotification(new Date());
        			notification.setCreatedBy(dto.getName());
        			notification.setCreatedDate(new Date());
        			notification.setLastUpdatedBy(dto.getName());
        			notification.setTaskId(dto.getTaskId());
        			notification.setLastUpdatedDate(new Date());
        			
        			this.notificationRepository.save(notification);
        			
        			log.info("Trigger Notification End:"+dto.getName());
        		
        		}
        	}else {
        		log.info("There is no User found to notify");
        	}
        	
        	log.info("Notification Service Process End:");
        	
        } catch (Exception e) {
        	log.error("Error during Notificaiotn Processing", e);
        }
		
	}
	
	public void processNotification() {
		
		try {
        	log.info("Notification Service Process Begin:");
        	Long bestScore=this.notificationJdbcImpl.findNotiRuleScoreCard();
        	List<EligibleUsersToNotifyDto> list=this.notificationJdbcImpl.findEligibleUsersToNotify(
        																	offsetOneDay);
        	list.forEach(u->System.out.println(u.getUserId()+":"+u.getFarmHouseId()));
        	if(list.size()>0) {
        		
        		for(EligibleUsersToNotifyDto dto:list) {
        			Long notiScoreCard=this.notificationJdbcImpl.findUserNotiScoreCard(
				        											offsetOneDay, 
				        											dto.getUserId(), 
				        											dto.getFarmHouseId());
        			
        		log.info("Trigger Notification Begin:"+dto.getUserId()+":FarmHouseid:"+dto.getFarmHouseId()+
        				":Best Score:"+bestScore+":User Score:"+notiScoreCard);
        		if(notiScoreCard!=null ) {
        			String message="";
        			
        			if(notiScoreCard< bestScore) {
        				message="Dear "+dto.getName()+"\n"
            					+ "This is alert notification to inform you that your farmhouse is in danger.\n"
            					+ "Please look for the consultant to drench you sheep.\n"
            					+ "Thanks. "
            					+ "(System auto generate, no reply required)";
        			/*else {
        				message="Dear "+dto.getName()+"\n"
            					+ "This is alert notification to inform you that your farmhouse is normal.\n"
            					+ "Thanks. "
            					+ "(System auto generate, no reply required)";
        			}*/
        			 
        			String subject="Drench Mate - Notification as of "+new Date();
        			
        			/*Trigger point to Send Email Notification*/
        			this.emailServiceImpl.sendEmail(dto.getEmail(), subject, message);
        			
        			User u=this.userRepository.findByUserId(dto.getUserId()).get();
        			
        			Optional<FarmHouse> optionalFarmHouse = this.farmHouseRepository.findByFarmHouseId(dto.getFarmHouseId());

        			Notification notification=new Notification();
        			notification.setUser(u);
        			notification.setMessage(message);
        			notification.setStatus("OPEN");
        			notification.setNotiType("USER_NOTE");
        			notification.setNoteId(dto.getNoteId());
        			notification.setRemarks("System Auto Generate");
        			
        			if (optionalFarmHouse.isPresent()) {
        			    FarmHouse farmhouse = optionalFarmHouse.get();
        			    // Use the farmhouse object
        			    notification.setFarmHouse(farmhouse);
        			} else {
        			    //throw Exception();
        			}
        			notification.setDateOfNotification(new Date());
        			notification.setCreatedBy(dto.getName());
        			notification.setCreatedDate(new Date());
        			notification.setLastUpdatedBy(dto.getName());
        			notification.setLastUpdatedDate(new Date());
        			
        			this.notificationRepository.save(notification);
        			
        			log.info("Trigger Notification End:"+dto.getName());
        			}else {
        				log.info("This is alert notification to inform you that your farmhouse is normal");
        			}
        			
        		}else{
        			log.info("There is no Best Score to compare to notify");
        		}
        		}
        	}else {
        		log.info("There is no User found to notify");
        	}
        	
        	log.info("Notification Service Process End:");
        	
        } catch (Exception e) {
        	log.error("Error during Notificaiotn Processing", e);
        }
		
	}
	
	public HashMap<String,List> getNoteNotSeverityLevel(Long userId) {
		
		List<NotiNoteSeverifyLevelDto> dtoList=(List<NotiNoteSeverifyLevelDto>) this.notificationJdbcImpl.findNoteNotiSeverityLevel(userId,NOTI_TYPE_NOTE);
		HashMap <String,List> map=new HashMap<String,List>();
		List<String> labelNotiValue=new ArrayList<>();
		List<String> notiValue=new ArrayList<>();
		List<String> backgroundColor=new ArrayList<>();
		
		Map<String,String> hashmap=new HashMap<String,String>();
		
		
		if(dtoList.size()==0 || dtoList==null ) {
			log.info("the dto list is null");
			 
			 labelNotiValue.add(SEVERITY_LEVEL_1);
			 labelNotiValue.add(SEVERITY_LEVEL_2);
			 labelNotiValue.add(SEVERITY_LEVEL_3);
			 
			
			 notiValue.add(String.valueOf(VALUE_ZERO));
			 notiValue.add(String.valueOf(VALUE_ZERO));
			 notiValue.add(String.valueOf(VALUE_ZERO));
			 
			 
			 backgroundColor.add(COLOR_YELLOW);
			 backgroundColor.add(COLOR_GREEN);
			 backgroundColor.add(COLOR_RED);
			 
			
			
		}else {
			for(NotiNoteSeverifyLevelDto dto:dtoList) {
				
				labelNotiValue.add(dto.getLabelNotiValue());
				if(dto.getNotiValue()!=null) {
				notiValue.add(String.valueOf(dto.getNotiValue()));
				}else {
					notiValue.add(String.valueOf(VALUE_ZERO));
				}
				
				backgroundColor.add(dto.getBackgroundColor());
			}
			
			if(!labelNotiValue.contains(SEVERITY_LEVEL_1)) {
				 labelNotiValue.add(SEVERITY_LEVEL_1);
				 notiValue.add(String.valueOf(VALUE_ZERO));
				 backgroundColor.add(COLOR_YELLOW);
			} 
			if(!labelNotiValue.contains(SEVERITY_LEVEL_2)){
				 labelNotiValue.add(SEVERITY_LEVEL_2);
				 notiValue.add(String.valueOf(VALUE_ZERO));
				 backgroundColor.add(COLOR_GREEN);
			}
			
			if(!labelNotiValue.contains(SEVERITY_LEVEL_3)) {
				labelNotiValue.add(SEVERITY_LEVEL_3);
				 notiValue.add(String.valueOf(VALUE_ZERO));
				 backgroundColor.add(COLOR_RED);
				
			}

		}
		
		 map.put("labelNotiValue", labelNotiValue);
		 map.put("notiValue", notiValue);
		 map.put("backgroundColor", backgroundColor);
		
		return map;
	}

	@Override
	public HashMap<String, List> getTaskSchedule(Long userId) {

		List<NotiNoteSeverifyLevelDto> dtoList=(List<NotiNoteSeverifyLevelDto>) this.notificationJdbcImpl.findTaskSchedule(userId,NOTI_TYPE_TASK);
		HashMap <String,List> map=new HashMap<String,List>();
		List<String> labelNotiValue=new ArrayList<>();
		List<String> notiValue=new ArrayList<>();
		List<String> backgroundColor=new ArrayList<>();
		
		if(dtoList.size()==0 || dtoList==null ) {
			log.info("the dto list is null");
			 
			 labelNotiValue.add(TASK_DUE);
			 labelNotiValue.add(TASK_ONTIME);
			 labelNotiValue.add(TASK_OVER_DUE);
			 
			
			 notiValue.add(String.valueOf(VALUE_ZERO));
			 notiValue.add(String.valueOf(VALUE_ZERO));
			 notiValue.add(String.valueOf(VALUE_ZERO));
			 
			 
			 backgroundColor.add(COLOR_YELLOW);
			 backgroundColor.add(COLOR_GREEN);
			 backgroundColor.add(COLOR_RED);
			
		}else {
			for(NotiNoteSeverifyLevelDto dto:dtoList) {
				labelNotiValue.add(dto.getLabelNotiValue());
				if(dto.getNotiValue()!=null) {
					notiValue.add(String.valueOf(dto.getNotiValue()));
				}else {
						notiValue.add(String.valueOf(VALUE_ZERO));
					}
					
				backgroundColor.add(dto.getBackgroundColor());
			}
			
			if(!labelNotiValue.contains(TASK_DUE)) {
				 labelNotiValue.add(TASK_DUE);
				 notiValue.add(String.valueOf(VALUE_ZERO));
				 backgroundColor.add(COLOR_YELLOW);
			} 
			if(!labelNotiValue.contains(TASK_ONTIME)){
				 labelNotiValue.add(TASK_ONTIME);
				 notiValue.add(String.valueOf(VALUE_ZERO));
				 backgroundColor.add(COLOR_GREEN);
			}
			
			if(!labelNotiValue.contains(TASK_OVER_DUE)) {
				labelNotiValue.add(TASK_OVER_DUE);
				 notiValue.add(String.valueOf(VALUE_ZERO));
				 backgroundColor.add(COLOR_RED);
				
			}
			
		}
		
		 map.put("labelNotiValue", labelNotiValue);
		 map.put("notiValue", notiValue);
		 map.put("backgroundColor", backgroundColor);
		
		return map;
	
	}
	
	public List<NotificationNoteSummaryDto> getNotiNoteSummary(Long userId) {
		List<NotificationNoteSummaryDto> dtolist=null;
		dtolist=this.notificationJdbcImpl.findNotiNoteSummary(userId);
		if(dtolist.size()==0) dtolist=null;
		
		return dtolist;
	}
	
	public List<NotiTaskSummaryDto> getNotiTaskSummary(Long userId) {
		List<NotiTaskSummaryDto> dtolist=null;
		dtolist=this.notificationJdbcImpl.findNotiTaskSummary(userId);
		if(dtolist.size()==0) dtolist=null;
		
		return dtolist;
	}

}
