package com.comcast.crm.others;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.generic.webdriverutility.JavaUtility;
import com.comcast.generic.webdriverutility.WebDriverUtility;

public class OrgCalculator {
public static void main(String[] args) throws Throwable  {
		
		FileUtility fileutility=new FileUtility();
		ExcelUtility excel=new ExcelUtility();
		WebDriverUtility webDriverUtility=new WebDriverUtility();
		JavaUtility javaUtility=new JavaUtility();
		
		String browser=fileutility.getDataFromPropertyFile("browser");
		String url=fileutility.getDataFromPropertyFile("url");
		String userName=fileutility.getDataFromPropertyFile("username");
		String password=fileutility.getDataFromPropertyFile("password");
		
		WebDriver driver;
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}else if(browser.equals("fireFox"))
		{
			driver=new FirefoxDriver();
		}else if(browser.equals("fireFox"))
		{
			driver=new EdgeDriver();
		}else 
		{
			driver=new ChromeDriver();
		}
		
		webDriverUtility.waitForPageToLoad(driver);
		driver.get(url);
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.getUserName().sendKeys(userName);
		loginPage.getPassWord().sendKeys(password);
		loginPage.getLoginBtn().click();
		
		HomePage homePage=new HomePage(driver);
		homePage.getOrganizationLink().click();
		
		Scanner sc=new Scanner(System.in);
		
		driver.findElement(By.xpath("//img[@alt='Open Calculator...']")).click();
		driver.findElement(By.name("calc5")).click();
		driver.findElement(By.name("multiply")).click();
		driver.findElement(By.name("calc5")).click();
		driver.findElement(By.name("equal")).click();
	    String value=driver.findElement(By.name("answer")).getAttribute("value");
		System.out.println(value);
}	
}
