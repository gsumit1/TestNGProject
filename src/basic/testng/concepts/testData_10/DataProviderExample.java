package basic.testng.concepts.testData_10;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
	
	/*
	@DataProvider(name = "test-data")
	public Object[][] dataProvFunc() {
		return new Object[][] { { "Selenium", "Delhi" }, { "QTP", "Bangalore" }, { "LoadRunner", "Chennai" } };
	}

	
	
	@Test(dataProvider = "test-data")
	public void search(String keyWord1, String keyWord2) {
		System.out.println("data");

		System.out.println(keyWord1 + " " + keyWord2);
		Reporter.log("Keyword entered is : " + keyWord1 + " " + keyWord2);

	}*/
	
	
	
	
	
	@DataProvider(name = "test-data1")
	public Object[][] dataProvFunc1() {
		return new Object[][] { { "Selenium", "Delhi", "India" }, { "QTP", "Bangalore","UK" }, { "LoadRunner", "Chennai","USA" } };
	}

	@Test(dataProvider = "test-data1")
	public void search1(String keyWord1, String keyWord2, String keyWord3) {
		System.out.println("data");

		System.out.println(keyWord1 + " " + keyWord2+" "+keyWord3);
		Reporter.log("Keyword entered is : " + keyWord1 + " " + keyWord2+" " +keyWord3);

	}
	

}