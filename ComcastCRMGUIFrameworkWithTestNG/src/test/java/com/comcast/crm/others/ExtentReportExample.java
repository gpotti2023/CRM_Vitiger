package com.comcast.crm.others;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.baseclass.BaseClassExtentReports;

public class ExtentReportExample extends BaseClassExtentReports {
	@Test
	public void create()
	{
//		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvencedReports/test.html");
//		spark.config().setDocumentTitle("CRM_Application");
//		spark.config().setReportName("CRM_Report");
//		spark.config().setTheme(Theme.DARK);
//		
//		ExtentReports report=new ExtentReports();
//		report.attachReporter(spark);
//		report.setSystemInfo("OS", "Windows-11");
//		ExtentTest test = report.createTest("Create");
		test.log(Status.INFO, "created");
		test.log(Status.PASS, "successfully created");
		TakesScreenshot ts=(TakesScreenshot)driver;
		String filePath=ts.getScreenshotAs(OutputType.BASE64);
		
		if("HDFCc".equals("HDFC"))
		{
		test.log(Status.PASS, "created page");
		}else {
			//test.log(Status.FAIL, "created page");
			test.addScreenCaptureFromBase64String(filePath, "ErrorFile");
		}
		
	}
	
	

}
