package com.online_shopping.ecom.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {

	public String getDataFromPropertyFile(String key) throws Throwable {
		FileInputStream fIs = new FileInputStream("C:\\Users\\T470\\eclipse-workspace\\E_Com_Online_Shopping_Application_FrameWork\\confgAppData\\ecommLogin.properties");
		Properties prop = new Properties();
		prop.load(fIs);
		String data = prop.getProperty(key);
		return data;
	}
}
