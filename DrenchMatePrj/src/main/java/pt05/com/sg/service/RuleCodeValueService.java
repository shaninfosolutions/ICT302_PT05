package pt05.com.sg.service;

import java.util.List;

import pt05.com.sg.data.dto.RuleCodeValueDto;

public interface RuleCodeValueService {
	
	public List<RuleCodeValueDto> getRuleByCodeId(String ruleCode);

}
