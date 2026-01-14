package com.comcast.crm.generic.baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.generic.webdriverutility.JavaUtility;
import com.comcast.generic.webdriverutility.WebDriverUtility;

public class BaseClassAnnotationVerification {
	  public  WebDriver  driver=null;
	    public static  WebDriver  sdriver=null;
		public  FileUtility fileutility=new FileUtility();
		public  ExcelUtility excel=new ExcelUtility();
		public  WebDriverUtility webDriverUtility=new WebDriverUtility();
		public  JavaUtility javaUtility=new JavaUtility();
		public  DataBaseUtility dataBaseUtility=new DataBaseUtility();
	
   @BeforeSuite
   public void dconnectToDB() throws Throwable
   {
		System.out.println("--d--connected to DB-----");
		
   }
	@BeforeSuite
      public void connectToDB() throws Throwable
      {
		System.out.println("---connected to DB-----");
		
      }
	@BeforeSuite
    public void aconnectToDB() throws Throwable
    {
		System.out.println("---a connected to DB-----");
		
    }
	
	
	@BeforeClass
	public void openBrowser() throws Throwable
	  {
		System.out.println("-----BC-----");
		driver=new ChromeDriver();
	
	  }
	@BeforeClass
	public void aopenBrowser() throws Throwable
	  {
		System.out.println("---a--BC-----");
		driver=new ChromeDriver();
	
	  }
	@BeforeMethod
	  public void login() throws Throwable
	  {
		System.out.println("----BM----");
		System.out.println("----BM----");
		webDriverUtility.waitForPageToLoad(driver);
		String url=fileutility.getDataFromPropertyFile("url");
		String userName=fileutility.getDataFromPropertyFile("username");
		String password=fileutility.getDataFromPropertyFile("password");  
		driver.get(url);
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(userName, password);
		
	  }
	@BeforeMethod
	  public void alogin() throws Throwable
	  {
		System.out.println("--a--BM----");
		
		sdriver.get("facebook.com");
	  }
	@AfterMethod
	  public void logOut()
	  {
		System.out.println("----AM-----");
		
	  }
	@AfterMethod
	  public void alogOut()
	  {
		System.out.println("--a--AM-----");
		
	  }
	@AfterClass
	  public void closeBrowser()
	  {
		System.out.println("-----AC-----");
		  driver.quit();
	  }
	@AfterClass
	  public void acloseBrowser()
	  {
		System.out.println("--a---AC-----");
		  driver.quit();
	  }
	@AfterSuite
	  public void closeDBConnection() throws Throwable
	  {
		System.out.println("------AS----");
		
	  }
	@AfterSuite
	  public void acloseDBConnection() throws Throwable
	  {
		System.out.println("--a----AS----");
		
	  }

}
