package com.ggm.spring.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.ggm.spring.persistence.SearchParameters;

public class AppConfig {
	
	public static ApplicationContext factory =
    		new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Bean
	@Scope("prototype")
	public User getUser() {
		return new User();
	}
	
	@Bean
	@Scope("prototype")
	public Admin getAdmin() {
		return new Admin();
	}	
	
	@Bean
	@Scope("prototype")
	public SearchParameters getSearchParameters() {
		return new SearchParameters();
	}	
}
