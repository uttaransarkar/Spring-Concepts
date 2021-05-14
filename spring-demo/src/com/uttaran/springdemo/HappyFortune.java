package com.uttaran.springdemo;

public class HappyFortune implements FortuneService {

	@Override
	public String getFortune() {
		
		return "You're gonna get lucky today!";
	}

}
