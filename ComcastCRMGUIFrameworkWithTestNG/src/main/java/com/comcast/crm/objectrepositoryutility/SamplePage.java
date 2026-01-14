package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class SamplePage {
		@FindAll({@FindBy(name="user_name"),@FindBy(xpath="//input[@name='user_name']")})
		private WebElement userName;

		@FindBys({@FindBy(name="user_password"),@FindBy(xpath="//input[@name='user_password']")})
		private WebElement passWord;
		
		@FindBy(id="submitButton")
		private WebElement loginBtn;
		   
		WebDriver driver;
		//Rule no:3 Object Initialization
		public SamplePage(WebDriver driver)
		{
			this.driver=driver;
		  PageFactory.initElements(driver, this );
		}
		
		//Rule no:4  Object Encapsulation
	
		
		//Rule no:5 provide action
		public void loginToApp( String username,String password)
		{
			driver.manage().window().maximize();
			userName.sendKeys(username);
			passWord.sendKeys(password);
			loginBtn.click();
		}

}
