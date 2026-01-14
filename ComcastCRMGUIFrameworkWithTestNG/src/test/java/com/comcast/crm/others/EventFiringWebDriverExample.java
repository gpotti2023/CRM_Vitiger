package com.comcast.crm.others;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.baseclass.BaseClass;

public class EventFiringWebDriverExample extends BaseClass {
	
	@Test
	public void loginPageVerify() {
		System.out.println("started");
		       String title= driver.getTitle();
		       Assert.assertEquals(title, "Login");
				EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
				//TakesScreenshot edriver=(TakesScreenshot)BaseClass.lsdriver;
				File src=edriver.getScreenshotAs(OutputType.FILE);
				try {
					FileUtils.copyFile(src, new File("./screenshots/test.png"));
				} catch (IOException e) {
					
					e.printStackTrace();
				}
	
		
	}

}
