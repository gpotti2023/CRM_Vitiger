package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	public String getDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./ConfigAppData/commandata.properties");
		
		Properties property=new Properties();
		property.load(fis);
		String data=property.getProperty(key);
		return data;
		
	}

}
