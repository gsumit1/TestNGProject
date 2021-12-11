package TestDataPackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestDataClass {
	
	@Test(dataProvider = "test-data2", dataProviderClass=TestData.class)
	public void search1(String keyWord1, String keyWord2, String keyWord3) {
		System.out.println("data");

		System.out.println(keyWord1 + " " + keyWord2+" "+keyWord3);
		Reporter.log("Keyword entered is : " + keyWord1 + " " + keyWord2+" " +keyWord3);

	}

}
