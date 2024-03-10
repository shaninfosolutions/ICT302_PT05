package pt05.com.sg.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import mmk.com.sg.aes.EncryptDecrypt;
import pt05.com.sg.controller.UserController;
import pt05.com.sg.data.dto.SendMailDto;
import pt05.com.sg.data.entity.EmailTemplate;
import pt05.com.sg.data.repository.EmailTemplateRepository;
import pt05.com.sg.service.EmailServcie;


import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EmailServiceImpl implements EmailServcie{
	
	private static final Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);

	@Autowired
	private Environment environment;

	@Value("${spring.mail.username}")
	private String from;
	
	@Value("${spring.mail.password}")
	private String password;
	
	@Value("${email.template.location}")
	private String templatePath;
	
	@Autowired
	private  JavaMailSender sender;

	@Autowired
	private  Configuration configuration;

	@Autowired
	private  EmailTemplateRepository emailTemplateRepository;

	@Override
	public boolean sendEmailWithTemplate(SendMailDto sendMailDto) {
		 Optional<EmailTemplate> byTemplateNumber =
				 emailTemplateRepository.findByEmailTemplateId(Long.valueOf(1000));

	        if(!byTemplateNumber.isPresent()) {
	        	log.info("byTemplateNumber not found" + sendMailDto.getTemplateNumber());
	        	return false;
	        }
	        else {
	        	log.info("Template found" );
	        }


	        EmailTemplate templateDb = byTemplateNumber.get();

	        MimeMessage mimeMessage = sender.createMimeMessage();

	        try {
	            ClassLoader classLoader = getClass().getClassLoader();
	            String fileName = templateDb.getTemplateName() +".ftl";
	            
	            String str=classLoader.getResource(".").getFile() + "/templates/" + fileName;
	            log.info("Email Template Template file path  " +str);
	            File file = new File(classLoader.getResource(".").getFile() + "/templates/" + fileName);
	            file.createNewFile();

	            List<String> lines = Arrays.asList(templateDb.getEmailTemplate());


	            Files.write(file.toPath(), lines, StandardCharsets.UTF_8);

	            MimeMessageHelper helper = new MimeMessageHelper( mimeMessage,
	                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
	                    StandardCharsets.UTF_8.name() );

	            Template template = configuration.getTemplate(fileName);
	            String htmlTemplate = FreeMarkerTemplateUtils.processTemplateIntoString(template, sendMailDto.getValues());
	            helper.setFrom(from);
	            helper.setTo(sendMailDto.getTo());
	            helper.setText(htmlTemplate, true);
	            helper.setSubject(sendMailDto.getSubject());
	            log.info("Email Send Begin from:" + from+": to"+sendMailDto.getTo());
	            sender.send(mimeMessage);
	            log.info("Email Send End from:" + from+": to"+sendMailDto.getTo());
	            return true;

	        }catch (MessagingException | IOException | TemplateException ex) {
	            ex.printStackTrace();
	            return false;
	        }
	}

	public boolean sendEmail(String to, String subject, String text)  {
		
		try {
			MimeMessage message = sender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
	        helper.setFrom(from);
	        helper.setTo(to);
	        helper.setSubject(subject);
	        helper.setText(text);
	        log.info("Email Send Begin from:" + from+": to:"+to);
	        sender.send(message);
	        log.info("Email Send End from:" + from+": to:"+to);
        return true;
		}catch (MessagingException ex) {
            ex.printStackTrace();
            return false;
        }
	}
	
	

}
