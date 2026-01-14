package com.comcast.crm.others;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganization;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;
import com.comcast.crm.objectrepositoryutility.OrgnizationInfoPage;
import com.comcast.generic.webdriverutility.JavaUtility;
import com.comcast.generic.webdriverutility.WebDriverUtility;

public class DeleteOrgWithDynamicElement {
public static void main(String[] args) throws Throwable  {
		
		FileUtility fileutility=new FileUtility();
		ExcelUtility excel=new ExcelUtility();
		WebDriverUtility webDriverUtility=new WebDriverUtility();
		JavaUtility javaUtility=new JavaUtility();
		
		String browser=fileutility.getDataFromPropertyFile("browser");
		String url=fileutility.getDataFromPropertyFile("url");
		String userName=fileutility.getDataFromPropertyFile("username");
		String password=fileutility.getDataFromPropertyFile("password");
		
		WebDriver driver;
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}else if(browser.equals("fireFox"))
		{
			driver=new FirefoxDriver();
		}else if(browser.equals("fireFox"))
		{
			driver=new EdgeDriver();
		}else 
		{
			driver=new ChromeDriver();
		}
		
		webDriverUtility.waitForPageToLoad(driver);
		driver.get(url);
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(userName, password);
		
		HomePage homepage=new HomePage(driver);
        homepage.getOrganizationLink().click();
		
        OrganizationPage newOrgBtn=new OrganizationPage(driver);
        newOrgBtn.getCreateNewOrganizationBtn().click();
		
		String orgName=excel.getDataFromExcel("org", 1, 2)+javaUtility.getRandomNumber();
		
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
		String actOrgName=orgInfo.getActOrgName().getText();
		if(actOrgName.trim().equals(orgName))
		{
			System.out.println(orgName+"is cread succesfully==PASS");
		}
		else {
			System.out.println(orgName+" is not cread ++FAIL");
		}
		
		homepage.getOrganizationLink().click();
		homepage.getSearchText().sendKeys(orgName);
		homepage.selectSearchDropDown( "Organization Name");
		homepage.getSearchBtn().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']/../..//td[8]/a[text()='del']")).click();
		Thread.sleep(4000);
		webDriverUtility.switchToAlertAndAccept(driver);
		Thread.sleep(4000);
		homepage.logOut();
		Thread.sleep(4000);
		driver.quit();
	}


}
