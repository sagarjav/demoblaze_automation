package com.demoblaze.TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.demoblaze.pageObjects.LoginPage;

/*Negative Scenario: Attempt to log in with invalid credentials
 Manual Steps:

1.Open the web browser.
2.Navigate to https://www.demoblaze.com/.
3.Click on the "Log in" button.
4.Enter an invalid username and password.
5.Click on the "Log in" button.
6.Verify that an error message is displayed.
 */
public class TC_testLoginWithInvalidCredentials_002 extends BaseTest {
	
	@Test
	public void testLoginWithInvalidCredentials() throws IOException, InterruptedException 
	{
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		 Thread.sleep(3000);
		lp.Username.clear();
		 Thread.sleep(3000);
		lp.UserPassword.clear();
		 Thread.sleep(3000);
		//lp.setUserName(TestData.VALID_USERNAME);
		lp.setUserName(readconfig.getInValidUserName());
		 Thread.sleep(3000);
		//logger.info("Valid UserName Entered");
	//	lp.setUserPassword(TestData.VALID_PASSWORD);
		lp.setUserPassword(readconfig.getInValidPassword());
		 Thread.sleep(3000);
		//logger.info("Valid Password Entered");
		lp.clickSubmit();
		//logger.info("Clicked on Login Submit Button");
         Thread.sleep(3000);
        Alert LoginAlert =driver.switchTo().alert();
            String AlertText =LoginAlert.getText();
            System.out.println(AlertText);
        
            
         //String expectedSuccessMessage = "No Alert After login";
        String expectedFailureMessage = "User does not exist.";
        
       boolean isFailure=AlertText.contains(expectedFailureMessage);
        
		if (isFailure)
		{
			capturescreen (driver,"testLoginWithInvalidCredentials" );
			Assert.assertTrue(true);
			//logger.info("User Login Test case Failed");
			
			
		}
		else
		{
			Assert.assertTrue(false);
			System.out.println("User Successfully Login with Invalid Details ");
			//logger.info("User Login Test case Passed");
		}
		
		//System.out.println(driver.getTitle());
	}

}
