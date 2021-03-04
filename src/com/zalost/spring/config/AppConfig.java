package com.zalost.spring.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.zalost.spring.mvc.*;

@Configuration
public class AppConfig {
	
	public static ApplicationContext factory =
    		new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Bean
	@Scope("prototype")
	public User getUser() {
		return new User();
	}
}
