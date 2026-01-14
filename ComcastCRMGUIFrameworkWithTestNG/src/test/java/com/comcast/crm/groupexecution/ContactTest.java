package com.comcast.crm.groupexecution;

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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.baseclass.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.listenerUtility.ListenerImplimentation;
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
import com.comcast.generic.webdriverutility.UtilityClassObject;
import com.comcast.generic.webdriverutility.WebDriverUtility;
@Listeners(com.comcast.crm.listenerUtility.ListenerImplimentation.class)
public class ContactTest extends BaseClass{
	
	
	SoftAssert softAssertObj=new SoftAssert();
	@Test//(retryAnalyzer=com.comcast.crm.listenerUtility.RetryAnalyzerImplimentation.class)
	public void createContactTest() throws Throwable  {
		System.out.println("-----createContactTest-----");
		String lastName=excel.getDataFromExcel("contact", 1, 2)+javaUtility.getRandomNumber();
		
		//ListenerImplimentation.test.log(Status.INFO, " navigate to homepage ");
		UtilityClassObject.getTest().log(Status.INFO, "===navigate to homepage===");
		HomePage homePage=new HomePage(driver);
		homePage.getContactLink().click();
		
		//ListenerImplimentation.test.log(Status.INFO, " navigate to contacts page ");
		UtilityClassObject.getTest().log(Status.INFO, "===navigate to contacts page ===");
		ContactsPage contactBtnPage=new ContactsPage(driver);
		contactBtnPage.getContactsBtn().click();
		
		//ListenerImplimentation.test.log(Status.INFO, " enter lastname in contact page  ");
		UtilityClassObject.getTest().log(Status.INFO, "===enter lastname in contact page ===");
		CreateNewContacts newContact=new CreateNewContacts(driver);
		newContact.setLastName(lastName);
		newContact.getSaveBtn().click();
		
		//ListenerImplimentation.test.log(Status.INFO, " actual lastname of contact page");
		UtilityClassObject.getTest().log(Status.INFO, "===actual lastname of contact page===");
		ContactsInfoPage contactsInfo=new ContactsInfoPage(driver);
		String actLastName=contactsInfo.getActLastName().getText();
		Assert.assertEquals(actLastName.trim(),lastName);
		/*
		 * if(actLastName.trim().equals(lastName)) {
		 * System.out.println(lastName+" information is verified==PASS"); } else {
		 * System.out.println(lastName+" information is not valid==FAIL"); }
		 */
		System.out.println("-----createContactTest is succefully completed-----");
		UtilityClassObject.getTest().log(Status.PASS, "===LastName Verified Successfully===");
		
		}
	
	@Test(groups="RegressionTesting")
	public void createContactWithOrgNameTest() throws Throwable  {
		System.out.println("----createContactWithOrgNameTest------");
		UtilityClassObject.getTest().log(Status.INFO, "===navigate to Organization page===");
		HomePage homePage=new HomePage(driver);
        homePage.getOrganizationLink().click();
		
        UtilityClassObject.getTest().log(Status.INFO, "===click on organization btn and navigate to organization details page ===");
        OrganizationPage newOrgBtn=new OrganizationPage(driver);
        newOrgBtn.getCreateNewOrganizationBtn().click();
		
        String orgName=excel.getDataFromExcel("contact", 7, 2)+javaUtility.getRandomNumber();
		String lastName=excel.getDataFromExcel("contact", 7, 3);
		
		UtilityClassObject.getTest().log(Status.INFO, "===enter orgName and click on save===");
		CreateNewOrganization createNewOrg =new CreateNewOrganization(driver);
		createNewOrg.createOrgName(orgName);
		createNewOrg.getSaveBtn().click();

		Thread.sleep(2000);
		UtilityClassObject.getTest().log(Status.INFO, "===navigate to Organization information page===");
		OrgnizationInfoPage orgInfo=new OrgnizationInfoPage(driver);
		String headerName=orgInfo.getHeaderMsg().getText();
		boolean status=headerName.contains(orgName);
		System.out.println(status);
		softAssertObj.assertEquals(status,true);
		UtilityClassObject.getTest().log(Status.PASS, "===header msg verified with org Name ===");
		System.out.println("header matched");
		/*
		 * if(headerName.contains(orgName)) {
		 * System.out.println(orgName+" is cread succesfully==PASS"); } else {
		 * System.out.println(orgName+" is not cread ++FAIL"); }
		 */
		UtilityClassObject.getTest().log(Status.INFO, "===navigate to Contact page===");
		homePage.getContactLink().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "===navigate to contac ts details  page===");
		ContactsPage contactBtnPage=new ContactsPage(driver);
		contactBtnPage.getContactsBtn().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "===Enter lastName and click on existing org Name btn===");
		CreateNewContacts newContact=new CreateNewContacts(driver);
		newContact.setLastName(lastName);
		newContact.getSelectOrgName().click();
		UtilityClassObject.getTest().log(Status.INFO, "===switching to selecting  extisting org Name  page===");
		webDriverUtility.switchToTabOnURL(driver, "module=Accounts");
		
		OrgNameSelectingWindowPage orgselecting=new OrgNameSelectingWindowPage(driver);
		orgselecting.getSearchfeild().sendKeys(orgName+ Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		webDriverUtility.switchToTabOnURL(driver, "module=Contacts");
		
		Thread.sleep(2000);
		newContact.getSaveBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "===navigate to Contacts information page===");
		ContactsInfoPage contactsInfo=new ContactsInfoPage(driver);
		String actLastName=contactsInfo.getActLastName().getText();
		String actSelectedOrgName=contactsInfo.getActSelectedOrgName().getText();
		Boolean status1=actLastName.contains(lastName);
		System.out.println(status1);
		softAssertObj.assertEquals(status1,true);
		System.out.println("lastName matched");
		boolean status2=actSelectedOrgName.contains(orgName);
		System.out.println(status2);
		softAssertObj.assertEquals(status2,true);
		UtilityClassObject.getTest().log(Status.PASS, "===existing orgname selected successfully and verified successfully===");
		System.out.println("orgName matched");
		/*
		 * if(actLastName.contains(lastName)) {
		 * System.out.println(lastName+" LastName is cread succesfully==PASS"); } else {
		 * System.out.println(lastName+" LastName is not cread ++FAIL"); }
		 * 
		 * if(actSelectedOrgName.contains(orgName)) {
		 * System.out.println(orgName+" OrgName is Selected succesfully==PASS"); } else
		 * { System.out.println(orgName+" OrgName is  not Selected ==FAIL"); }
		 */
		softAssertObj.assertAll();
	}
	
	@Test(groups="RegressionTesting")
	public void contctWithSupportDate() throws Throwable {
		System.out.println("----contctWithSupportDate------");
		String lastName=excel.getDataFromExcel("contact", 4, 2)+javaUtility.getRandomNumber();
		UtilityClassObject.getTest().log(Status.INFO, "===navigate to contacts page===");
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
		//String actLastName=contactsInfo.getActLastName().getText();
		String actStartDate=contactsInfo.getActStartDate().getText();
		softAssertObj.assertEquals(actStartDate.trim(), startDate);
		UtilityClassObject.getTest().log(Status.PASS, "===StartDate selceted and verified successfully===");
		/*
		 * if(actStartDate.trim().equals(startDate)) { System.out.println(startDate+
		 * "  startDate information is verified==PASS");
		 * 
		 * } else {
		 * System.out.println(startDate+"  startDate information is not valid==FAIL");
		 * 
		 * }
		 */
		
		String actEndDate=contactsInfo.getActEndDate().getText();
		softAssertObj.assertEquals(actEndDate.trim(), endDate);
		UtilityClassObject.getTest().log(Status.PASS, "===EndDate selceted and verified successfully===");
		/*
		 * if(actEndDate.trim().equals(endDate)) {
		 * System.out.println(endDate+"   endDate information is verified==PASS");
		 * 
		 * } else {
		 * System.out.println(endDate+"  endDate information is not valid==FAIL"); }
		 */
		softAssertObj.assertAll();
	}
	
}
