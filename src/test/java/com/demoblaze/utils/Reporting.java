package com.demoblaze.utils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

// Listener class used to generate Extent reports
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting implements ITestListener 
{
   
    public ExtentReports extent;
    public ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
    	 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
         String reportFileName = "Test-report-" + timeStamp + ".html";
    	
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+reportFileName);
        htmlReporter.config().setDocumentTitle("Automation Test Report");
        htmlReporter.config().setReportName("Functional Test Report");
        htmlReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "Your Host Name");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "SAGAR BANKAR");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName());
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        test.fail(result.getThrowable());
        
       String screenshotpath=System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png";
    
       File f=new File(screenshotpath);
       
       if (f.exists())
       {
    	  try {
    		    test.fail("Screenshot is below"+test.addScreenCaptureFromPath(screenshotpath));
    	      }
    	  catch (Exception e)  //  IOException need here
    	         {
    		  e.printStackTrace();
    	         }
    	  
       }
      
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.skip(result.getThrowable());
    }

    @Override
    public void onTestStart(ITestResult result) {
        // This method is called when the test starts
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // This method is not used often, but can be implemented if needed
    }
    
 
}
