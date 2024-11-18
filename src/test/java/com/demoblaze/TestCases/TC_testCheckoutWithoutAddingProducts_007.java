package com.demoblaze.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoblaze.pageObjects.CheckoutProcessPage;

/*Negative Scenario: Attempt to checkout without adding any products to the cart
Manual Steps:

Open the web browser.
Navigate to https://www.demoblaze.com/.
Click on the "Cart" button.
Click "Place Order".
Verify that an error message is displayed.
*/

public class TC_testCheckoutWithoutAddingProducts_007 extends BaseTest{
	
	@Test
	public void testCheckoutWithoutAddingProducts() throws InterruptedException, IOException
	{
		CheckoutProcessPage chekoutprocess=new CheckoutProcessPage(driver);
		
		chekoutprocess.clickCart();
		Thread.sleep(3000);
		chekoutprocess.clickPlaceOrder();
		Thread.sleep(3000);
		chekoutprocess.name.sendKeys(TestData.VALID_USERNAME);
		Thread.sleep(3000);
		chekoutprocess.creditcard.sendKeys(TestData.CreditCard);
		Thread.sleep(3000);
		chekoutprocess.clickpurchase();
		Thread.sleep(3000);
		capturescreen (driver, "testCheckoutWithoutAddingProducts");
		/*String orderpurchased=driver.switchTo().alert().getText();
		Thread.sleep(3000);
		System.out.println(orderpurchased);
		String expectedResult="Thank you for your purchase!";
		Thread.sleep(3000);
		
		boolean ordercheck=orderpurchased.contains(expectedResult);
		if(ordercheck==true)
		{
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			System.out.println("Checkout process is Failed:"+" "+"orderpurchased ");
			Assert.assertTrue(false);
		}else
		{
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			System.out.println("Checkout process is Succesfully Done:"+" "+"orderpurchased ");
			Assert.assertTrue(true);
		}*/
		
		//System.out.println(driver.switchTo().alert().getText());
		System.out.println("testCheckoutWithoutAddingProducts");
	}

}
