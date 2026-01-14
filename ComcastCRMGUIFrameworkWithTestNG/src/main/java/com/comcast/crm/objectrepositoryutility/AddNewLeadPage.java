package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.generic.webdriverutility.WebDriverUtility;

public class AddNewLeadPage {
	WebDriver driver;
	WebDriverUtility webDriverUtility=new WebDriverUtility();
	public AddNewLeadPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="salutationtype")
	private WebElement firstNameDropDown;
	
	@FindBy(name="firstname")
	private WebElement firstNameFeild;
	
	@FindBy(name="lastname")
	private WebElement lastNameFeild;
	
	@FindBy(name="company")
	private WebElement companyNameFeild;

	@FindBy(xpath="//input[@type='radio']/following-sibling::input")
	private WebElement gropRadioBtn;
	
	@FindBy(name="assigned_group_id")
	private WebElement assignDropDown;
	
	@FindBy(xpath="//input[contains(@value,'Save')]")
	private WebElement saveBtn;
	
	
	public void selectFirstNameDropDown(String text) {
		webDriverUtility.selectByValue(firstNameDropDown, text);
	}

	public void enterFirstName(String firstName) {
		firstNameFeild.sendKeys(firstName);
	}

	public void  enterLastName(String lastName) {
		lastNameFeild.sendKeys(lastName);
	}

	public void  EnterCompanyName(String companyName) {
		companyNameFeild.sendKeys(companyName);
	}


	public WebElement getGropRadioBtn() {
		return gropRadioBtn;
	}

	public void selectAssignDropDown(String text) {
		webDriverUtility.selectByText(assignDropDown, text);
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
}
