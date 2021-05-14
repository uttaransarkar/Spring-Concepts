package com.uttaran.springdemo;

import java.util.Random;

public class RandomFortune implements FortuneService {

	@Override
	public String getFortune() {
		
		String randomFortune[] = {"Lucky day", "Hard luck", "Expect the unexpected"};
		Random random = new Random();
		int randNum = random.nextInt(3);
		
		return randomFortune[randNum];
	}

}
