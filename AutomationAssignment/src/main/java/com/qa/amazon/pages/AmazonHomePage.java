package com.qa.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class AmazonHomePage extends TestBase  {
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchBox;
	
	
	
	@FindBy(xpath="//span[contains(text(),'Apple iPhone XR (64GB) - Yellow')]")
	WebElement appleiPhoneYellowLink;
	
	@FindBy(xpath="//a[contains(@href,'/Apple-iPhone-XR-64GB-Yellow/')]//span[text()='47,900']")
	WebElement priceTextA;
	
	
	
	public AmazonHomePage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public void passDataInSearchBox() {
		searchBox.sendKeys(properties.getProperty("testData"));
	}
	
	public String getPriceTextA() {
		return priceTextA.getText();
	}
	
	public AmazonIPhonePage clickOnAppleiPhoneYellowLink() {
		appleiPhoneYellowLink.click();
		return new AmazonIPhonePage();
	}

}
