package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
	WebDriver driver;
	public ProductInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="lvtHeaderText")
	private WebElement headerMsg;
	
	@FindBy(id="mouseArea_Product Name")
	private WebElement actProductName;
	
	@FindBy(id="mouseArea_Product Category")
	private WebElement actCategoryName;
	
	@FindBy(id="mouseArea_Sales Start Date")
	private WebElement actSalesStartDate;
	
	@FindBy(id="mouseArea_Sales End Date")
	private WebElement actSalesEndDate;
	
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getActProductName() {
		return actProductName;
	}

	public WebElement getActCategoryName() {
		return actCategoryName;
	}

	public WebElement getActSalesStartDate() {
		return actSalesStartDate;
	}

	public WebElement getActSalesEndDate() {
		return actSalesEndDate;
	}
	
	

}
