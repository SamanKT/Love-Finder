package com.saman.cl.service;

import org.springframework.stereotype.Service;

@Service
public class LoveCalResultImpl implements LoveCalResult {

	private final String LOVE_CHARS = "FLAMES";
	
	@Override
	public String calculateLove(String userName, String crushName) {
		
		int char_size= (userName+crushName).toCharArray().length;
		int rem = char_size%(LOVE_CHARS.toCharArray().length);
		
		
		return whatIsBetween(rem);
	}

	@Override
	public String whatIsBetween(int rem) {
		switch (rem) {
		case 0:
			return LOVE_Result_Enum.Friend.name();

		case 1:
			return LOVE_Result_Enum.Love.name();
		case 2:
			return LOVE_Result_Enum.Affection.name();
		case 3:
			return LOVE_Result_Enum.Marriage.name();
		case 4:
			return LOVE_Result_Enum.Enemy.name();
		case 5:
			return LOVE_Result_Enum.Sister.name();
		default:
			return "No result";
		}
		
	}
	
	

}
