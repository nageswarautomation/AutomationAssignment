package com.qa.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class FlipkartHomePage extends TestBase {
	
	@FindBy(xpath="//button[@class='_2AkmmA _29YdH8']")
	WebElement closeBttn;
	
	@FindBy(name="q")
	WebElement searchBox;
	
	@FindBy(xpath="//div[contains(text(),'Apple iPhone XR (Yellow, 64 GB)')]")
	WebElement flipkartAppleIPhoneYellowLink;
	
	@FindBy(xpath="//div[@class='_1vC4OE _2rQ-NK' and text()='₹53,999']")
	WebElement priceTextF;
	
	
	
	public FlipkartHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCloseBttn() {
		closeBttn.click();
	}

	public void searching() {
		searchBox.sendKeys(properties.getProperty("testData"));
	}
	
	public String getPriceTextF() {
		return priceTextF.getText();
	}
	
	public FlipkartIPhonePage clickOnAppleIPhoneYellowLink() {
		flipkartAppleIPhoneYellowLink.click();
		return new FlipkartIPhonePage();
	}
	

}
