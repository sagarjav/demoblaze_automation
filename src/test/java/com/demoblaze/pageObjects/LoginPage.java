package com.demoblaze.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoblaze.TestCases.TestData;


public class LoginPage {
	WebDriver ldriver;
	public LoginPage (WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);	
	}
	
	@FindBy(id="login2")
	WebElement btnLogin;
	
	@FindBy(id="loginusername")
	public WebElement Username;
	
	@FindBy(id="loginpassword")
	public WebElement UserPassword;
	
	@FindBy(xpath="//button[contains (text(),'Log in')]")
	public WebElement Loginbtn;
	
	@FindBy(xpath="//a[contains (text(),'Log out')]")
	public WebElement Logout;
	
	// Unique XPath for the close button in the login modal
    @FindBy(xpath = "//div[@id='logInModal']//button[@class='close']")
    WebElement closeButton;
	
	
		
	public void clickLogin()
	{
		btnLogin.click();
	}
    
	public void setUserName(String uname)
	{
	Username.sendKeys(uname);
	
	
	}
	
	public void setUserPassword(String pwd)
	{
	UserPassword.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		Loginbtn.click();
	}
	
	public void ClickLogout()
	{
		Logout.click();
	}
	
	public void ClickClose()
	{
		closeButton.click();
	}
	
	public boolean isLoginbtnDisplayed()
	{
		//return btnLogin.isDisplayed();
		return btnLogin.isEnabled();
	}
	
}
