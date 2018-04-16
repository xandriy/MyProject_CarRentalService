package ua.springboot.web.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class GenerateRandomData {
	
	public static String generateRandomToken() {
		return RandomStringUtils.randomAlphabetic(100);
	}
	
	public static String generateRandomRecoveryrKey() {
		return RandomStringUtils.randomAlphabetic(10);
	}
	
}
