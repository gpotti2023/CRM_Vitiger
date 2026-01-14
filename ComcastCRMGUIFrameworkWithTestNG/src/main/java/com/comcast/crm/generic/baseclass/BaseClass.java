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

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.generic.webdriverutility.JavaUtility;
import com.comcast.generic.webdriverutility.UtilityClassObject;
import com.comcast.generic.webdriverutility.WebDriverUtility;

public class BaseClass {
    public  WebDriver  driver=null;
    public static  WebDriver  sdriver=null;
	public  FileUtility fileutility=new FileUtility();
	public  ExcelUtility excel=new ExcelUtility();
	public  WebDriverUtility webDriverUtility=new WebDriverUtility();
	public  JavaUtility javaUtility=new JavaUtility();
	public  DataBaseUtility dataBaseUtility=new DataBaseUtility();
	
	@BeforeSuite(groups= {"SmokeTesting","RegressionTesting"})
      public void connectToDB() throws Throwable
      {
		System.out.println("---connected to DB-----");
		dataBaseUtility.getConnection("jdbc:mysql://49.249.28.218:3307/Ninza_HRM","root@%", "root");
      }
	
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"SmokeTesting","RegressionTesting"})
	 // public void openBrowser(String browser) throws Throwable
	public void openBrowser() throws Throwable
	  {
		System.out.println("-----BC-----");
		String browser=fileutility.getDataFromPropertyFile("browser");
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}else if(browser.equals("fireFox"))
		{
			driver=new FirefoxDriver();
		}else if(browser.equals("edge"))
		{
			driver=new EdgeDriver();
		}else 
		{
			driver=new ChromeDriver();
		}
		sdriver=driver;
		//UtilityClassObject.setDriver(driver);
	  }
	@BeforeMethod(groups= {"SmokeTesting","RegressionTesting"})
	  public void login() throws Throwable
	  {
		System.out.println("----BM----");
		webDriverUtility.waitForPageToLoad(driver);
		String url=fileutility.getDataFromPropertyFile("url");
		String userName=fileutility.getDataFromPropertyFile("username");
		String password=fileutility.getDataFromPropertyFile("password");  
		driver.get(url);
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(userName, password);
	  }
	@AfterMethod(groups= {"SmokeTesting","RegressionTesting"})
	  public void logOut()
	  {
		System.out.println("----AM-----");
	
		HomePage homePage=new HomePage(driver);
		homePage.logOut();
	  }
	@AfterClass(groups= {"SmokeTesting","RegressionTesting"})
	  public void closeBrowser()
	  {
		System.out.println("-----AC-----");
		  driver.quit();
	  }
	@AfterSuite(groups= {"SmokeTesting","RegressionTesting"})
	  public void closeDBConnection() throws Throwable
	  {
		System.out.println("------AS----");
		dataBaseUtility.closeDBConnection(); 
	  }

}
