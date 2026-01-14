package com.comcast.crm.others;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.objectrepositoryutility.SamplePage;
import com.comcast.generic.webdriverutility.WebDriverUtility;

public class SampleTestScript {
public static void main(String[] args) throws Throwable  {
		
		FileUtility fileutility=new FileUtility();
		ExcelUtility excel=new ExcelUtility();
		WebDriverUtility webDriverUtility=new WebDriverUtility();
		//JavaUtility javaUtility=new JavaUtility();
		
		//String browser=fileutility.getDataFromPropertyFile("browser");
		String url=fileutility.getDataFromPropertyFile("url");
		String userName=fileutility.getDataFromPropertyFile("username");
		String password=fileutility.getDataFromPropertyFile("password");
		
		WebDriver driver=new ChromeDriver();
		
		webDriverUtility.waitForPageToLoad(driver);
		driver.get(url);
		
		SamplePage sp=new SamplePage(driver);
		sp.loginToApp(userName, password);
		
		 String[][] excelList = excel.readMultipleDataFromExcel("organization");
		int rowCount=excel.getRowCount("organization");
		int cellCount=excel.getCellCount("organization", rowCount);
		for(int i=0;i<rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
			
			System.out.print(excelList[i][j]+" " );
			}
			System.out.println();
		}
		
		Thread.sleep(5000);
		driver.quit();
}


}
