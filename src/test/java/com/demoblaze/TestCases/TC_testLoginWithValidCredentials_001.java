package com.demoblaze.TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.demoblaze.pageObjects.LoginPage;

/*Manual Steps:

Open the web browser.
Navigate to https://www.demoblaze.com/.
Click on the "Log in" button.
Enter a valid username and password.
Click on the "Log in" button.
Verify that the login is successful.
 */
public class TC_testLoginWithValidCredentials_001 extends BaseTest {
	
	@Test
	public void testLoginWithValidCredentials() throws IOException, InterruptedException 
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
		if (driver.getTitle().equals("STORE"))
		{
			Assert.assertTrue(true);
			//logger.info("User Login Test case Passed");
		}
		else
		{
			capturescreen (driver,"testLoginWithValidCredentials" );
			Assert.assertTrue(false);
			//logger.info("User Login Test case Failed");
		}
		
		//System.out.println(driver.getTitle());
	}

}
