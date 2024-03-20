package pt05.com.sg.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt05.com.sg.data.dto.RuleCodeDto;
import pt05.com.sg.data.dto.RuleCodeValueDto;
import pt05.com.sg.data.entity.RuleCode;
import pt05.com.sg.data.entity.RuleCodeValue;
import pt05.com.sg.data.repository.RuleCodeValueRepository;
import pt05.com.sg.service.RuleCodeValueService;

@Service
public class RuleCodeValueServiceImpl implements RuleCodeValueService{
	private static final Logger log = LoggerFactory.getLogger(RuleCodeValueServiceImpl.class);
	
	@Autowired
	private  RuleCodeValueRepository ruleCodeValueRepository;
	
	public List<RuleCodeValueDto> getRuleByCodeId(String ruleCode) {
		log.info("Get Code Value By Rule Code: " + ruleCode);
		Optional<List<RuleCodeValue>> ruleCodeValueList = this.ruleCodeValueRepository.findCodeValueByCode(ruleCode);
		
		List<RuleCodeValueDto> ruleCodeValueDto = new ArrayList<>();
		try {
			if (ruleCodeValueList.isPresent() && ruleCodeValueList.get() != null) {
				
				for(RuleCodeValue cv: ruleCodeValueList.get()) {
					
					RuleCodeValueDto dto=new RuleCodeValueDto();
					dto.setCode(cv.getCode());
					dto.setCodeValue(cv.getCodeValue());
					dto.setRuleCodeValueId(cv.getRuleCodeValueId());
					dto.setRemarks(cv.getRemarks());
					dto.setCodeDesc(cv.getCodeDesc());
					ruleCodeValueDto.add(dto);
				}
				
			}else {
				ruleCodeValueDto=null;
			}
		
		}catch (Exception e) {
			log.info("System Exception");
		}
		 
		 return ruleCodeValueDto;
	}

}
