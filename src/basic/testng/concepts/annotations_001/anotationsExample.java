package basic.testng.concepts.annotations_001;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class anotationsExample {
	@Test //-5
	public void testCase1() {
		System.out.println("This is the A Normal Test Case");
	}

	@BeforeMethod //-4
	public void beforeMethod() {
		System.out.println("This will execute before every Method");
	}

	@AfterMethod //-6
	public void afterMethod() {
		System.out.println("This will execute after every Method");
	}

	@BeforeClass //-3
	public void beforeClass() {
		System.out.println("This will execute before the Class");
	}

	@AfterClass //-7
	public void afterClass() {
		System.out.println("This will execute after the Class");
	}

	@BeforeTest //-2
	public void beforeTest() {
		System.out.println("This will execute before the Test");
	}

	@AfterTest //-8
	public void afterTest() {
		System.out.println("This will execute after the Test");
	}

	@BeforeSuite //-1
	public void beforeSuite() {
		System.out.println("This will execute before the Test Suite");
	}

	@AfterSuite //-9
	public void afterSuite() {
		System.out.println("This will execute after the Test Suite");
	}
}
