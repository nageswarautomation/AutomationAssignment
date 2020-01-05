package com.qa.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class AmazonIPhonePage extends TestBase {
	

	@FindBy(id="priceblock_ourprice")
	WebElement priceText;
	
	public AmazonIPhonePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String getPriceText() {
		return priceText.getText();
	
	}


}
