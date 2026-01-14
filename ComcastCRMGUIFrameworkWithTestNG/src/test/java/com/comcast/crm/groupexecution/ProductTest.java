package com.comcast.crm.groupexecution;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.generic.baseclass.BaseClass;
import com.comcast.crm.objectrepositoryutility.AddNewProductPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.ProductInfoPage;
import com.comcast.crm.objectrepositoryutility.ProductPage;

//@Listeners(com.comcast.crm.listenerUtility.ListenerImplimentation.class)
public class ProductTest extends BaseClass {
	SoftAssert softAssertObj=new SoftAssert();
	@Test(groups="SmokeTesting")
	public void CreateProductTest() throws Throwable  {
		System.out.println("------CreateProductTest------");
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
		boolean status=headerName.contains(productName);
		Assert.assertEquals(status, true);
		/*
		 * if(headerName.contains(productName)) {
		 * System.out.println(productName+" product  is added==PASS"); } else {
		 * System.out.println(productName+" product  is not  added==FAIL"); }
		 */
	}
	
	@Test(groups="RegressionTesting")
	public  void CreateProductWithCategoryTest() throws Throwable  {
		System.out.println("-----CreateProductWithCategoryTest-----");
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
	    softAssertObj.assertEquals(actProductName.trim(), productName);
		/*
		 * if(actProductName.trim().equals(productName)) {
		 * System.out.println(productName+" product  is added==PASS"); } else {
		 * System.out.println(productName+" product  is not  added==FAIL"); }
		 */
		
		 String actProductCategory=productInfo.getActCategoryName().getText();

		 softAssertObj.assertEquals(actProductCategory, "Software");
			/*
			 * if(actProductCategory.equals("Software")) {
			 * System.out.println(productName+"  Software category  is added==PASS"); } else
			 * { System.out.println(productName+"  Software category  is not  added==FAIL");
			 * }
			 */
		 softAssertObj.assertAll();
	}

	@Test(groups="RegressionTesting")
	public void CreateProductWithSalesDateTest() throws Throwable  {
         System.out.println("------CreateProductWithSalesDateTest-------");
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
			
			softAssertObj.assertEquals(actStartSaleDate.trim(), salesStartDate);
			/*
			 * if(actStartSaleDate.trim().equals(salesStartDate)) {
			 * System.out.println(salesStartDate+" product sales startDate is added==PASS");
			 * } else { System.out.println(
			 * salesStartDate+" product  sales startDate is not  added==FAIL"); }
			 */
			//System.out.println(salesEndDate);
			//System.out.println(actEndSaleDate);
			softAssertObj.assertEquals(actEndSaleDate.trim(), salesEndDate);
			/*
			 * if(actEndSaleDate.trim().equals(salesEndDate)) {
			 * System.out.println(salesEndDate+" product sales end Date is added==PASS"); }
			 * else { System.out.println(
			 * salesEndDate+" product  sales end Date is not  added==FAIL"); }
			 */
			softAssertObj.assertAll();
		}
	
}
