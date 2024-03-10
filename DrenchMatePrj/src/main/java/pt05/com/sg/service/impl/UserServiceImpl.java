package pt05.com.sg.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pt05.com.sg.data.dto.UserDto;
import pt05.com.sg.data.entity.User;
import pt05.com.sg.data.entity.UserProfile;
import pt05.com.sg.data.repository.UserRepository;
import pt05.com.sg.service.UserService;
import pt05.com.sg.validation.CustomerValidation;

@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);


	
	@Value("${notification.offset.days.to.notify}")
	private  Long offsetDaysToNotify;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder ;
	
	@Override
	public List<User> getUserList() {
		return (List<User>) this.userRepository.findAll();
	}
	
	@Override
	public UserDto getUserbyUserId(Long userId) {
		
		Optional<User> userOptional=this.userRepository.findByUserId(userId);
		  UserDto userDto=new UserDto();
		if(userOptional.isPresent()) {
			User dbUser=userOptional.get();
			//Mapping into the User DTO 
		  
		    userDto.setName(dbUser.getName());
		    userDto.setEmail(dbUser.getEmail());
		    userDto.setDisplayName(dbUser.getUserProfile().getDisplayName());
		    userDto.setAvator(dbUser.getUserProfile().getAvator());
		    userDto.setFacebookLink(dbUser.getUserProfile().getFacebookLink());
		    userDto.setTwitterLink(dbUser.getUserProfile().getTwitterLink());
		    userDto.setPhoneNo(dbUser.getUserProfile().getPhoneNo());
		    userDto.setRemarks(dbUser.getUserProfile().getRemarks());
		    userDto.setMessage("User Found in System");
		    userDto.setStatus("Success");
		}else {
			// userDto.setMessage(userId+" Not Found in System");
			// userDto.setStatus("Failed");
			 userDto=null;
			// throw new Exception("User not found in System!!!!");
		}

		return userDto;
	}
	

	@Override
	public User addOrUpdateUser(User user) {
		log.info("Entry:"+user.getEmail());
		
		Optional<User> userOptional =this.userRepository.findByEmail(user.getEmail());
		
		if(!userOptional.isPresent()) {
			//Create
			User dbUser=new User(user);
			log.info("Creating:"+user.getEmail());
			//dbUser=new User(user);
			
			String password=passwordEncoder.encode(user.getPassword());
			dbUser.setPassword(password);
			
			dbUser.setCreatedDate(new Date());
			dbUser.setCreatedBy(user.getCreatedBy()==null?user.getName():user.getCreatedBy());
			dbUser.setLastUpdatedDate(new Date());
			dbUser.setLastUpdatedBy(user.getLastUpdatedBy()==null?user.getName():user.getLastUpdatedBy());
			
			UserProfile dbUserProfile=new UserProfile(user.getUserProfile());
			dbUserProfile.setUser(dbUser);
			dbUser.setUserProfile(dbUserProfile);
			return this.userRepository.save(dbUser);
			
		}else {
			return null;
		}
	}
	
	public Map<String,String> addNewUser(User user) {
		Map<String,String> responseMessage=new HashMap<String,String>();
		String message="";
		try {
			
			if(!CustomerValidation.isMandatory(message, user.getEmail())) {
				responseMessage.put("status", "Failed");
				responseMessage.put("message",message);
				throw new IllegalArgumentException("It is mandatory");
			}
			else if(!CustomerValidation.isValidEmail(message, user.getEmail())) {
				responseMessage.put("status", "Failed");
				responseMessage.put("message",message);
				throw new IllegalArgumentException("Invalid email address");
			}else {
					Optional<User> userOptional =this.userRepository.findByEmail(user.getEmail());
					if(!userOptional.isPresent()) {
						//should have the validation
						User dbUser=new User(user);
						log.info("Creating:"+user.getEmail());
						//dbUser=new User(user);
						
						String password=passwordEncoder.encode(user.getPassword());
						dbUser.setPassword(password);
						
						dbUser.setCreatedDate(new Date());
						dbUser.setCreatedBy(user.getCreatedBy()==null?user.getName():user.getCreatedBy());
						dbUser.setLastUpdatedDate(new Date());
						dbUser.setLastUpdatedBy(user.getLastUpdatedBy()==null?user.getName():user.getLastUpdatedBy());
						
						UserProfile dbUserProfile=new UserProfile(user.getUserProfile());
						dbUserProfile.setUser(dbUser);
						dbUser.setUserProfile(dbUserProfile);
						this.userRepository.save(dbUser);
						
						//--Create the Notification Setting by default
						
						
						
						message="Thanks for registering";
						responseMessage.put("status", "Success");
						responseMessage.put("message",message);
					}else {
						// "User exist in the system, please log in";
						responseMessage.put("status", "Failed");
						message=user.getEmail()+" exist in the system, Please Log in";
						responseMessage.put("message", message);
					}
			
			}
			
			}catch(Exception e) {
				responseMessage.put("status", "Failed");
				message=e.getMessage();
				responseMessage.put("message",e.getMessage());
			}
		
		return responseMessage;
	}
	

	@Override
	public Map<String,String> updateUserByUserId(User user,Long userId) {
		Map<String,String> responseMessage=new HashMap<String,String>();
		String message="";
		try {
			if(!CustomerValidation.isMandatory(message, user.getEmail())) {
				responseMessage.put("status", "Failed");
				responseMessage.put("message",message);
				throw new IllegalArgumentException("It is mandatory");
			}
			else if(!CustomerValidation.isValidEmail(message, user.getEmail())) {
				responseMessage.put("status", "Failed");
				responseMessage.put("message",message);
				throw new IllegalArgumentException("Invalid email address");
			}else {
				Optional<User> userOptional =this.userRepository.findByEmail(user.getEmail());
				if(userOptional.isPresent()) {
					User dbUser=userOptional.get();
					
					dbUser.setName(user.getName());
					String password=passwordEncoder.encode(user.getPassword());
					dbUser.setPassword(password);
					
					dbUser.setLastUpdatedDate(new Date());
					dbUser.setLastUpdatedBy(user.getLastUpdatedBy()==null?user.getName():user.getLastUpdatedBy());
					
					UserProfile dbUserProfile=dbUser.getUserProfile();
					
					dbUserProfile.setDisplayName(user.getUserProfile().getDisplayName());
					dbUserProfile.setAvator(user.getUserProfile().getAvator());
					dbUserProfile.setFacebookLink(user.getUserProfile().getFacebookLink());
					dbUserProfile.setTwitterLink(user.getUserProfile().getTwitterLink());
					dbUserProfile.setPhoneNo(user.getUserProfile().getPhoneNo());
					dbUserProfile.setLastUpdatedDate(new Date());
					dbUserProfile.setLastUpdatedBy(user.getLastUpdatedBy()==null?user.getName():user.getLastUpdatedBy());
					
					dbUserProfile.setUser(dbUser);
					
					dbUser.setUserProfile(dbUserProfile);
					
					this.userRepository.save(dbUser);
					
					message="Update User Profile Successfully";
					responseMessage.put("status", "Success");
					responseMessage.put("message",message);
					
				}else {
					// "User Not exist in the system to update";
					responseMessage.put("status", "Failed");
					message=user.getEmail()+" not exist in the system, Please register!!!";
					responseMessage.put("message", message);
				}
			}
		}catch(Exception e) {
			responseMessage.put("status", "Failed");
			message=e.getMessage();
			responseMessage.put("message",e.getMessage());
		}
		
		return responseMessage;
		
		
	}

	@Override
	public UserDto getUserbyUserEmail(String email) {
		Optional<User> userOptional=this.userRepository.findByEmail(email);
		  UserDto userDto=new UserDto();
		if(userOptional.isPresent()) {
			User dbUser=userOptional.get();
			//Mapping into the User DTO 
		  
		    userDto.setName(dbUser.getName());
		    userDto.setEmail(dbUser.getEmail());
		    userDto.setDisplayName(dbUser.getUserProfile().getDisplayName());
		    userDto.setAvator(dbUser.getUserProfile().getAvator());
		    userDto.setFacebookLink(dbUser.getUserProfile().getFacebookLink());
		    userDto.setTwitterLink(dbUser.getUserProfile().getTwitterLink());
		    userDto.setPhoneNo(dbUser.getUserProfile().getPhoneNo());
		    userDto.setRemarks(dbUser.getUserProfile().getRemarks());
		    userDto.setMessage("User Found in System");
		    userDto.setStatus("Success");
		}else {
			// userDto.setMessage(userId+" Not Found in System");
			// userDto.setStatus("Failed");
			 userDto=null;
			// throw new Exception("User not found in System!!!!");
		}

		return userDto;
	}
	
	public Map<String,String>  deleteUserById(Long userId) {
		Optional<User> userOptional=this.userRepository.findByUserId(userId);
		String message="";
		Map<String,String> responseMessage=new HashMap<String,String>();
		try {
		if(userOptional.isPresent()) {
			
			User dbUser=userOptional.get();
			log.info("User Found to Delete: Email:"+ dbUser.getEmail()+", Name:"+dbUser.getName());
			this.userRepository.delete(dbUser);
			message="Deleted User Successfully";
			responseMessage.put("status", "Success");
			responseMessage.put("message",message);
		}else {
			message="User not exist to delete";
			responseMessage.put("status", "Failed");
			responseMessage.put("message",message);
		}
		}catch(Exception e) {
			responseMessage.put("status", "Failed");
			message=e.getMessage();
			responseMessage.put("message",e.getMessage());
		}
		
		return responseMessage;
	}

}
