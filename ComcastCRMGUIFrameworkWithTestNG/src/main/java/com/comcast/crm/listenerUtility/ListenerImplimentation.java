package com.comcast.crm.listenerUtility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.baseclass.BaseClass;
import com.comcast.generic.webdriverutility.UtilityClassObject;

public class ListenerImplimentation implements ITestListener,ISuiteListener{

	public   ExtentReports report;
	public static ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		Reporter.log(suite.getName()+"----Report configuration started----");
		String timestamp=new Date().toString().replace(" ", "_").replace(":","_");
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvencedReports/testreports"+timestamp+".html");
		spark.config().setDocumentTitle("CRM_Application");
		spark.config().setReportName("CRM_Report");
		spark.config().setTheme(Theme.DARK);
		
	    report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
	}

	@Override
	public void onFinish(ISuite suite) {
		String testName=suite.getName();
		Reporter.log(testName+" is onFinish strted()-----",true);
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		Reporter.log(testName+"----onTestStart--->",true);
		test=report.createTest(testName);
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, testName+"-----started----");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		Reporter.log(testName+" is onTestSuccess",true);
		test.log(Status.PASS, testName+ "  Completede successfully ");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		String timestamp=new Date().toString().replace(" ", "_").replace(":","_");
		//Reporter.log(testName+" is onTestFailure",true);
		//String timestamp=LocalDateTime.now().toString().replace(" ", "_").replace(":","_");	
		//EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
//		File src=edriver.getScreenshotAs(OutputType.FILE);
//		try {
//			FileUtils.copyFile(src, new File("./screenshots/"+testName+"+"+timestamp+".png"));
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}

		//TakesScreenshot edriver=(TakesScreenshot)BaseClass.sdriver;
		TakesScreenshot edriver=(TakesScreenshot) BaseClass.sdriver;
	    String filePath=edriver.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filePath,testName+"_"+timestamp);
		test.log(Status.FAIL, " ===Failed===> repeat test again");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		Reporter.log(testName+" is onTestSkipped",true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
	
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		
		ITestListener.super.onFinish(context);
	}
	

}
