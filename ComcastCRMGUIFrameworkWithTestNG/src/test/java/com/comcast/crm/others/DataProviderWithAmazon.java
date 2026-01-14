package com.comcast.crm.others;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class DataProviderWithAmazon {
	
	@DataProvider
	public Object[][] getData() throws Throwable{
		ExcelUtility excel=new ExcelUtility();
		int rowCount=excel.getRowCount("AppleMobiles");
		int cellCount=excel.getCellCount("AppleMobiles", rowCount);
		Object[][] objdata=new Object[rowCount][cellCount];
	
		for(int i=0;i<rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				objdata[i][j]=excel.getDataFromExcel("AppleMobiles", i+1, j);
			}
		}
		return objdata;
	}
	
	
	@Test(dataProvider="getData")
	public void receiveProduct(String brandName,String productName) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName+Keys.ENTER);
		String price=driver.findElement(By.xpath("//span[text()='"+productName+"']/../../../..//div[3]//a//span[@class='a-price-whole']")).getText();
	    System.out.println(price);
	
	driver.quit();
	}

}
