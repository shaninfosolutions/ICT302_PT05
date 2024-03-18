package pt05.com.sg;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pt05.com.sg.data.dto.UserDto;
import pt05.com.sg.data.entity.User;
import pt05.com.sg.data.entity.UserProfile;
import pt05.com.sg.data.repository.UserRepository;
import pt05.com.sg.service.impl.UserServiceImpl;

@SpringBootApplication(scanBasePackages = {"pt05.com.sg"})
@EnableAutoConfiguration
@EntityScan("pt05.com.sg.data.entity")
@ComponentScan("pt05.com.sg")
@EnableScheduling
public class DrenchMatePrjApplication implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(DrenchMatePrjApplication.class);
	
	@Value("${cron.expression}")
	private String cronExpression;

	@Autowired
    private UserServiceImpl userServiceImpl;
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder ;

	
	
	@Override
    public void run(String...args) throws Exception {
		List<UserDto> list=userServiceImpl.getUserList();
		log.info("DrenchMatePrjApplication::: BEGIN");
		/*if(list.size()>0) {
			list.forEach(cust->
						System.out.println(
								cust.getUserId()+":"+
								cust.getName()+":"+
								cust.getEmail()+":"+
								cust.getUserProfile().getDisplayName()
								));
		}*/
		//this.userRepository.deleteAll();
		
		/*User u=new User("Mary","mary.lwin@pt05.com.sg",passwordEncoder.encode("password"),"System",new Date(),"System",new Date(),"ROLE_ADMIN");
		
		UserProfile up=new UserProfile();
		
		up.setDisplayName("Mary Lwin");
		up.setPhoneNo(Long.valueOf(909090));
		up.setFacebookLink("http://mary.facebook");
		up.setRemarks("Testing");
		u.setUserProfile(up);
		up.setUser(u);
		
		 this.userRepository.save(u);
		//this.userRepository.save(new User("John","john.lwin@pt05.com.sg",passwordEncoder.encode("password"),"System",new Date(),"System",new Date()));
		//this.userRepository.save(new User("Janson","janson.lwin@pt05.com.sg",passwordEncoder.encode("password"),"System",new Date(),"System",new Date()));
        
		//to update 
		//Optional<User> user=this.userRepository.findByEmail("tina.lwin@pt05.com.sg");
		//user.get().setName("Tina Update 3");
		//this.userRepository.save(user.get());*/
    }
	
	public static void main(String[] args)  {
		SpringApplication.run(DrenchMatePrjApplication.class, args);
	}
	
	/*
	@Scheduled(cron = "${cron.expression}")
    public void scheduledTask() {
        System.out.println("Drench Mate Scheduled task executed at: " + new Date());
        // Your task logic goes here
    }*/

}
