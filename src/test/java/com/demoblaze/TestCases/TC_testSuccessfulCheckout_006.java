package com.demoblaze.TestCases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoblaze.pageObjects.CheckoutProcessPage;

/*Positive Scenario: Successfully check the items added to the cart
Manual Steps:

Open the web browser.
Navigate to https://www.demoblaze.com/.
Add products to the cart.
Click on the "Cart" button.
Click "Place Order".
Fill in the details and click "Purchase".
Verify that the order is placed successfully.
*/

public class TC_testSuccessfulCheckout_006 extends BaseTest{
	
	@Test
	public void testSuccessfulCheckout() throws InterruptedException
	{
		CheckoutProcessPage chekoutprocess=new CheckoutProcessPage(driver);
		System.out.println("test is here");
		
		chekoutprocess.clickonProduct();
		chekoutprocess.clickaddtoCart();
		driver.switchTo().alert().accept();
		chekoutprocess.clickCart();
		chekoutprocess.clickPlaceOrder();
		chekoutprocess.name.sendKeys(TestData.VALID_USERNAME);
		chekoutprocess.creditcard.sendKeys(TestData.CreditCard);
		chekoutprocess.clickpurchase();
		
		String ActualR1=chekoutprocess.getOrderConfirmationMessage();
	
	    String ExpR2="Thank you for your purchase!";
	  if(ActualR1.contains(ExpR2))
	  {
		  System.out.println("test Successful Checkout id done"+" "+ActualR1);
	  }
	  else 
	  {
		  System.out.println("test Successful Checkout id Failled"+" "+ActualR1);
	  }
	  
	
	}
     
	
	
	

}
