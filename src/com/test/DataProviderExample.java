package com.test;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
	@DataProvider(name = "test-data")
	public Object[][] dataProvFunc() {
		return new Object[][] { { "Selenium", "Delhi" }, { "QTP", "Bangalore" }, { "LoadRunner", "Chennai" } };
	}

	@Test(dataProvider = "test-data")
	public void search(String keyWord1, String keyWord2) {

		System.out.println(keyWord1 + " " + keyWord2);
		Reporter.log("Keyword entered is : " + keyWord1 + " " + keyWord2);

	}

}
