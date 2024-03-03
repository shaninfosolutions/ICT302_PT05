package pt05.com.sg.service;

import java.util.List;
import java.util.Map;

import pt05.com.sg.data.entity.User;

public interface UserService {
	
	public List<User> getUserList();
	
	public User addOrUpdateUser(User user);
	
	public Map<String,String> updateUserByUserId(User user,Long userId);
	
	public Map<String,String> addNewUser(User user);
	

}
