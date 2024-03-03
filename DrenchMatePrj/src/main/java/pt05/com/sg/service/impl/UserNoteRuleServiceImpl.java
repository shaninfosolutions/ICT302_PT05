package pt05.com.sg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt05.com.sg.data.entity.UserNoteRule;
import pt05.com.sg.data.repository.UserNoteRuleRepository;
import pt05.com.sg.service.UserNoteRuleService;

@Service
public class UserNoteRuleServiceImpl implements UserNoteRuleService{
	
	@Autowired
	private  UserNoteRuleRepository userNoteRuleRepository;
	
	public List<UserNoteRule> getList() {
		return (List<UserNoteRule>) this.userNoteRuleRepository.findAll();
	}
	
	public UserNoteRule addOrUpdate(UserNoteRule userNoteRule) {
		return this.userNoteRuleRepository.save(userNoteRule);
	}

}
