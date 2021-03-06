package com.cdh.sms.token;

import java.util.Random;

public class TknGenerator {
	private static final char[] nums_n_letts = 
	{
		'0','1','2','3','4','5','6','7','8','9',
		'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
		'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
	};
	private static final int NUMS_N_LETTS_SIZE = 61;
	private static final int TOKEN_SIZE = 30;

	public TknGenerator(){
	}
	
	public static String makeToken() {
		Random gen = new Random( System.currentTimeMillis() );
		String token = "";
		
		for( int i = 0; i < TOKEN_SIZE; i++ ){
			token += nums_n_letts[ Math.abs(gen.nextInt()) % NUMS_N_LETTS_SIZE ];
		}
		
		return token;
	}
}
