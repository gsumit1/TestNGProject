package com.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import Utility.DriverFactory;

public class BaseClass {

	public WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = DriverFactory.startApp(driver);
	}

	@AfterClass
	public void tearDown() {
		DriverFactory.tearDown(driver);

	}

}
