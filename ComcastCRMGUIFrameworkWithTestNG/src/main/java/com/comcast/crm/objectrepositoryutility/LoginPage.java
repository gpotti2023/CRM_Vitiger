package com.comcast.crm.objectrepositoryutility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//Rulr no:1 create separate java class
	//Rule no:2 Object creation for each element in webpage
	
	@FindBy(name="user_name")
	private WebElement userName;

	@FindBy(name="user_password")
	private WebElement passWord;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	   
	WebDriver driver;
	//Rule no:3 Object Initialization
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	  PageFactory.initElements(driver, this );
	}
	
	//Rule no:4  Object Encapsulation
	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassWord() {
		return passWord;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Rule no:5 provide action
	public void loginToApp( String username,String password)
	{
		driver.manage().window().maximize();
		userName.sendKeys(username);
		passWord.sendKeys(password);
		loginBtn.click();
	}
	
}
