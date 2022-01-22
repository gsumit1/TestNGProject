package basic.testng.concepts.testData_05;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name = "test-data2")
	public Object[][] dataProvFunc2() {
		return new Object[][] { { "Selenium", "Delhi", "India" }, { "QTP", "Bangalore","UK" }, { "LoadRunner", "Chennai","USA" } };
	}


}