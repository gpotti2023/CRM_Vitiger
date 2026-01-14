package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.generic.webdriverutility.WebDriverUtility;

public class AddNewProductPage {
	WebDriver driver;
	WebDriverUtility webDriverUtility=new WebDriverUtility();
	public AddNewProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="productname")
	private WebElement productNameFeild;
	
	@FindBy(name="productcategory")
	private WebElement productCategoryDropDown;
	
	@FindBy(xpath="//input[contains(@value,'Save')]")
	private WebElement saveBtn;

	@FindBy(id="jscal_field_sales_start_date")
	private WebElement salesStartDate;
	
	@FindBy(id="jscal_field_sales_end_date")
	private WebElement salesEndDate;
	
	public void enterProductName(String productName)
	{
		productNameFeild.sendKeys(productName);
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void selectProductCategory(String text)
	{
		webDriverUtility.selectByValue(productCategoryDropDown, text);	
	}

	public void enterSalesStartDate(String startDate) {
		salesStartDate.sendKeys(startDate);
		
	}

	public void enterSalesEndDate(String endDate) {
		
		salesEndDate.sendKeys(endDate);
	}
	
	
}
