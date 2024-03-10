package pt05.com.sg.service;

import pt05.com.sg.data.dto.SendMailDto;

public interface EmailServcie {

	 public boolean sendEmail( String to, String subject, String text );
	 
	 public boolean sendEmailWithTemplate(SendMailDto sendMailDto) ;
}
