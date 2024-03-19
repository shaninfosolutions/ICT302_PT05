package pt05.com.sg.service.impl;

import java.util.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt05.com.sg.data.dto.NoteDto;
import pt05.com.sg.data.dto.RuleCodeDto;
import pt05.com.sg.data.entity.RuleCode;
import pt05.com.sg.data.repository.RuleCodeRepository;
import pt05.com.sg.service.RuleCodeService;

@Service
public class RuleCodeServiceImpl implements RuleCodeService{
	private static final Logger log = LoggerFactory.getLogger(RuleCodeServiceImpl.class);
	
	@Autowired
	private  RuleCodeRepository ruleCodeRepository;
	
	public List<RuleCodeDto> getList() {
		//return (List<RuleCode>) this.ruleCodeRepository.findAll();
		
		List<RuleCode> list=(List<RuleCode>) this.ruleCodeRepository.findAll();
		List<RuleCodeDto> ruleCodeDtolist=null;
		try {
			if(list!=null) {
				ruleCodeDtolist=new ArrayList<>();
				for(RuleCode rc:list) {
				 RuleCodeDto dto =new RuleCodeDto();
				 dto.setRuleCodeId(rc.getRuleCodeId());
				 dto.setCode(rc.getCode());
				 dto.setCodeDesc(rc.getCodeDesc());
				 dto.setRemarks(rc.getRemarks());
				 
				 ruleCodeDtolist.add(dto);
				}
			}
			else {
				ruleCodeDtolist=null;
			}
			
		}catch(Exception e) {
		log.info("System Exception");
	}
	return ruleCodeDtolist;
		
	}
	
	public RuleCode addOrUpdate(RuleCode ruleCode) {
		return this.ruleCodeRepository.save(ruleCode);
	}
	
}
