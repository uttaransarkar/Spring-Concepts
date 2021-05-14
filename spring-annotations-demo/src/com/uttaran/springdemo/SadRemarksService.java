package com.uttaran.springdemo;

import org.springframework.stereotype.Component;

@Component
public class SadRemarksService implements RemarksService {

	@Override
	public String getRemarks() {
		return "Below average!";
	}

}
