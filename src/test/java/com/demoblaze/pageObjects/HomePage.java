package com.demoblaze.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoblaze.TestCases.TestData;


public class HomePage {
	WebDriver ldriver;
	
	public HomePage (WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);	
	}

	// Locators
	
	//By productList = By.xpath("//div[@class='col-lg-4 col-md-6 mb-4']");
	@FindBy(xpath="//div[@class='col-lg-4 col-md-6 mb-4']")
	public WebElement productList;
	
	@FindBy(xpath="//a[text()='Phones']")
	public WebElement categoryPhones;
	
	@FindBy(xpath="//a[text()='Laptops']")
	public WebElement categoryLaptops;
	
	@FindBy(xpath="//a[text()='Monitors']")
	WebElement categoryMonitor;
	
	// Actions
		public boolean viewProductDisplayed()
		{
			//isDisplayed(By.xpath("div[@class='col-lg-4 col-md-6 mb-4']"));
			//productList.click();
			
			if (productList.isDisplayed())
			{
				return true;
			}
			else
			{
						return false;
			}
			
		}
	private void isDisplayed(By xpath) {
		// TODO Auto-generated method stub
		
	}
	/*public boolean areProductsDisplayed()
	{
		return ldriver.findElements(productList).size() > 0;
		
	}
	
	public List<WebElement> getProductList() {
        return ldriver.findElements(productList);
    }*/
	
	
	public void clickCatagoryPhones()
	{
		categoryPhones.click();
		
	}
	
	public void clickCatagoryLaptops()
	{
		categoryLaptops.click();
	}
	
	public void clickCatagoryMonitos()
	{
		categoryMonitor.click();
	}
	
	public boolean areCategoryProductsDisplayed() 
	{
	   //return ldriver.findElements((By) productList).size()>0;
	   if (productList.isDisplayed())
		{
			return true;
		}
		else
		{
					return false;
		}
	
	}
	
	
	
}
