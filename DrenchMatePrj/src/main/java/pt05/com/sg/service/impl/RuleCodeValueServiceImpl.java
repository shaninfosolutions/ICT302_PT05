package pt05.com.sg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt05.com.sg.data.entity.RuleCodeValue;
import pt05.com.sg.data.repository.RuleCodeValueRepository;
import pt05.com.sg.service.RuleCodeValueService;

@Service
public class RuleCodeValueServiceImpl implements RuleCodeValueService{
	
	@Autowired
	private  RuleCodeValueRepository ruleCodeValueRepository;
	
	public List<RuleCodeValue> getList() {
		return (List<RuleCodeValue>) this.ruleCodeValueRepository.findAll();
	}
	
	public RuleCodeValue addOrUpdate(RuleCodeValue ruleCodeValue) {
		return this.ruleCodeValueRepository.save(ruleCodeValue);
	}

}
