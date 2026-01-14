package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	WebDriver driver;
	public ContactsInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="mouseArea_Last Name")
	private WebElement actLastName;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement actStartDate;
	
	@FindBy(id="mouseArea_Support End Date")
	private WebElement actEndDate;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement actSelectedOrgName;
	
	public WebElement getActLastName() {
		return actLastName;
	}

	public WebElement getActStartDate() {
		return actStartDate;
	}

	public WebElement getActEndDate() {
		return actEndDate;
	}

	public WebElement getActSelectedOrgName() {
		return actSelectedOrgName;
	}

	
	
}
