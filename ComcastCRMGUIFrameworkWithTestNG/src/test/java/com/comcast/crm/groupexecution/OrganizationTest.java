package com.comcast.crm.groupexecution;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.generic.baseclass.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganization;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;
import com.comcast.crm.objectrepositoryutility.OrgnizationInfoPage;
import com.comcast.generic.webdriverutility.JavaUtility;
import com.comcast.generic.webdriverutility.WebDriverUtility;
//@Listeners(com.comcast.crm.listenerUtility.ListenerImplimentation.class)
public class OrganizationTest extends BaseClass {
	SoftAssert softAssertObj=new SoftAssert();
	@Test(groups="SmokeTesting")
	public void createOrganizationTest() throws Throwable  {
		System.out.println("------createOrganizationTest------");
		HomePage homepage=new HomePage(driver);
        homepage.getOrganizationLink().click();
		
        OrganizationPage newOrgBtn=new OrganizationPage(driver);
        newOrgBtn.getCreateNewOrganizationBtn().click();
		
		String orgName=excel.getDataFromExcel("org", 1, 2)+javaUtility.getRandomNumber();
		
		CreateNewOrganization createNewOrg =new CreateNewOrganization(driver);
		createNewOrg.createOrgName(orgName);
		createNewOrg.getSaveBtn().click();
		
		Thread.sleep(2000);
		OrgnizationInfoPage orgInfo=new OrgnizationInfoPage(driver);
		String headerName=orgInfo.getHeaderMsg().getText();
		boolean status=headerName.contains(orgName);
		Assert.assertEquals(status, true);
//		if(headerName.contains(orgName))
//		{
//			System.out.println(orgName+" is cread succesfully==PASS");
//		}
//		else {
//			System.out.println(orgName+" is not cread ++FAIL");
//		}
		String actOrgName=orgInfo.getActOrgName().getText();
		Assert.assertEquals(actOrgName.trim(), orgName);
		/*
		 * if(actOrgName.trim().equals(orgName)) {
		 * System.out.println(orgName+"is cread succesfully==PASS"); } else {
		 * System.out.println(orgName+" is not cread ++FAIL"); }
		 */
		Thread.sleep(4000);
	}
	@Test(groups="RegressionTesting")
      public void createOrgWithPhNo() throws Throwable  {
		System.out.println("----createOrgWithPhNo----");
		
		HomePage homepage=new HomePage(driver);
        homepage.getOrganizationLink().click();
        
		OrganizationPage orgPage=new OrganizationPage(driver);
		orgPage.getCreateNewOrganizationBtn().click();
		
		String orgName=excel.getDataFromExcel("org", 7, 2)+javaUtility.getAlphanumericRandomNumber();
		String phoneNumber=excel.getDataFromExcel("org", 7, 3);
		
		CreateNewOrganization newOrg=new CreateNewOrganization(driver);
		newOrg.createOrgName(orgName);
		newOrg.getPhoneNumber().sendKeys(phoneNumber);
		newOrg.getSaveBtn().click();
	
		Thread.sleep(2000);
		OrgnizationInfoPage orgInfo=new OrgnizationInfoPage(driver);
		String actPhoneNumber=orgInfo.getPhNo().getText();
		
		System.out.println(phoneNumber);
     	System.out.println(actPhoneNumber);
     	
     	softAssertObj.assertEquals(actPhoneNumber.trim(), phoneNumber);
		/*
		 * if(actPhoneNumber.trim().equals(phoneNumber)) {
		 * System.out.println(phoneNumber+" PhoneNumber is verified==PASS"); } else {
		 * System.out.println(phoneNumber+" PhoneNumber is not valid==FAIL"); }
		 */
    	Thread.sleep(4000);
     	softAssertObj.assertAll();
	
	}

	@Test(groups="RegressionTesting")
	public void CreateOrgWithIndustry()throws Throwable  {
		System.out.println("----CreateOrgWithIndustry-----");
		HomePage homepage=new HomePage(driver);
        homepage.getOrganizationLink().click();
		
		OrganizationPage orgPage=new OrganizationPage(driver);
		orgPage.getCreateNewOrganizationBtn().click();
		
		String orgName=excel.getDataFromExcel("org", 4, 2)+javaUtility.getRandomNumber();
		String industry=excel.getDataFromExcel("org", 4, 3);
		String type=excel.getDataFromExcel("org", 4, 4);
		
		CreateNewOrganization newOrg=new CreateNewOrganization(driver);
		newOrg.createOrgName(orgName, industry,type);
		Thread.sleep(4000);
		
		OrgnizationInfoPage orgInfo=new OrgnizationInfoPage(driver);
		orgInfo.getIndustryName().getText();
		String actIndustryName=orgInfo.getIndustryName().getText();
		System.out.println(actIndustryName);
		
		softAssertObj.assertEquals(actIndustryName.trim(),industry);
		/*
		 * if(actIndustryName.trim().equals(industry)) {
		 * System.out.println(industry+" information is verified==PASS"); } else {
		 * System.out.println(industry+" information is not verified==FAIL"); }
		 */
		
		String actType=orgInfo.getTypeName().getText();
		System.out.println(actType);
		
		softAssertObj.assertEquals(actType.trim(),type);
		/*
		 * if(actType.trim().equals(type)) {
		 * System.out.println(type+"information is  verified==PASS"); } else {
		 * System.out.println(type+" information is not verified==FAIL"); }
		 */
		softAssertObj.assertAll();
	}
}
