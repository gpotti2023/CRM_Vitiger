package com.comcast.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForElementPresent(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new  WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchToTabOnURL(WebDriver driver,String partialUrl)
	{
		Set<String> setOfWindows=driver.getWindowHandles();
		Iterator<String> iterator=setOfWindows.iterator();
	   
		while(iterator.hasNext())
		{
			String windID=iterator.next();
			driver.switchTo().window(windID);
			String actUrl=driver.getCurrentUrl();
			if(actUrl.contains(partialUrl))
			{
				break;
			}
		}
	}
	
	public void switchToTabOnTitle(WebDriver driver,String partialTitle)
	{
		Set<String> setOfWindows=driver.getWindowHandles();
		Iterator<String> iterator=setOfWindows.iterator();
	   
		while(iterator.hasNext())
		{
			String windID=iterator.next();
			driver.switchTo().window(windID);
			String actTitle=driver.getTitle();
			if(actTitle.contains(partialTitle))
			{
				break;
			}
		}
	}
	
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver,String nameID)
	{
		driver.switchTo().frame(nameID);
	}
	
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndCancle(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
   public void selectByText(WebElement element,String text )
   {
	   Select sel=new Select(element);
	   sel.selectByVisibleText(text);
   }
   
   public void selectByValue(WebElement element,String text )
   {
	   Select sel=new Select(element);
	   sel.selectByVisibleText(text);
   }
   
   public void selectByIndex(WebElement element,int index )
   {
	   Select sel=new Select(element);
	   sel.selectByIndex(index);
   }
   
   public void mouseoverOnElement(WebDriver driver, WebElement element)
   {
	   Actions act=new Actions(driver);
	   act.moveToElement(element).perform();
   }
   
   public void doubleClickOnElement(WebDriver driver, WebElement element)
   {
	   Actions act=new Actions(driver);
	   act.doubleClick(element).perform();
   }
   public void dragAndDropOnElement(WebDriver driver, WebElement element1,WebElement element2)
   {
	   Actions act=new Actions(driver);
	   act.dragAndDrop(element1, element2);
   }
   public void rightClickOnElement(WebDriver driver, WebElement element)
   {
	   Actions act=new Actions(driver);
	   act.contextClick(element); 
   }
   
   public void scrollToGivenElement(WebDriver driver, WebElement element)
   {
	   Actions act=new Actions(driver);
	   act.scrollToElement(element);
   }
   
   public void scrollByGivenAmount(WebDriver driver,int x,int y)
   {
	   Actions act=new Actions(driver);
	   act.scrollByAmount(x, y);
   }
   
   
}















