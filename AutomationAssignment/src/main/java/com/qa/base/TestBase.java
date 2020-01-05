package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.testutils.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties properties;
	
	public static EventFiringWebDriver e_driver;
	
	public TestBase() {
		
		properties=new Properties();
		
		try {
			FileInputStream inputStream=new FileInputStream(System.getProperty("user.dir") +  "/src/main/java"
					+ "/com/qa/config/config.properties");
			properties.load(inputStream);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	       
	public static void initialization() {
		
		String browserName=properties.getProperty("browser");
		
	    if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
		    driver=new ChromeDriver();
	    }else if(browserName.equals("FF")) {
	    	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Drivers/geckodriver.exe");
		    driver=new FirefoxDriver();
	    	
	    }
		 
		
	    
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		//driver.get(properties.getProperty("urlA"));
	}
			
}
	
