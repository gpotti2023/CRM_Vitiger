package com.comcast.crm.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	public String getDataFromJSON(String key) throws Throwable
	{
        JSONParser parser=new JSONParser();
		Object obj=parser.parse(new FileReader("./ConfigAppData/jsondata.json"));
		JSONObject map=(JSONObject)obj;
		String data=map.get(key).toString();
		return data;
	}

}
