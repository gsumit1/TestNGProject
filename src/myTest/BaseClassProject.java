package myTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClassProject {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		
		//driver initialize
		
	}
	
	@AfterClass
	public void teardown(){
		//quit browser
		
	}

}
