package com.demoblaze.TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.demoblaze.pageObjects.SignupPage;
import com.demoblaze.utils.ReadConfig;

public class TC_testSignUpWithValidDetails_001 extends BaseTest
{
    @Test
	public void testSignUpWithValidDetails  () throws  IOException, InterruptedException
    {
    	SignupPage sign=new SignupPage(driver);
          sign.clickSignup();
          sign.Username.clear();
          sign.UserPassword.clear();
         
          String NewUsername=randomstring()+"User";
          sign.setUserName(NewUsername);
        // sign.setUserName(TestData.VALID_USERNAME);
          Thread.sleep(3000);
            String NewUserPassword=randomNum()+"@234";
            sign.setUserPassword(NewUserPassword);
         // sign.setUserPassword(TestData.VALID_PASSWORD);
          Thread.sleep(3000);
          sign.clickSignupSubmit();
         
          Thread.sleep(3000);
        
          Alert SignupAlert=driver.switchTo().alert();
          String Succesfully=SignupAlert.getText();
          System.out.println(Succesfully);
          String expectedResult1="Sign up successful.";
          String expectedResult2="This user already exist.";
       boolean  is=Succesfully.contentEquals(expectedResult1);
       boolean no=Succesfully.contentEquals(expectedResult2);
     
       if(is==true)
        {   
    	   
    	    Thread.sleep(3000);
        	SignupAlert.accept();
        	Thread.sleep(3000);
        	System.out.println("New user Sign up successful.");
        	Assert.assertTrue(true);
        }
        else if(no==false)
        {    
        	Thread.sleep(3000);
        	capturescreen (driver,"testSignUpWithValidDetails" );
        	Thread.sleep(3000);
        	SignupAlert.accept();
        	System.out.println(Succesfully);
        	Assert.assertTrue(false);
        }
        else
        {
        	System.out.println(Succesfully);
        	Assert.assertTrue(false);
        	capturescreen (driver,"testSignUpWithValidDetails" );
        }
        
        
    }
    
   
    
    
    
    
    
}
