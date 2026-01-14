package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgnizationInfoPage {
	
	WebDriver driver;
	public OrgnizationInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(className="dvHeaderText")
	private WebElement headerMsg;
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement orgName;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement actOrgName;
	
	@FindBy(id="mouseArea_Industry")
	private WebElement industryName;
	
	@FindBy(id="mouseArea_Type")
	private WebElement typeName;
	
	@FindBy(id="mouseArea_Phone")
	private WebElement phNo;
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}


	public WebElement getOrgName() {
		return orgName;
	}


	public WebElement getIndustryName() {
		return industryName;
	}


	public WebElement getTypeName() {
		return typeName;
	}


	public WebElement getPhNo() {
		return phNo;
	}


	public WebElement getActOrgName() {
		return actOrgName;
	}

	
	
}
