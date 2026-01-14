package com.comcast.crm.leadtest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.generic.baseclass.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.objectrepositoryutility.AddNewLeadPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LeadInfoPage;
import com.comcast.crm.objectrepositoryutility.LeadPage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.generic.webdriverutility.JavaUtility;
import com.comcast.generic.webdriverutility.WebDriverUtility;

public class LeadTest extends BaseClass {
	@Test
	public void createLeadWithAssinedTest() throws Throwable  {
		String firstName=excel.getDataFromExcel("lead", 1, 2)+javaUtility.getRandomNumber();
		String lastName=excel.getDataFromExcel("lead", 1, 3)+javaUtility.getRandomNumber();
		String companyName=excel.getDataFromExcel("lead", 1, 4)+javaUtility.getRandomNumber();
	
		HomePage homePage=new HomePage(driver);
		homePage.getLeadLink().click();
		
		LeadPage leadPage=new LeadPage(driver);
		leadPage.getAddLeadBtn().click();
		
		AddNewLeadPage addNewLead=new AddNewLeadPage(driver);
		addNewLead.selectFirstNameDropDown("Mrs.");
		addNewLead.enterFirstName(firstName);
		addNewLead.enterLastName(lastName);
		addNewLead.EnterCompanyName(companyName);
		//WebElement type=selectfirstNameDropDown.getFirstSelectedOption();
		Thread.sleep(2000);
		addNewLead.getGropRadioBtn().click();
		addNewLead.selectAssignDropDown("Support Group");
		addNewLead.getSaveBtn().click();
	
		LeadInfoPage leadInfo=new LeadInfoPage(driver);
		
	   String actAssignedTeam=leadInfo.getActAssignedTeam().getText();
	
	   if(actAssignedTeam.trim().equals("Support Group"))
		{
			System.out.println(actAssignedTeam+" lead is assihned==PASS");
		}
		else {
			System.out.println(actAssignedTeam+" lead is not assigned ==FAIL");
		}
	}
	@Test
	public void createLeadWithName() throws Throwable
	{
		String firstName=excel.getDataFromExcel("lead", 1, 2)+javaUtility.getRandomNumber();
		String lastName=excel.getDataFromExcel("lead", 1, 3)+javaUtility.getRandomNumber();
		String companyName=excel.getDataFromExcel("lead", 1, 4)+javaUtility.getRandomNumber();
		HomePage homePage=new HomePage(driver);
		homePage.getLeadLink().click();
		
		LeadPage leadPage=new LeadPage(driver);
		leadPage.getAddLeadBtn().click();
		
		AddNewLeadPage addNewLead=new AddNewLeadPage(driver);
		addNewLead.selectFirstNameDropDown("Mrs.");
		addNewLead.enterFirstName(firstName);
		addNewLead.enterLastName(lastName);
		addNewLead.EnterCompanyName(companyName);
		addNewLead.getSaveBtn().click();
	
		LeadInfoPage leadInfo=new LeadInfoPage(driver);
		String actFirstName=leadInfo.getActFirstName().getText();
		if(actFirstName.contains(firstName))
		{
			System.out.println(firstName+" lead is created==PASS");
		}
		else {
			System.out.println(firstName+" lead is not created==FAIL");
		}
		
		String actCompanyName=driver.findElement(By.id("mouseArea_Company")).getText();
		if(actCompanyName.trim().equals(companyName))
		{
			System.out.println(companyName+" company name of leadd  is added==PASS");
		}
		else {
			System.out.println(companyName+" company name of leadd  is not added==FAIL");
		}
		Thread.sleep(4000);
	}
	@Test
   public void deleteLead() throws Throwable {
	   HomePage homePage=new HomePage(driver);
		homePage.getLeadLink().click();
		
		LeadPage leadPage=new LeadPage(driver);
		String leadNo="LEA20";
	    driver.findElement(By.xpath("//td[contains(text(),'"+leadNo+"')]/preceding-sibling::td/input[@name='selected_id']")).click();
	    leadPage.getDeleteLeadBtn().click();
		
		webDriverUtility.switchToAlertAndAccept(driver);
		leadPage.deleteLead(leadNo);
		Thread.sleep(2000);
   }

}
