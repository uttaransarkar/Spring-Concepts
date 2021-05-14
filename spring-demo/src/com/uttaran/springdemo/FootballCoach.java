package com.uttaran.springdemo;

public class FootballCoach implements Coach {
	
	//defining a private field for dependency
	private FortuneService fortuneService;
		
	//defining the constructors
	public FootballCoach() {}
	
	//dependency injection via constructor
	public FootballCoach(FortuneService newfortuneService) {
		
		fortuneService = newfortuneService;
	}
	
	//getter
	@Override
	public String getDailyWorkout() {
		return "Passing practice for 30 minutes";
	}

	//performing dependency injection via setter
	@Override
	public String getDailyFortune() {
		return "Play hard! " + fortuneService.getFortune();
	}
	
	//adding init method executed during bean initialization
	public void doStartupTask() {
		System.out.println("Inside init() for FootballCoach");
	}
	
	//adding destroy method executed during bean destruction
	public void doCleanupTask() {
		System.out.println("Inside destroy() for FootballCoach");
	}
}
