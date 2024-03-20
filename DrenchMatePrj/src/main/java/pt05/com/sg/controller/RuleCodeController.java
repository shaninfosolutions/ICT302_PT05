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

import pt05.com.sg.data.dto.NoteDto;
import pt05.com.sg.data.dto.RuleCodeDto;
import pt05.com.sg.service.impl.NoteServiceImpl;
import pt05.com.sg.service.impl.RuleCodeServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1")
public class RuleCodeController {
	private static final Logger log = LoggerFactory.getLogger(RuleCodeController.class);
	
	@Autowired
	private RuleCodeServiceImpl ruleCodeServiceImpl;
	
	@GetMapping("/dm/rules")
	@ResponseStatus(value = HttpStatus.OK)
	public List<RuleCodeDto>findAllNotes() {
			log.info("Find All Rule Code");
	   	 return this.ruleCodeServiceImpl.getList();
	}
	
	
	@GetMapping("/dm/rules/{ruleCodeId}")
	@ResponseStatus(value = HttpStatus.OK)
	public RuleCodeDto findNoteById(
			@PathVariable("ruleCodeId") Long ruleCodeId){
		log.info("Get RuleCode by ruleCodeId :"+ ruleCodeId);
		return this.ruleCodeServiceImpl.getRuleByCodeId(ruleCodeId);
		
	
	}
	
	
	
}
