package com.qa.tripadvisor.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class TripAdvisorHotelsPage extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'Write a review')]")
	WebElement writeAReviewLink;
	
	public TripAdvisorHotelsPage() {
	
		PageFactory.initElements(driver, this);
		
	}
	
	public TripAdvisorWriteAReviewPage clickOnWriteAReviewLink() {
		
	
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", writeAReviewLink);
		writeAReviewLink.click();
		return new TripAdvisorWriteAReviewPage();
		
	}


}
