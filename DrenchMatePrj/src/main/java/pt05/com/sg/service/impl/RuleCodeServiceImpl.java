package pt05.com.sg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt05.com.sg.data.entity.RuleCode;
import pt05.com.sg.data.repository.RuleCodeRepository;
import pt05.com.sg.service.RuleCodeService;

@Service
public class RuleCodeServiceImpl implements RuleCodeService{
	
	@Autowired
	private  RuleCodeRepository ruleCodeRepository;
	
	public List<RuleCode> getList() {
		return (List<RuleCode>) this.ruleCodeRepository.findAll();
	}
	
	public RuleCode addOrUpdate(RuleCode ruleCode) {
		return this.ruleCodeRepository.save(ruleCode);
	}
	
}
