package com.qa.tripadvisor.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class TripAdvisorAllResultsPage  extends TestBase{
	
	@FindBy(xpath="//span[contains(text(),'Club Mahindra Madikeri, Coorg')]")
	WebElement clubMahindraMadikeriLink;
	
	public TripAdvisorAllResultsPage() {
	
		PageFactory.initElements(driver, this);
		
	}
	
	public TripAdvisorHotelsPage clickOnClubMahindraMadikeriLink() {
	
		clubMahindraMadikeriLink.click();
		return new TripAdvisorHotelsPage();
	}


}
