package com.comcast.crm.others;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleRetryClass {
	
	@Test(retryAnalyzer = com.comcast.crm.listenerUtility.RetryAnalyzerImplimentation.class)
	public void retryTest()
	{
		System.out.println("--------------------------------");
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertEquals("Home", "login");
		System.out.println("Step3");
		System.out.println("Step4");
		System.out.println("Step5");
		System.out.println("Step6");
	}

}
