package com.demoblaze.TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.demoblaze.utils.ReadConfig;

import net.bytebuddy.utility.RandomString;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.LogManager;

public class BaseTest 
{
    protected WebDriver driver;
  // public static Logger logger;
    ReadConfig readconfig=new ReadConfig();
    
	@BeforeClass
	 public void setUp() throws InterruptedException 
	 {
	        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        driver.manage().window().maximize();
	        //logger=(Logger) LogManager.getLogger(BaseTest.class);
	      //  PropertyConfigurator.configure("Log4j.properties");
	    	Thread.sleep(2000);
	        driver.get(TestData.BASE_URL);
	        System.out.println("BaseTest is done");
	        
	       // driver.get(readconfig.getApplicationUrl()); 
	 }
	@AfterClass
	public void tearDown()
	{
		if (driver!= null)
		{
			driver.quit();
		}
	}
	
	public void capturescreen (WebDriver driver, String tname) throws IOException 
	{
	try 
	  {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir") + "/Screenshots/" + tname + ".png";
		File target=new File(screenshotPath);
		//File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot is taken"+screenshotPath);
		
	  } catch(IOException e)
	  {
		  System.out.println("Error while taking screenshot: " + e.getMessage());
          throw e;
	  }
		
	}
	
	 public  String randomstring ()
	    {
	    	String UniqueString=RandomStringUtils.randomAlphabetic(8);
	    	
	    
	    return (UniqueString);
	    }
	    
	 public static String randomNum ()
	    {
	    	String UniqueNum=RandomStringUtils.randomAlphanumeric(4, 8);
	    	
	    return (UniqueNum);
	    }
	

}
