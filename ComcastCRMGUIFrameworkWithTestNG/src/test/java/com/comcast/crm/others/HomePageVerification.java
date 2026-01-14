package com.comcast.crm.others;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.baseclass.BaseClass;

public class HomePageVerification extends BaseClass {
	
	@Test(retryAnalyzer =com.comcast.crm.listenerUtility.RetryAnalyzerImplimentation.class)
	public void homepageTitle() {
		System.out.println("Script starts");
		String expTitle="Home";
		String actTitle=driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		Assert.assertEquals(actTitle, expTitle);
		/*
		 * if(actTitle.trim().equals(expTitle)) { System.out.println("equal"); } else {
		 * System.out.println("not equal"); }
		 */
		System.out.println("Script Ends");
	}
	
	@Test
	public void logoVerification() {
		System.out.println("LogoVerication starts");
		boolean status=driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isDisplayed();
		Assert.assertTrue(status);
		System.out.println("logo is displayed");
		System.out.println("logoVerification ends");
		
	}

}
