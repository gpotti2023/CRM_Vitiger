package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInfoPage {
	WebDriver driver;
	public LeadInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="mouseArea_Assigned To")
	private WebElement actAssignedTeam;

	@FindBy(id="mouseArea_First Name")
	private WebElement actFirstName;
	public WebElement getActAssignedTeam() {
		return actAssignedTeam;
	}

	public WebElement getActFirstName() {
		return actFirstName;
	}
	
	
}
