package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class demoTest {
	WebDriver driver;

	@BeforeMethod
	public void beforeClass() {
		System.out.println("data");
		System.out.println("This will execute before the Class");
		System.setProperty("webdriver.chrome.driver", "C:\\Training-PPT\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	

	
	@Test
	public void testCase1() {
		System.out.println("demo");
		driver.get("http://demo.guru99.com/test/newtours/index.php");
		driver.findElement(By.xpath("//a[contains(.,'REGISTER')]")).click();
		driver.findElement(By.xpath("//input[contains(@name,'email')]")).sendKeys("Sumit");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println(driver.findElement(By.xpath("//*[contains(text(),' Thank you ')]")).isDisplayed());
		
	}

	@Test
	public void testCase2() {
		System.out.println("This is the A Normal Test Case2");
	}

	@Test
	public void testCase3() {
		System.out.println("This is the A Normal Test Case3");
	}


	@AfterMethod
	public void afterClass() {
		driver.close();
		driver.quit();
	}


}
