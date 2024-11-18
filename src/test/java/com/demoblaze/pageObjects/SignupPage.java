package com.demoblaze.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoblaze.TestCases.TestData;


public class SignupPage {
	WebDriver ldriver;
	public SignupPage (WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);	
	}
	
	@FindBy(id="signin2")
	WebElement btnNewSignup;
	
	@FindBy(id="sign-username")
	public WebElement Username;
	
	@FindBy(id="sign-password")
	public WebElement UserPassword;
	
	@FindBy(xpath="//button[contains (text(),'Sign up')]")
	WebElement SignupSubmitbtn;
	
	@FindBy(xpath="//a[contains (text(),'Log out')]")
	WebElement Logout;
	
	// Unique XPath for the close button in the login modal
    @FindBy(xpath = "//div[@id='logInModal']//button[@class='close']")
    WebElement closeButton;
	
	
		
	public void clickSignup()
	{
		btnNewSignup.click();
	}
    
	public void setUserName(String signupuname)
	{
	Username.sendKeys(signupuname);
	
	
	}
	
	public void setUserPassword(String signuppwd)
	{
	UserPassword.sendKeys(signuppwd);
	}
	
	public void clickSignupSubmit()
	{
		SignupSubmitbtn.click();
	}
	
	public void ClickLogout()
	{
		Logout.click();
	}
	
	public void ClickClose()
	{
		closeButton.click();
	}
	
}
