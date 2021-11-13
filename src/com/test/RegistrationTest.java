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

public class RegistrationTest extends BaseClass {

	@Test
	public void registration_of_user() {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		RegistrationPage reg = PageFactory.initElements(driver, RegistrationPage.class);
		RegistrationSuccess regSuccess = PageFactory.initElements(driver, RegistrationSuccess.class);

		home.rEGISTER.click();
		Map<String, String> userDetails = new HashMap<String, String>();
		userDetails.put("UserName", "Sumit");
		userDetails.put("Password", "IBM@123");
		userDetails.put("Confirm Password", "IBM@123");
		reg.register_user(userDetails);
		Assert.assertTrue(false);
		// Assert.assertTrue(regSuccess.successMessage.isDisplayed());
	}

}
