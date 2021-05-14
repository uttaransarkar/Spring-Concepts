package com.uttaran.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomRemarksService implements RemarksService {
	
	private String arr[] = {"Well done!", "Be more specific", "Not satisfactory"};
	private Random rand = new Random();
	
	@Override
	public String getRemarks() {
		
		int randNum = rand.nextInt(arr.length); 
		return arr[randNum];
	}

}
