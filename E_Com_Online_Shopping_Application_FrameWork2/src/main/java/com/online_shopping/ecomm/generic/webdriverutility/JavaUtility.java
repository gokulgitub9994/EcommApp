package com.online_shopping.ecomm.generic.webdriverutility;

import java.util.Random;

public class JavaUtility {
	
	public int getRandomNum(int num) {
		Random random = new Random();
		int randomNum = random.nextInt(num);
		return randomNum;
	}

}
