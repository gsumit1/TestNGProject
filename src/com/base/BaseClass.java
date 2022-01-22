package com.base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import Utility.DriverFactory;

public class BaseClass {
	public WebDriver driver;
	public String url;
	
	
	@BeforeSuite
	public void setUpEnv() throws IOException {
		FileReader reader=new FileReader("env.properties");
		Properties p=new Properties();
		p.load(reader);
		url=p.getProperty("test.url");

	}

	@BeforeClass
	public void setUp() throws IOException {
		driver = DriverFactory.startApp(driver,url);
	}

	@AfterClass
	public void tearDown() {
		DriverFactory.tearDown(driver);

	}
	
	@AfterMethod
	public void FailedTestCases(ITestResult result) throws IOException {

		if (!result.isSuccess()) {
		String name=result.getMethod().getMethodName()+" "+new SimpleDateFormat("MM-dd-yyyy-HH-ss").format(new GregorianCalendar().getTime());
			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile = new File(".//"+name+".png");
			FileUtils.copyFile(SrcFile, DestFile);
		}
	}

}