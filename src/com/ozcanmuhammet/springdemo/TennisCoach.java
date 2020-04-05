package com.ozcanmuhammet.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
@Component
//@Scope("prototype")
public class TennisCoach implements Coach {

	/*
	 * Autowired annotation için; 1-İlgili bean i parametre alan constructor üzerine
	 * yazılabilir 2- İlgili bean için setter method üzerine yazılabilir 3- Herhangi
	 * bir metod üzerine yazılabilir 4- Doğrudan ilgili field üzerine
	 * yazılabilir.(private da olsa) (Reflection)
	 * 
	 */
	// 4 nolu yöntem
	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;

	// 1 nolu yöntem
//	@Autowired
//	public TennisCoach(FortuneService theFortuneService) {
//		this.fortuneService = theFortuneService;
//	}

	// define a default constructor
	public TennisCoach() {
		System.out.println(">>TennisCoach: inside default constructor");
	}

	// define a setter method (2 nolu yöntem)
//	@Autowired
//	public void setFortuneService(FortuneService theFortuneService) {
//		System.out.println(">>TennisCoach: inside setFortuneService() method");
//		this.fortuneService = theFortuneService;
//	}

	// 3 nolu yöntem (method injection)
//	@Autowired
//	public void doSomeStuff(FortuneService theFortuneService) {
//		System.out.println(">>TennisCoach: inside doSomeStuff() method");
//		this.fortuneService = theFortuneService;
//	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	// define my init metod
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("TennisCoach: inside of doMyStartupStuff()");
	}

	// define my destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("TennisCoach: inside of doMyCleanupStuff()");
	}
}
