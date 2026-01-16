package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.baseclass.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.objectrepositoryutility.ContactsInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContacts;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganization;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrgNameSelectingWindowPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;
import com.comcast.crm.objectrepositoryutility.OrgnizationInfoPage;
import com.comcast.generic.webdriverutility.JavaUtility;
import com.comcast.generic.webdriverutility.WebDriverUtility;

public class ContactTest extends BaseClass{
	@Test
	public void createContactTest() throws Throwable  {
		String lastName=excel.getDataFromExcel("contact", 1, 2)+javaUtility.getRandomNumber();
		
		HomePage homePage=new HomePage(driver);
		homePage.getContactLink().click();
		
		ContactsPage contactBtnPage=new ContactsPage(driver);
		contactBtnPage.getContactsBtn().click();
		
		CreateNewContacts newContact=new CreateNewContacts(driver);
		newContact.setLastName(lastName);
		newContact.getSaveBtn().click();
		
		ContactsInfoPage contactsInfo=new ContactsInfoPage(driver);
		String actLastName=contactsInfo.getActLastName().getText();
		if(actLastName.trim().equals(lastName))
		{
			System.out.println(lastName+" is lastName information is verified==PASS");
		}
		else 
		{
			System.out.println(lastName+" information is not valid==FAIL");
		}
		}
	
	@Test
	public void createContactWithOrgNameTest() throws Throwable  {
		HomePage homePage=new HomePage(driver);
        homePage.getOrganizationLink().click();
		
        OrganizationPage newOrgBtn=new OrganizationPage(driver);
        newOrgBtn.getCreateNewOrganizationBtn().click();
		
        String orgName=excel.getDataFromExcel("contact", 7, 2)+javaUtility.getRandomNumber();
		String lastName=excel.getDataFromExcel("contact", 7, 3);
		
		CreateNewOrganization createNewOrg =new CreateNewOrganization(driver);
		createNewOrg.createOrgName(orgName);

		Thread.sleep(2000);
		OrgnizationInfoPage orgInfo=new OrgnizationInfoPage(driver);
		String headerName=orgInfo.getHeaderMsg().getText();
		if(headerName.contains(orgName))
		{
			System.out.println(orgName+" is cread succesfully==PASS");
		}
		else {
			System.out.println(orgName+" is not cread ++FAIL");
		}
		
		homePage.getContactLink().click();
		
		ContactsPage contactBtnPage=new ContactsPage(driver);
		contactBtnPage.getContactsBtn().click();
		
		CreateNewContacts newContact=new CreateNewContacts(driver);
		newContact.setLastName(lastName);
		newContact.getSelectOrgName().click();
		
		webDriverUtility.switchToTabOnURL(driver, "module=Accounts");
		
		OrgNameSelectingWindowPage orgselecting=new OrgNameSelectingWindowPage(driver);
		orgselecting.getSearchfeild().sendKeys(orgName+ Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		webDriverUtility.switchToTabOnURL(driver, "module=Contacts");
		
		Thread.sleep(2000);
		newContact.getSaveBtn().click();
		
		ContactsInfoPage contactsInfo=new ContactsInfoPage(driver);
		String actLastName=contactsInfo.getActLastName().getText();
		String actSelectedOrgName=contactsInfo.getActSelectedOrgName().getText();
		
		if(actLastName.contains(lastName))
		{
			System.out.println(lastName+" LastName is cread succesfully==PASS");
		} 
		else {
			System.out.println(lastName+" LastName is not cread ++FAIL");
		}
		
		if(actSelectedOrgName.contains(orgName))
		{
			System.out.println(orgName+" OrgName is Selected succesfully==PASS");
		}
		else {
			System.out.println(orgName+" OrgName is  not Selected ==FAIL");
		}
		Thread.sleep(4000);
	}
	
	@Test
	public void contctWithSupportDate() throws Throwable {
		String lastName=excel.getDataFromExcel("contact", 4, 2)+javaUtility.getRandomNumber();

		HomePage homePage=new HomePage(driver);
		homePage.getContactLink().click();
		
		ContactsPage contactBtnPage=new ContactsPage(driver);
		contactBtnPage.getContactsBtn().click();
		
		String startDate=javaUtility.getRequiredDateYYYYDDMM(7);
		String endDate=javaUtility.getRequiredDateYYYYDDMM(20);
		
		CreateNewContacts newContact=new CreateNewContacts(driver);
		newContact.setLastName(lastName);
		Thread.sleep(2000);
		newContact.setStartDate(startDate);
		newContact.setEndDate(endDate);
		newContact.getSaveBtn().click();
		Thread.sleep(2000);

		ContactsInfoPage contactsInfo=new ContactsInfoPage(driver);
		String actLastName=contactsInfo.getActLastName().getText();
		if(actLastName.trim().equals(lastName))
		{
			System.out.println(lastName+" information is verified==PASS");
		}
		else {
			System.out.println(lastName+" information is not valid==FAIL");
		}
		
		String actStartDate=contactsInfo.getActStartDate().getText();
		if(actStartDate.trim().equals(startDate))
		{
			System.out.println(startDate+ "  startDate information is verified==PASS");
			
		}
		else {
			System.out.println(startDate+"  startDate information is not valid==FAIL");
			
		}
		
		String actEndDate=contactsInfo.getActEndDate().getText();
		if(actEndDate.trim().equals(endDate))
		{
			System.out.println(endDate+"   endDate information is verified==PASS");
          
		}
		else {
			System.out.println(endDate+"  endDate information is not valid==FAIL");
		}
		Thread.sleep(4000);
	}
	
}
