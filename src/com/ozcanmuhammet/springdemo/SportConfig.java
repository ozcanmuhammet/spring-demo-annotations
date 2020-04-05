package com.ozcanmuhammet.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.ozcanmuhammet.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

	// define bean for our SadFortuneService
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}

	// define bean for our SwimCoach and inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
