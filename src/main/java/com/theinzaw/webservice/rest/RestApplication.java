package com.theinzaw.webservice.rest;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class RestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		//SessionLocaleResolver localResolver = new SessionLocaleResolver();
		AcceptHeaderLocaleResolver localResolver  = new AcceptHeaderLocaleResolver();
		localResolver.setDefaultLocale(Locale.US);
		return localResolver;
	}
	
	//can be configured in application.properties
	
	/*
	 * @Bean public ResourceBundleMessageSource bundleMessageSource() {
	 * ResourceBundleMessageSource messageSource = new
	 * ResourceBundleMessageSource(); messageSource.setBasename("messages"); return
	 * messageSource; }
	 */
	

}
