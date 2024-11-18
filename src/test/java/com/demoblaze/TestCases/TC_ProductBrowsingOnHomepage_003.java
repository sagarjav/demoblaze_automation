package com.demoblaze.TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.demoblaze.pageObjects.HomePage;

public class TC_ProductBrowsingOnHomepage_003 extends BaseTest {
	

	// Verify products are displayed on the homepage
	/*Verify that products are displayed correctly on the homepage
	Manual Steps:

	1.Open the web browser.
	2.Navigate to https://www.demoblaze.com/.
	3.Verify that products are displayed on the homepage.*/
	
	@Test
	public void testProductBrowsingonHomepage() throws IOException, InterruptedException
	{
		HomePage homePage=new HomePage(driver);
		// Verify products are displayed on the homepage
		Thread.sleep(3000); 
		//homePage.viewProductDisplayed();
		boolean productsDisplayed=homePage.viewProductDisplayed();
	        Thread.sleep(3000);
		
		if(productsDisplayed==true)
		{
			Thread.sleep(3000);
			System.out.println("Products are displayed on the homepage.");
			Thread.sleep(3000);
			Assert.assertTrue(true);
		}else 
		{
			//capturescreen (driver,"testProductBrowsingonHomepage" );
			Thread.sleep(3000);
			System.out.println("Products are not displayed on the homepage.");
			Thread.sleep(3000);
			Assert.assertTrue(false);
		} 
		
	}
	
	
	
	
	

}
