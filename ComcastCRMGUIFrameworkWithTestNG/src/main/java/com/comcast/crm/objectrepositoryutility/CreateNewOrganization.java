package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.generic.webdriverutility.WebDriverUtility;

public class CreateNewOrganization {
	
	WebDriver driver;
	WebDriverUtility webUtility=new WebDriverUtility();
	public CreateNewOrganization(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement orgNameEdit;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy (xpath="//input[contains(@value,'Save')]")
	private WebElement saveBtn;
	
	@FindBy(id="phone")
	private WebElement phoneNumber;
	
	
	public void createOrgName(String orgName) {
		orgNameEdit.sendKeys(orgName);
		
	}
	
	public void createOrgName(String orgName ,String industry) {
		orgNameEdit.sendKeys(orgName);
		webUtility.selectByText(industryDropDown,industry);
		saveBtn.click();
		
	}
	
	public void createOrgName(String orgName ,String industry,String type) {
		orgNameEdit.sendKeys(orgName);
		webUtility.selectByText(industryDropDown,industry);
		webUtility.selectByText(typeDropDown, type);
		saveBtn.click();
		
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getPhoneNumber() {
		return phoneNumber;
	}
	
    
		


}
