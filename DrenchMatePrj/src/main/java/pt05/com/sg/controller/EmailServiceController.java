package pt05.com.sg.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException;
import pt05.com.sg.data.dto.SendMailDto;
import pt05.com.sg.data.dto.response.EmailRS;
import pt05.com.sg.service.impl.EmailServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1")
public class EmailServiceController {
	private static final Logger log = LoggerFactory.getLogger(EmailServiceController.class);
	
	@Autowired
	private EmailServiceImpl emailServiceImpl ;
	
	/*@GetMapping("/sendEmail")
    public String sendEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String text) {
        try {
        	emailServiceImpl.sendEmail(to, subject, text);
            return "Email sent successfully!";
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Failed to send email.";
        }
    }*/
	
	@PostMapping(value = "/sendEmail")
	 public ResponseEntity<EmailRS> sendEmail( @RequestBody SendMailDto sendMailDto) {

	        boolean result = this.emailServiceImpl.sendEmailWithTemplate(sendMailDto);
	        EmailRS emailRS = new EmailRS();;
	        log.info("Send Email Trigger");
	        
	        try {
	        	if(result) {
		        	emailRS.setMessage(sendMailDto.getTo()+":Email Send out Successfully");
		        	emailRS.setStatus(true);
		        	return new ResponseEntity<>(emailRS, HttpStatus.OK);
		        }else {
		        	emailRS.setMessage(sendMailDto.getTo()+":Unable to send email");
		        	emailRS.setStatus(false);
		        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(emailRS);
		        }
		        
	        }catch(Exception e) {
	        	emailRS.setMessage( e.getMessage());
	        	emailRS.setStatus(false);
	        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(emailRS);
	        }

	    }
	

}
