package pt05.com.sg.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pt05.com.sg.data.dto.RuleCodeValueDto;
import pt05.com.sg.service.impl.RuleCodeValueServiceImpl;

@CrossOrigin(origins = "${spring.mvc.cors.allowed-origins}")
@RestController
@RequestMapping("api/v1")
public class RuleCodeValueController {
	private static final Logger log = LoggerFactory.getLogger(RuleCodeValueController.class);
	
	@Autowired
	private RuleCodeValueServiceImpl ruleCodeValueServiceImpl;
	
	@GetMapping("/dm/rule/codevalue/{ruleCode}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<RuleCodeValueDto> findNoteById(
			@PathVariable("ruleCode") String ruleCode){
		log.info("Get RuleCode by ruleCodeId :"+ ruleCode);
		return this.ruleCodeValueServiceImpl.getRuleByCodeId(ruleCode);
		
	
	}

}
