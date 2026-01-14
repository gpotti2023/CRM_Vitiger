package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.generic.webdriverutility.WebDriverUtility;

public class HomePage {
	WebDriverUtility wbu=new WebDriverUtility();
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	@FindBy(linkText="Leads")
	private WebElement leadLink;
	
	@FindBy(linkText="More")
	private WebElement more;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminimg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	@FindBy(name="search_text")
	private WebElement searchText;
	
	@FindBy(id="bas_searchfield")
	private WebElement searchDropDown;
	
	@FindBy(xpath="//input[@value=' Search Now ']")
	private WebElement searchBtn;
	
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public void navigaToCampignPage(WebElement campignLink) {
		Actions action=new Actions(driver);
		action.moveToElement(more).perform();
		campaignsLink.click();
	}

	public void logOut()
	{
		Actions action=new Actions(driver);
		action.moveToElement(adminimg).perform();
		signOutLink.click();
	}

	public WebElement getSearchText() {
		return searchText;
	}

	public void selectSearchDropDown(String text) {
		wbu.selectByText(searchDropDown, text);
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getLeadLink() {
		return leadLink;
	}
	
	
}
