package com.uttaran.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyRemarksService implements RemarksService {

	@Override
	public String getRemarks() {
		
		return "Well done!";
	}

}
