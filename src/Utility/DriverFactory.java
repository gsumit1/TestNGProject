package Utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	
	public static String url;

	public static WebDriver startApp(WebDriver driver,String url) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/riyaanghosh/git/TestNGProject/chromedriver");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public static void tearDown(WebDriver driver) {
		driver.quit();
	}

}
