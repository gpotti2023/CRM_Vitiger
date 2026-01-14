package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContacts {
	WebDriver driver;
	public CreateNewContacts(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastNamefeild;
	
	@FindBy(xpath="//input[contains(@value,'Save')]")
	private WebElement saveBtn;
	
	@FindBy(id="jscal_field_support_start_date")
	private WebElement startDate;
	
	@FindBy(id="jscal_field_support_end_date")
	private WebElement endDate;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement selectOrgName;
	
	public void setLastName(String lastName) {
		lastNamefeild.sendKeys(lastName);
	
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void setStartDate(String reqStartDate) {
		startDate.click();
		startDate.clear();
		startDate.sendKeys(reqStartDate);
	}

	public void setEndDate(String reqEndDate) {
		endDate.click();
		endDate.clear();
		endDate.sendKeys(reqEndDate);
	}


	public WebElement getSelectOrgName() {
		return selectOrgName;
	}

	
	
}
