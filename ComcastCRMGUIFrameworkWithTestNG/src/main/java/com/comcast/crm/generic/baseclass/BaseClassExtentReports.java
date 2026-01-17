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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.generic.webdriverutility.JavaUtility;
import com.comcast.generic.webdriverutility.UtilityClassObject;
import com.comcast.generic.webdriverutility.WebDriverUtility;

public class BaseClassExtentReports {
	
	public  WebDriver  driver=null;
    public static  WebDriver  sdriver=null;
	public  FileUtility fileutility=new FileUtility();
	public  ExcelUtility excel=new ExcelUtility();
	public  WebDriverUtility webDriverUtility=new WebDriverUtility();
	public  JavaUtility javaUtility=new JavaUtility();
	public  DataBaseUtility dataBaseUtility=new DataBaseUtility();
	
	public ExtentReports report;
	public ExtentTest test;
	
	@BeforeSuite(groups= {"SmokeTesting","RegressionTesting"})
      public void connectToDB() throws Throwable
      {
		System.out.println("---connected to DB-----");
		dataBaseUtility.getConnection("jdbc:mysql://49.249.28.218:3307/Ninza_HRM","root@%", "root");
		
		 System.out.println("Base class conflict");
        System.out.println("Base class conflict");
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvencedReports/basetest.html");
		spark.config().setDocumentTitle("CRM_Application");
		spark.config().setReportName("CRM_Report");
		spark.config().setTheme(Theme.DARK);
		
	    report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		test = report.createTest("Create");
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
		//sdriver=driver;
		UtilityClassObject.setDriver(driver);
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
		
		report.flush();
	  }

	

}
