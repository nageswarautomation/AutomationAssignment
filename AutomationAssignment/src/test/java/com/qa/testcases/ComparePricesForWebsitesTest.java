package com.qa.testcases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.amazon.pages.AmazonHomePage;
import com.qa.amazon.pages.AmazonIPhonePage;
import com.qa.base.TestBase;
import com.qa.flipkart.pages.FlipkartIPhonePage;
import com.qa.flipkart.pages.FlipkartHomePage;

public class ComparePricesForWebsitesTest extends TestBase{
	
	AmazonHomePage homePageA;
	AmazonIPhonePage iPhonePageA;
	FlipkartHomePage homePageF;
	FlipkartIPhonePage iPhonePageF;
	
	public ComparePricesForWebsitesTest() {
		super();
	}
	
	@BeforeMethod	
	public void setup() {
		
		initialization();
		driver.get(properties.getProperty("urlA"));
		
		homePageA=new AmazonHomePage();
		iPhonePageA=new AmazonIPhonePage();
		homePageF=new FlipkartHomePage();
		iPhonePageF=new FlipkartIPhonePage();
	}
	
	
	@Test
	public void ComparePrices() {
		
	
		homePageA.passDataInSearchBox();
		
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		
		String parentWindow=driver.getWindowHandle();
		homePageA.clickOnAppleiPhoneYellowLink();
		for(String childWindowA: driver.getWindowHandles()) {
			driver.switchTo().window(childWindowA);
		}
		
		String priceA=iPhonePageA.getPriceText();
		System.out.println(priceA);
		
		driver.close();
    	driver.switchTo().window(parentWindow);
		
		act.sendKeys(Keys.CONTROL+"t");
		
		driver.get(properties.getProperty("urlF"));
		
		homePageF.clickOnCloseBttn();
		homePageF.searching();
		act.sendKeys(Keys.ENTER).perform();
		
		homePageF.clickOnAppleIPhoneYellowLink();
		
		for(String childWindowF: driver.getWindowHandles() ) {
			driver.switchTo().window(childWindowF);
		}
		String priceF=iPhonePageF.getPriceText();
		System.out.println(priceF);
		
		driver.close();
		driver.switchTo().window(parentWindow);
		
		priceA=priceA.replaceAll("[^0-9.]","");
		System.out.println(priceA);
		
		priceF=priceF.replaceAll("[^0-9]","");
		System.out.println(priceF);
		
		//int dA=Integer.parseInt(priceA);
		double dA=Double.parseDouble(priceA);
		
		//int dF=Integer.parseInt(priceF);
		Double dF=Double.parseDouble(priceF);
		
		if(dA < dF) {
			System.out.println(dA);
			
		}else {
			System.out.println(dF);
		}
		double actual=dA;
		Assert.assertEquals(actual, 47900.0);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}

}
