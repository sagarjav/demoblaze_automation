package com.demoblaze.TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demoblaze.pageObjects.LoginPage;
import com.demoblaze.utils.XLUtils;

public class TC_UserLoginTestDDT_002 extends BaseTest
{
    @Test (dataProvider="Testing")
	public void loginDDT(String user, String pwd) throws IOException, InterruptedException
	{
    	LoginPage lp=new LoginPage(driver);
    	lp.clickLogin();
    	Thread.sleep(5000);
    	lp.Username.clear();
    	Thread.sleep(5000);
    	lp.UserPassword.clear();
    	lp.setUserName(user);
    	Thread.sleep(5000);
    	lp.setUserPassword(pwd);
    	Thread.sleep(5000);
    	lp.clickSubmit();
    
    	Thread.sleep(5000);
    
    	
    	if (isAlertPresent()==true)
    	{
    		
    		Alert alert1=driver.switchTo().alert(); //close alert
    		String error=alert1.getText();
    		System.out.println("Test case fail Reason"+" "+error);
    		alert1.accept();
    		//driver.switchTo().alert().dismiss();
    		lp.ClickClose();
    		Thread.sleep(5000);
    		
    		driver.switchTo().defaultContent();
    		Assert.assertTrue(false);
    	}
    	else
    	{
    		Assert.assertTrue(true);
    		Thread.sleep(2000);
    		lp.ClickLogout();
    		Thread.sleep(2000);
    		System.out.println("loginDDT test is passed");
    	}
	}
    
    
    public boolean isAlertPresent()  //user defined method to check alert is present or not
    {
    	try
    	{
    	driver.switchTo().alert();
    	return true;
    	}
    	catch(NoAlertPresentException e)
    	{
    	return false;
    	}
    }
    
    
    /*
    @DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
    	System.out.println("LoginData is done");
	//	String path=System.getProperty("user.dir")+"/src/test/java/com/demoblaze/testData/LoginData.xlsx";
		String path=System.getProperty("\\C:\\Users\\HP\\Desktop\\LoginData.xlsx");
		System.out.println("xlsx File fetch ");
		//int rownum=XLUtils.getRowCount(path , "Sheet1");
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		 System.out.println("xlsx File fetch "+rownum);
	    int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
	    System.out.println("Array start"+rownum+colcount);
	
	String loginData [][]=new String [rownum][colcount];
	   
	    for (int i=1; i<=rownum; i++ )
	    {
		  for(int j=0; j<colcount; j++)
		  {
			loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i,j);//1 0
		  }
	    }
	    System.out.println(loginData);
	   return loginData; 
	}
	*/
    @DataProvider(name = "Testing")
    public Object[][] tData() 
    {
        return new Object[][] 
        {
            {"sagarB", "Sagar@123$%"},
            {"SagarB", "Wrongpassword"},
            {"invaliduser", "Sagar@123$%"},
            {"invaliduser", "invalidpass"},
            {"sagarB", "Sagar@123$%"},
        };
    }

	
	
}
