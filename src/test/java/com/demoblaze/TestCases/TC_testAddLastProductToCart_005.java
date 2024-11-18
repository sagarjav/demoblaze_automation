package com.demoblaze.TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.demoblaze.pageObjects.ProductAddToCartPage;

/*Navigate to the last page by clicking next, select the last product, and add the product to the cart
Manual Steps:

1.Open the web browser.
2.Navigate to https://www.demoblaze.com/.
3.Click on the "Next" button to navigate to the last page.
4.Click on the last product.
5.Click "Add to cart".
6.Verify that the product is added to the cart.
*/

public class TC_testAddLastProductToCart_005 extends BaseTest {
	
	@Test
	public void testAddLastProductToCart() throws InterruptedException, IOException
	{
		
		ProductAddToCartPage AddtoCart=new ProductAddToCartPage(driver);
		Thread.sleep(3000);
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("scroll(0,-1000)");
		Thread.sleep(3000);
		
		String expectedResult="Product added";
		  
			AddtoCart.clickNextButton();
			Thread.sleep(3000);
			AddtoCart.clickLastProduct();
			Thread.sleep(3000);
			AddtoCart.clickAddtoCart();
			Thread.sleep(3000);
			String addtocarttext=driver.switchTo().alert().getText();
			boolean proadd=addtocarttext.contains(expectedResult);
			if(proadd==true)
			{
				Thread.sleep(3000);
				System.out.println("Product Add to cart is successfully Done");
				driver.switchTo().alert().accept();
				Assert.assertTrue(true);
			}
			else
			{   capturescreen (driver,"testAddLastProductToCart" );
				System.out.println("Product Add to cart is Failed");
				Assert.assertTrue(false);
			}
			
		}

}
