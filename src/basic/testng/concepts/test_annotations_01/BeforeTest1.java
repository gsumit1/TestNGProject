package basic.testng.concepts.test_annotations_01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeTest1 {
	

	
	@BeforeTest 
	public void beforeTest() {
		System.out.println("This will execute before the Test1");
	}

	@BeforeMethod 
	public void beforeMethod() {
		System.out.println("This will execute before every Method1");
	}
	
	@Test 
	public void testCase1() {
		System.out.println("This is the A Normal Test Case1");
	}
	
	@Test 
	public void testCase2() {
		System.out.println("This is the A Normal Test Case2");
	}

	@AfterMethod 
	public void afterMethod() {
		System.out.println("This will execute after every Method1");
	}

	@AfterTest 
	public void afterTest() {
		System.out.println("This will execute after the Test1");
	}




}
