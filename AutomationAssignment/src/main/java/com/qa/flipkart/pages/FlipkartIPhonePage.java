package com.qa.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class FlipkartIPhonePage extends TestBase{
	
	@FindBy(xpath="//div[@class='_1vC4OE _3qQ9m1']")
	WebElement priceText;
	
	public FlipkartIPhonePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String getPriceText() {
		return priceText.getText();
	
	}


}
