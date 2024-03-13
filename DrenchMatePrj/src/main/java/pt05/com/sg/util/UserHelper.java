package pt05.com.sg.util;

import pt05.com.sg.data.dto.UserDto;
import pt05.com.sg.data.entity.User;

public class UserHelper {

	public static UserDto mapUserDto(User dbUser) {
		UserDto userDto=new UserDto();
		userDto.setUserId(dbUser.getUserId());
	    userDto.setName(dbUser.getName());
	    userDto.setEmail(dbUser.getEmail());
	    userDto.setDisplayName(dbUser.getUserProfile().getDisplayName());
	    userDto.setAvator(dbUser.getUserProfile().getAvator());
	    userDto.setFacebookLink(dbUser.getUserProfile().getFacebookLink());
	    userDto.setTwitterLink(dbUser.getUserProfile().getTwitterLink());
	    userDto.setPhoneNo(dbUser.getUserProfile().getPhoneNo());
	    userDto.setRemarks(dbUser.getUserProfile().getRemarks());
	    
	    return userDto;
	}
}
