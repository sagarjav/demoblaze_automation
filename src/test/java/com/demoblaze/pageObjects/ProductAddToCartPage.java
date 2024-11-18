package com.demoblaze.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoblaze.TestCases.TestData;


public class ProductAddToCartPage {
	WebDriver ldriver;
	public ProductAddToCartPage (WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);	
	}
	
	
	@FindBy(xpath="//button[@id='next2']")
	public WebElement btnnext;
	
	
	@FindBy(xpath="//*[@id=\"tbodyid\"]/div[6]")
	WebElement lastProduct;
	
	@FindBy(xpath="//a[text()='Add to cart']")
	WebElement btnAddtoCart;
	
		
	public void clickNextButton()
	{
		btnnext.click();
	}
	
	public void clickLastProduct()
	{
		lastProduct.click();
	}
	
	public void clickAddtoCart()
	{
		btnAddtoCart.click();
	}
	
	public boolean isnextbtnenable()
	{
		return btnnext.isDisplayed();
	
	}
	
	
}
