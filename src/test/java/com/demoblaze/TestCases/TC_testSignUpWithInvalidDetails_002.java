package com.demoblaze.TestCases;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import com.demoblaze.pageObjects.SignupPage;
import com.demoblaze.utils.TestData;
/*
 * Negative Scenario: Sign up with an already used username
 * 
 * Manual Steps:
 * 1. Open the web browser.
 * 2. Navigate to https://www.demoblaze.com/.
 * 3. Click on the "Sign up" button.
 * 4. Enter an already used username and password.
 * 5. Click on the "Sign up" button.
 * 6. Verify that an error message is displayed.
 */

public class TC_testSignUpWithInvalidDetails_002 extends BaseTest {
    
    @Test
    public void testSignUpWithExistingUsername() throws IOException, InterruptedException {
        SignupPage sign = new SignupPage(driver);
        sign.clickSignup();
        sign.Username.clear();
        sign.UserPassword.clear();
        
        // Using existing username and password
        sign.setUserName(TestData.VALID_USERNAME);
        Thread.sleep(3000);
        sign.setUserPassword(TestData.VALID_PASSWORD);
        Thread.sleep(3000);
        sign.clickSignupSubmit();
        
        Thread.sleep(3000);
        
        // Handle alert
        Alert SignupAlert = driver.switchTo().alert();
        String alertText = SignupAlert.getText();
        System.out.println(alertText);
        
        String expectedSuccessMessage = "Sign up successful.";
        String expectedFailureMessage = "This user already exist.";
        
        boolean isSuccess = alertText.contentEquals(expectedSuccessMessage);
        boolean isFailure = alertText.contentEquals(expectedFailureMessage);
        
        if (isSuccess) 
        {
            Thread.sleep(3000);
            SignupAlert.accept();
            Thread.sleep(3000);
            System.out.println("New user Sign up successful.");
            Assert.assertTrue(true);
        } 
        else if (isFailure) 
        {
            
            capturescreen(driver, "testSignUpWithInvalidDetails");
            Thread.sleep(3000);
            SignupAlert.accept();
            System.out.println(alertText);
            Assert.assertTrue(true);
        } 
        else 
        {
        	capturescreen(driver, "testSignUpWithInvalidDetails");
            System.out.println(alertText);
            Assert.assertTrue(false);
            
        }
    }
}
