package pt05.com.sg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1")
public class RuleCodeController {
	private static final Logger log = LoggerFactory.getLogger(RuleCodeController.class);
	
}
