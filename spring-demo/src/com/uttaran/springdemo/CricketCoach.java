package com.uttaran.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	//new fields for email and team
	private String emailId;
	private String team; 
	
	public CricketCoach() {
		System.out.println("Inside default constructor");
	}
	
	public String getEmailId() {
		return emailId;
	}


	public String getTeam() {
		return team;
	}


	public void setEmailId(String emailId) {
		
		System.out.println("Inside setter method for email!");
		this.emailId = emailId;
	}

	public void setTeam(String team) {
		
		System.out.println("Inside setter method for team!");
		this.team = team;
	}

	public void setFortuneService(FortuneService fortuneService) {
		
		System.out.println("Inside setter method for FortuneService!");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "20 minutes high catching";
	}
	
	//dependency injection via getters
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
