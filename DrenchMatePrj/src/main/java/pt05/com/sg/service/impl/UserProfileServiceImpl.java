package pt05.com.sg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt05.com.sg.data.entity.UserProfile;
import pt05.com.sg.data.repository.UserProfileRepository;
import pt05.com.sg.service.UserProfileService;

@Service
public class UserProfileServiceImpl implements UserProfileService{
	
	@Autowired
	private  UserProfileRepository userProfileRepository;
	
	public List<UserProfile> getList() {
		return (List<UserProfile>) this.userProfileRepository.findAll();
	}
	
	public UserProfile addOrUpdate(UserProfile userProfile) {
		return this.userProfileRepository.save(userProfile);
	}

}
