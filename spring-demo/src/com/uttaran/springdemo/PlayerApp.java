package com.uttaran.springdemo;

public class PlayerApp {

	public static void main(String[] args) {
		
		//generic object of type 'Coach'
		Coach coach = new FootballCoach();
		System.out.println(coach.getDailyWorkout());

	}

}
