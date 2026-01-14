package com.comcast.crm.others;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.generic.webdriverutility.WebDriverUtility;

public class DataProviderExample {
	@DataProvider
	public Object[][] getData() throws Throwable{
		ExcelUtility excel=new ExcelUtility();
		int rowCount=excel.getRowCount("organization");
		int cellCount=excel.getCellCount("organization", rowCount);
		Object[][] objdata=new Object[rowCount][cellCount];
	
		for(int i=0;i<rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				objdata[i][j]=excel.getDataFromExcel("organization", i+1, j);
			}
		}
		return objdata;
	}
	
	
	@Test(dataProvider="getData")
	public void receiveDataProviderData(String TCNO,String orgName,String email,String phNo) {
		System.out.println(TCNO+"  "+orgName+"  "+email+"  "+phNo);
		
	}

}
