package com.qa.tripadvisor.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class TripAdvisorWriteAReviewPage extends TestBase {
	
	
	
	@FindBy(name="ReviewTitle")
	WebElement titleOfYourRveview;
	
	@FindBy(id="ReviewText")
	WebElement reviewText;
	
	@FindBy(xpath="//div[@class='question subRatingsList striped spaced']")
	WebElement hotelRankings;
	
	@FindBy(id="noFraud")
	WebElement submitReviewcheckBox;

	
	
	
	
	
	public TripAdvisorWriteAReviewPage() {
	
		PageFactory.initElements(driver, this);
		
	}
	
	public void setTitleOfYourReview() {
		titleOfYourRveview.sendKeys(properties.getProperty("reviewTitle"));
	}
	
	public void setYourReview() {
		reviewText.sendKeys(properties.getProperty("reviewText"));
	}
	public boolean checkHotelRankings() {
		hotelRankings.isDisplayed();
		return true;	
	}
	
	public void clickOnSubmitReviewCheckBox() {
		submitReviewcheckBox.click();
	}




}
