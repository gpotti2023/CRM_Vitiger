package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgNameSelectingWindowPage {
	
	WebDriver driver;
	public OrgNameSelectingWindowPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="search_text")
	private WebElement searchfeild;
	
	
	public WebElement getSearchfeild() {
		return searchfeild;
	}


}
