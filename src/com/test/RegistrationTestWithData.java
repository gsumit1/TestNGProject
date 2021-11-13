package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.HomePage;
import com.pages.RegistrationPage;
import com.pages.RegistrationSuccess;

public class RegistrationTestWithData extends BaseClass {
	// This method will provide data to any test method that declares that its Data
	// Provider
	// is named "test1"
	@DataProvider(name = "getTestData")
	public Object[][] createData1() {
		List<HashMap<String, String>> arrayMapList = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> hashMapItems = new HashMap<String, String>();
		hashMapItems.put("UserName", "sumit");
		hashMapItems.put("Password", "ibm");
		hashMapItems.put("Confirm Password", "ibm");
		arrayMapList.add(hashMapItems);
		// Iterate the array list and store each HashMap object in an object array.
		// First dimension is the iterator value.
		Object[][] hashMapObj = new Object[arrayMapList.size()][1];
		for (int i = 0; i < arrayMapList.size(); i++) {
			hashMapObj[i][0] = arrayMapList.get(i);
		}
		return hashMapObj;
	}

	@Test(dataProvider = "getTestData")
	public void registration_of_user(HashMap<String, String> hashMapValue) {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		RegistrationPage reg = PageFactory.initElements(driver, RegistrationPage.class);
		RegistrationSuccess regSuccess = PageFactory.initElements(driver, RegistrationSuccess.class);
		home.rEGISTER.click();
		reg.register_user(hashMapValue);
		Assert.assertTrue(regSuccess.successMessage.isDisplayed());
	}

}
