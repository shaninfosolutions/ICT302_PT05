package pt05.com.sg.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import pt05.com.sg.data.dto.EligibleUsersToNotifyDto;
import pt05.com.sg.data.dto.NotiRuleScoreCard;
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
        			}else {
        				message="Dear "+dto.getName()+"\n"
            					+ "This is alert notification to inform you that your farmhouse is normal.\n"
            					+ "Thanks. "
            					+ "(System auto generate, no reply required)";
        			}
        			 
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
	
	

}
