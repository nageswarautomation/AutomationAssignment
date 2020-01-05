package com.qa.testutils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT=30;
	public static long IMPLICIT_WAIT=30;
	
	
	public static void takeScreenshot() throws IOException {
		File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir=System.getProperty("usser.dir");
		FileUtils.copyFile(srcFile, new File(currentDir + "/screeenshots/" + System.currentTimeMillis() + ".png"));

	}	


}
