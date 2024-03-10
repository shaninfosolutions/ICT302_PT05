package pt05.com.sg.schedulingtasks;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import pt05.com.sg.data.dto.EligibleUsersToNotifyDto;
import pt05.com.sg.data.dto.SendMailDto;
import pt05.com.sg.data.jdbc.NotificationJdbc;
import pt05.com.sg.data.repository.NotificationRepository;
import pt05.com.sg.service.impl.EmailServiceImpl;
import pt05.com.sg.service.impl.NotificationServiceImpl;

import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;



@Component
public class ScheduledTasks {
	
	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


	@Autowired
	private EmailServiceImpl emailServiceImpl ;
	
	@Autowired
	private NotificationRepository notificationRepository;
	
	@Autowired
	private NotificationJdbc notificationJdbc;
	

	@Autowired
	private NotificationServiceImpl notificationServiceImpl;
	
	@Value("${notification.offset.one.day}")
	private  Long offsetOneDay;
	
	@Value("${notification.offset.days.to.notify}")
	private  Long offsetDaysToNotify;
	
	
	/*
	@Scheduled(cron = "${cron.expression}",scheduler = "pool1TaskScheduler")
	public void reportCurrentTime() {
		log.info("The time is now {}", dateFormat.format(new Date()));
		System.out.println("Task executed by pool 1");
		
		 // Current date
        LocalDate currentDate = LocalDate.now();
        // Number of days to add
        int daysToAdd = 5;
        int daysToMinusOne = 1;
        
        // Calculate the date after adding days
        LocalDate futureDate = currentDate.plusDays(daysToAdd);
        LocalDate pastdateOneDayBehind= currentDate.minusDays(daysToMinusOne);
        LocalDate pastFivedate= currentDate.minusDays(daysToAdd);
        
        Date date = Date.from(pastdateOneDayBehind.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        
        // Print the future date
        System.out.println("Date after " + daysToAdd + " days: " + futureDate +
        		" pastFivedate:"+pastFivedate 
        		+" pastdateOneDayBehind:" +pastdateOneDayBehind
        		+" date :"+date);
        
        
        SendMailDto sendMailDto=new SendMailDto();
        sendMailDto.setTemplateNumber(Long.valueOf(1000));
        sendMailDto.setSubject("Drench Mate<noreply>");
        sendMailDto.setTo("catguy.aws1@gmail.com");
        
        Map<String, Object> values=new HashMap<>();
        values.put("Testing1", "DrenchMate sending the email to remind to take action!! By John KM");
        
       // boolean result=this.emailServiceImpl.sendEmailTest("catguy.aws1@gmail.com", "Drench", 
        		//"DrenchMate sending the email to remind to take action!! By John KM");   
       // boolean result=this.emailServiceImpl.sendEmail("catguy.aws1@gmail.com", "Drench", 
        		//"DrenchMate sending the email to remind to take action!! By John KM");
      //  if(result) {
        	 //System.out.println("Email send out successfully:"+ sendMailDto.getTo());
       // }else {
        	//System.out.println("Email not send out successfully: Failed"+ sendMailDto.getTo());
       // }
    
	}*/
	
	@Scheduled(cron = "${user.note.cron.expression}",scheduler = "mySchedulerUserNote")
    public void performUserNoteTask() {
        try {
        	log.info("User Note Notification performed at {Entry}", LocalDateTime.now());
        	this.notificationServiceImpl.processNotification();
        	log.info("User Note Notification performed at {End}", LocalDateTime.now());
        } catch (Exception e) {
        	log.error("Error during task execution", e);
        }
    }
	/*
	@Scheduled(cron = "${task.cron.expression}",scheduler = "mySchedulerTask")
    public void performTask() {
        try {
        	log.info("Task performed at {}", LocalDateTime.now());
            // Perform task logic
        } catch (Exception e) {
        	log.error("Error during task execution", e);
        }
    }*/
}
