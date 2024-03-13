package pt05.com.sg.service;

import java.util.List;
import java.util.Map;

import pt05.com.sg.data.dto.SignUpUserDto;
import pt05.com.sg.data.dto.UserDto;
import pt05.com.sg.data.entity.User;

public interface UserService {
	
	public List<User> getUserList();
	
	public User addOrUpdateUser(User user);
	
	public Map<String,String> updateUserByUserId(UserDto user,Long userId);
	
	public Map<String,String> addNewUser(SignUpUserDto user);
	
	public UserDto getUserbyUserId(Long userId) ;
	
	public UserDto getUserbyUserEmail(String email) ;
	
	public Map<String,String>  deleteUserById(Long userId);
	

}
