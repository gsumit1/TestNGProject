package basic.testng.concepts.test_annotations_01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeTest2 {
	

	
	@BeforeTest //-2
	public void beforeTest() {
		System.out.println("This will execute before the Test21");
	}

	@BeforeMethod //-4
	public void beforeMethod() {
		System.out.println("This will execute before every Method21");
	}
	
	@Test //-5
	public void testCase1() {
		System.out.println("This is the A Normal Test Case21");
	}
	
	@Test //-5
	public void testCase2() {
		System.out.println("This is the A Normal Test Case22");
	}

	@AfterMethod //-6
	public void afterMethod() {
		System.out.println("This will execute after every Method21");
	}

	@AfterTest //-8
	public void afterTest() {
		System.out.println("This will execute after the Test21");
	}




}