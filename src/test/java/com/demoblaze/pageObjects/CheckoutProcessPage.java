package com.demoblaze.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoblaze.TestCases.TestData;


public class CheckoutProcessPage {
	
	WebDriver ldriver;
	public CheckoutProcessPage (WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);	
	}
	
	@FindBy(xpath="//div[@id='tbodyid']//div[1]//div[1]//a[1]//img[1]")
	public WebElement selecttProduct;
	
	
	
	@FindBy(xpath="//a[@class='btn btn-success btn-lg']")
	public WebElement btnAddtoCart;
	
	@FindBy(xpath="//a[@id='cartur']")
	public WebElement cart;
	
	@FindBy(xpath="//button[normalize-space()='Place Order']")
	public WebElement placeorder;
	
	@FindBy(xpath="//*[@id=\"name\"]")
	public WebElement name;
	
	@FindBy(xpath="//*[@id=\"card\"]")
	public WebElement creditcard;
	
	@FindBy(xpath="//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")
	public WebElement purchase;
	
	@FindBy(xpath = "/html/body/div[10]")
   public WebElement orderConfirmationMessage;
	
	public void clickonProduct()
	{
		selecttProduct.click();
	}
	
	public void clickaddtoCart()
	{
		btnAddtoCart.click();
	}
	
	public void clickCart()
	{
		cart.click();
	}
	
	public void clickPlaceOrder()
	{
		placeorder.click();
	
	}
	
	public void clickpurchase()
	{
		purchase.click();
	}
	
	public String getOrderConfirmationMessage() 
	{
		String confirm=orderConfirmationMessage.getText();
    return confirm;
	}
	 
	
	
	
}
