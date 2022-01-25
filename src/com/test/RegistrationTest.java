package com.test;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.pages.HomePage;
import com.pages.RegistrationPages.RegistrationPage;
import com.pages.RegistrationPages.RegistrationSuccess;

public class RegistrationTest extends BaseClass {

	@Test
	public void registration_of_user() {
		
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		RegistrationPage reg = PageFactory.initElements(driver, RegistrationPage.class);
		RegistrationSuccess regSuccess = PageFactory.initElements(driver, RegistrationSuccess.class);

		home.clickOnRegistration();
		
		
		Map<String, String> userDetails = new HashMap<String, String>();
		
		userDetails.put("UserName", "Sumit");
		userDetails.put("Password", "IBM@123");
		userDetails.put("Confirm Password", "IBM@123");
		reg.register_user(userDetails);
		
			
		Assert.assertEquals(driver.getTitle(),"Register: Mercury Tours");
		
		 Assert.assertTrue(regSuccess.successMessage.isDisplayed());
		//Assert.assertTrue(false);
		//
	}

}
