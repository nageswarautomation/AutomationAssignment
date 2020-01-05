package com.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.tripadvisor.pages.TripAdvisorAllResultsPage;
import com.qa.tripadvisor.pages.TripAdvisorHomePage;
import com.qa.tripadvisor.pages.TripAdvisorHotelsPage;
import com.qa.tripadvisor.pages.TripAdvisorWriteAReviewPage;

public class HotelReviewTest extends TestBase {
	
	public HotelReviewTest() {
		super();
	}
	
	TripAdvisorHomePage homePageT;
	TripAdvisorAllResultsPage allResultsPage;
	TripAdvisorHotelsPage hotelPage;
	TripAdvisorWriteAReviewPage writeAReviewPage;
	
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		driver.get(properties.getProperty("urlT"));
		
		homePageT=new TripAdvisorHomePage();
		allResultsPage=new TripAdvisorAllResultsPage();
		hotelPage=new TripAdvisorHotelsPage();
		writeAReviewPage=new TripAdvisorWriteAReviewPage();
	}
	
	
	@Test
	public void writeAReviewTest() {
		
		homePageT.clickOnSearchBox();
		homePageT.passDataInSearchBox();
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		
		allResultsPage.clickOnClubMahindraMadikeriLink();
		
		//hotelPage.clickOnWriteAReviewLink();
			
		WebElement writeAReview=driver.findElement(By.xpath("//a[@class='ui_button primary']"));
		
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", writeAReview);
		writeAReview.click();
		
		WebElement overAllRating=driver.findElement(By.xpath("//span[@class='ui_bubble_rating fl bubble_50']"));
		act.moveToElement(overAllRating).click().perform();
		
		writeAReviewPage.setTitleOfYourReview();
		writeAReviewPage.setYourReview();
		
		boolean hotelRankingsPresence=writeAReviewPage.checkHotelRankings();
		
		if(hotelRankingsPresence==true) {
			WebElement serviceRating=driver.findElement(By.xpath("//span[@class='answersBubbles ui_bubble_rating fl qid12 bubble_50']"));
			act.moveToElement(serviceRating).click().perform();
			
			WebElement valueRating=driver.findElement(By.xpath("//span[@class='answersBubbles ui_bubble_rating fl qid13 bubble_50']"));
			act.moveToElement(valueRating).click().perform();
			
			WebElement locationRating=driver.findElement(By.xpath("//span[@class='answersBubbles ui_bubble_rating fl qid47 bubble_00']"));
			act.moveToElement(locationRating).click().perform();
			
		}
		
		writeAReviewPage.clickOnSubmitReviewCheckBox();
		
	}
	
	
	@AfterMethod
	public void tearsDown() {
		driver.quit();
		
	}

}
