package com.demoblaze.TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.demoblaze.pageObjects.HomePage;

//Verify that product categories can be navigated successfully
		/*Manual Steps:

		1.Open the web browser.
		2.Navigate to https://www.demoblaze.com/.
		3.Click on different product categories.
		4.Verify that products in the selected category are displayed.*/
public class TC_ProductCategoriesNavigation_004 extends BaseTest {
	
	@Test
	public void testProductCategoriesNavigation() throws IOException, InterruptedException
	{
		HomePage homePage2=new HomePage(driver);
		
		// Navigate to Phones category and verify products
		homePage2.clickCatagoryPhones();
        Thread.sleep(3000);
      boolean  phoneCatagory=homePage2.areCategoryProductsDisplayed();
		
		if(phoneCatagory==true)
		{
			Thread.sleep(3000);
			System.out.println("Products are displayed on the Phone Catagory Page.");
			Thread.sleep(3000);
			Assert.assertTrue(true);
		}
		else
		{
			Thread.sleep(3000);
			System.out.println("Products are not displayed on the Phone Catagory Page.");
			Thread.sleep(3000);
			Assert.assertTrue(false);
		}
		
	 // Navigate to Laptops category and verify products
		homePage2.clickCatagoryLaptops();
		Thread.sleep(3000);
	     boolean  laptopCatagory=homePage2.areCategoryProductsDisplayed();
			
			if(laptopCatagory==true)
			{
				Thread.sleep(3000);
				System.out.println("Products are displayed on the Laptop Catagory Page.");
				Thread.sleep(3000);
				Assert.assertTrue(true);
			}
			else
			{
				Thread.sleep(3000);
				System.out.println("Products are not displayed on the Laptop Catagory Page.");
				Thread.sleep(3000);
				Assert.assertTrue(false);
			}
			
			// Navigate to Monitors category and verify products
		    homePage2.clickCatagoryMonitos();
		    Thread.sleep(3000);
		     boolean  monitorCatagory=homePage2.areCategoryProductsDisplayed();
				
				if(monitorCatagory==true)
				{
					Thread.sleep(3000);
					System.out.println("Products are displayed on the monitor Catagory Page.");
					Thread.sleep(3000);
					Assert.assertTrue(true);
				}
				else
				{
					Thread.sleep(3000);
					System.out.println("Products are not displayed on the monitor Catagory Page.");
					Thread.sleep(3000);
					Assert.assertTrue(false);
				}
	}
	
	
	
	
	

}
