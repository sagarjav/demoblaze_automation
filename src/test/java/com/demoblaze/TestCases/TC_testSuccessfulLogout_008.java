package com.demoblaze.TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.demoblaze.pageObjects.LoginPage;

/*Positive Scenario: Successfully log out
Manual Steps:

Open the web browser.
Navigate to https://www.demoblaze.com/.
Log in with valid credentials.
Click on the "Log out" button.
Verify that the logout is successful.
 */
public class TC_testSuccessfulLogout_008 extends BaseTest {
	
	@Test
	public void testSuccessfulLogout() throws IOException, InterruptedException 
	{
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin();
		 Thread.sleep(3000);
		lp.Username.clear();
		 Thread.sleep(3000);
		lp.UserPassword.clear();
		 Thread.sleep(3000);
		//lp.setUserName(TestData.VALID_USERNAME);
		lp.setUserName(readconfig.getValidUserName());
		 Thread.sleep(3000);
		//logger.info("Valid UserName Entered");
	//	lp.setUserPassword(TestData.VALID_PASSWORD);
		lp.setUserPassword(readconfig.getValidPassword());
		 Thread.sleep(3000);
		//logger.info("Valid Password Entered");
		lp.clickSubmit();
		//logger.info("Clicked on Login Submit Button");
         Thread.sleep(3000);
		lp.ClickLogout();
		boolean log=lp.isLoginbtnDisplayed();
       
		if (log==true)
		{
			
			//logger.info("User Login Test case Passed");
			System.out.println("user logout successfully");
			Assert.assertTrue(true);
		}
		else
		{
			capturescreen (driver,"testLoginWithValidCredentials" );
			
			//logger.info("User Login Test case Failed");
			System.out.println("user logout failed");
			Assert.assertTrue(false);
		}
		
		//System.out.println(driver.getTitle());
	}

}
