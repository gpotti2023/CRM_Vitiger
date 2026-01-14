package com.comcast.crm.producttsest;

import org.testng.annotations.Test;

import com.comcast.crm.generic.baseclass.BaseClass;
import com.comcast.crm.objectrepositoryutility.AddNewProductPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.ProductInfoPage;
import com.comcast.crm.objectrepositoryutility.ProductPage;

public class ProductTest extends BaseClass {
	
	@Test
	public void CreateProductTest() throws Throwable  {
		
		String productName=excel.getDataFromExcel("product", 1, 2)+javaUtility.getRandomNumber();
		
		HomePage homePage=new HomePage(driver);
		homePage.getProductLink().click();
		
		ProductPage productpage=new ProductPage(driver);
		productpage.getProductLinkBtn().click();
		
		AddNewProductPage addProduct=new AddNewProductPage(driver);
		addProduct.enterProductName(productName);
		addProduct.getSaveBtn().click();
		Thread.sleep(2000);
		
		ProductInfoPage productInfo=new ProductInfoPage(driver);
		String headerName=productInfo.getHeaderMsg().getText();
		if(headerName.contains(productName))
		{
			System.out.println(productName+" product  is added==PASS");
		}
		else {
			System.out.println(productName+" product  is not  added==FAIL");
		}
	}
	
	@Test
	public  void CreateProductWithCategoryTest() throws Throwable  {
		String productName=excel.getDataFromExcel("product", 1, 2)+javaUtility.getRandomNumber();
		
		HomePage homePage=new HomePage(driver);
		homePage.getProductLink().click();
		
		ProductPage productpage=new ProductPage(driver);
		productpage.getProductLinkBtn().click();
		
		AddNewProductPage addProduct=new AddNewProductPage(driver);
		addProduct.enterProductName(productName);
		addProduct.selectProductCategory("Software");
		addProduct.getSaveBtn().click();
		Thread.sleep(2000);
		
		ProductInfoPage productInfo=new ProductInfoPage(driver);
		
	    String actProductName=productInfo.getActProductName().getText();
		if(actProductName.trim().equals(productName))
		{
			System.out.println(productName+" product  is added==PASS");
		}
		else {
			System.out.println(productName+" product  is not  added==FAIL");
		}
		
		 String actProductCategory=productInfo.getActCategoryName().getText();

		 if(actProductCategory.equals("Software"))
			{
				System.out.println(productName+"  Software category  is added==PASS");
			}
			else {
				System.out.println(productName+"  Software category  is not  added==FAIL");
			}
	}

	@Test
	public void CreateProductWithSalesDateTest() throws Throwable  {

		String productName=excel.getDataFromExcel("product", 1, 2)+javaUtility.getRandomNumber();
			
			HomePage homePage=new HomePage(driver);
			homePage.getProductLink().click();
			
			ProductPage productpage=new ProductPage(driver);
			productpage.getProductLinkBtn().click();
			
			String salesStartDate=javaUtility.getRequiredDateYYYYDDMM(6);
			String salesEndDate=javaUtility.getRequiredDateYYYYDDMM(21);
			
			AddNewProductPage addProduct=new AddNewProductPage(driver);
			addProduct.enterProductName(productName);
			Thread.sleep(2000);
			addProduct.enterSalesStartDate(salesStartDate);
			addProduct.enterSalesEndDate(salesEndDate);
			addProduct.getSaveBtn().click();
			Thread.sleep(2000);
	        
	        ProductInfoPage productInfo=new ProductInfoPage(driver);
			String actStartSaleDate=productInfo.getActSalesStartDate().getText();
			String actEndSaleDate=productInfo.getActSalesEndDate().getText();
			
			if(actStartSaleDate.trim().equals(salesStartDate))
			{
				System.out.println(salesStartDate+" product sales startDate is added==PASS");
			}
			else {
				System.out.println(salesStartDate+" product  sales startDate is not  added==FAIL");
			}
			//System.out.println(salesEndDate);
			//System.out.println(actEndSaleDate);
			if(actEndSaleDate.trim().equals(salesEndDate))
			{
				System.out.println(salesEndDate+" product sales end Date is added==PASS");
			}
			else {
				System.out.println(salesEndDate+" product  sales end Date is not  added==FAIL");
			}
			
		}
	
}
