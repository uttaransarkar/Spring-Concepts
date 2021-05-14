package com.uttaran.springdemo;

public class BaseballCoach implements Coach{
	
	//defining a private field for dependency
	private FortuneService fortuneService;
	
	public BaseballCoach() {}


	//defining the constructor
	public BaseballCoach(FortuneService newfortuneService) {
		fortuneService = newfortuneService;
	}
	
	
	@Override
	public String getDailyWorkout() {
		return "15 minutes quick sprints";
	}
	
	//performing dependency injection
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
