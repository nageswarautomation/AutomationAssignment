package com.qa.tripadvisor.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class TripAdvisorHomePage extends TestBase {
	
	@FindBy(xpath="//div[@title='Search']")
	WebElement searchBox;
	
	@FindBy(id="mainSearch")
	WebElement search;
	
	
	
	public TripAdvisorHomePage() {
	
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnSearchBox() {
		
		searchBox.click();
	}
	
   public void passDataInSearchBox() {
		
		search.sendKeys(properties.getProperty("testData1"));
	}


}
