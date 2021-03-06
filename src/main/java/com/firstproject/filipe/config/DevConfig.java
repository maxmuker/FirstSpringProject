package com.firstproject.filipe.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.firstproject.filipe.services.DBService;
import com.firstproject.filipe.services.EmailService;
import com.firstproject.filipe.services.SmtpEmailService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBService dbService;

	
	@Bean
	public boolean instantiateDataBase() throws ParseException {
		


		dbService.instantiateTestDataBase();
		return true;
		
		
	}
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
	
}
