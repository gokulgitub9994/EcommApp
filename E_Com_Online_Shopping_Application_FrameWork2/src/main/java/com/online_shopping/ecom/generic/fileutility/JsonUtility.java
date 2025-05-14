package com.online_shopping.ecom.generic.fileutility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {
	
	public String getDataFromJsonFile(String key) throws Throwable {
		
		FileReader fRs = new FileReader("C:\\Users\\T470\\eclipse-workspace\\E_Com_Online_Shopping_Application_FrameWork\\confgAppData\\ecommLogin.json");
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(fRs);
		JSONObject map = (JSONObject)obj;
		String data =  map.get(key).toString();
		
		return data;
		
	}

}
