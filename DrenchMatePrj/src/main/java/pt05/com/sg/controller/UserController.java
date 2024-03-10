package pt05.com.sg.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pt05.com.sg.DrenchMatePrjApplication;
import pt05.com.sg.data.dto.UserDto;
import pt05.com.sg.data.entity.User;
import pt05.com.sg.dto.AuthRequest;
import pt05.com.sg.jwt.servcie.JwtService;
import pt05.com.sg.service.impl.UserServiceImpl;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	
	@Autowired
    private UserServiceImpl userServiceImpl;
	
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;
	
    
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

	@PostMapping("/register")
	@ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<Map<String,String>> addNewUser(@RequestHeader Map<String, String> headers,@RequestBody User user) {
		try {
			Map<String,String> responseMap=this.userServiceImpl.addNewUser(user);
			return ResponseEntity.status(HttpStatus.OK).body(responseMap);
		 
		}catch(Exception e) {
			Map<String,String> responseMap=new HashMap<String,String>();
			responseMap.put("status", "Failed");
			responseMap.put("message", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMap);
		}
		
    }
	
	@GetMapping("/dm/users")
	public List<User> findAllUser() {
    	 return this.userServiceImpl.getUserList();
	}
	
	
	//@GetMapping("/dm/user/{userId}")
	@GetMapping("/dm/user/{userid}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Object> getUserByUserId(
			@PathVariable("userid") Long userId) {
			log.info("getUserByUserId User By User ID: Entry "+ userId);
			
			try {
				 	UserDto userdto=this.userServiceImpl.getUserbyUserId(userId);
				 	if(userdto!=null) {
				 	return new ResponseEntity<>(userdto, HttpStatus.OK);
				 	}else {
				 		Map<String,String> responseMap=new HashMap<String,String>();
						responseMap.put("status", "Failed");
						responseMap.put("message", "User not found in System");
						return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
				 	}
			}catch(Exception e) {
				Map<String,String> responseMap=new HashMap<String,String>();
				responseMap.put("status", "Failed");
				responseMap.put("message", e.getMessage());
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMap);
			}
	}
	
	
	//@GetMapping("/dm/user/{userId}")
		@GetMapping("/dm/user/email")
		@ResponseStatus(value = HttpStatus.OK)
		public ResponseEntity<Object> getUserByUserEmail(
				@RequestParam("email") String email) {
				log.info("getUserByUserId User By User Email: Entry "+ email);
				try {
					 	UserDto userdto=this.userServiceImpl.getUserbyUserEmail(email);
					 	if(userdto!=null) {
					 	return new ResponseEntity<>(userdto, HttpStatus.OK);
					 	}else {
					 		Map<String,String> responseMap=new HashMap<String,String>();
							responseMap.put("status", "Failed");
							responseMap.put("message", "User not found in System");
							return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
					 	}
				}catch(Exception e) {
					Map<String,String> responseMap=new HashMap<String,String>();
					responseMap.put("status", "Failed");
					responseMap.put("message", e.getMessage());
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMap);
				}
		}
	
	@PostMapping("dm/user/{userId}")
	public ResponseEntity<Map<String,String>> updateUserByUserId(
			@RequestHeader Map<String, String> headers,
			@RequestBody User user,
			@PathVariable("userId") Long userId) {
		
		try {
			log.info("Update User By User ID: Entry "+ userId);
			Map<String,String> responseMap=this.userServiceImpl.updateUserByUserId(user,userId);
			return ResponseEntity.status(HttpStatus.OK).body(responseMap);
		 
		}catch(Exception e) {
			Map<String,String> responseMap=new HashMap<String,String>();
			responseMap.put("status", "Failed");
			responseMap.put("message", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMap);
		}
		
	}
	
	
	@DeleteMapping("dm/user/delete/{userId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<Map<String,String>> deleteUserById(@PathVariable("userId") Long userId)
    {
		log.info("Delete User By User ID: Entry "+ userId);
		Map<String,String> responseMap=new HashMap<String,String>();
		try {
		
			responseMap=userServiceImpl.deleteUserById( userId);
	    	//responseMap.put("status", "Success");
	    	//responseMap.put("message","User Removed Successfully");
	        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
		}
        catch(Exception e) {
        	responseMap.put("status", "Failed");
			responseMap.put("message", e.getMessage());
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseMap);
        }
    }
	
	
	@PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getEmail());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }


    }

	
	

}
