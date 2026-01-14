package com.comcast.crm.objectrepositoryutility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage {
	WebDriver driver;
	public LeadPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Lead...']")
	private WebElement addLeadBtn;
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement deleteLeadBtn;
	
	@FindBy(xpath="//span[@vtfieldname='lead_no']")
	private List<WebElement> totalLeads;
	
	public WebElement getAddLeadBtn() {
		return addLeadBtn;
	}

	public WebElement getDeleteLeadBtn() {
		return deleteLeadBtn;
	}
	
	public boolean deleteLead(String leadNo)
	{
		List<WebElement> list=totalLeads;
		boolean flag=false;
		for(WebElement leadList:list)
		{
			String name=leadList.getText();
			 if(name.equals(leadNo))
			 {
				flag=true;
			 }
		}
		if(flag==false)
		{
			return true;
		}
		else {
			return false;
		}

	}
	

}
