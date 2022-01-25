package com.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.pages.HomePage;
import com.pages.ReservationPages.ReservationConfirmationPage;
import com.pages.ReservationPages.ReservationPage;

public class ReservationTest extends BaseClass {

	@Test
	public void reservation_of_user() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		ReservationPage reservation = PageFactory.initElements(driver, ReservationPage.class);
		ReservationConfirmationPage confirmation = PageFactory.initElements(driver, ReservationConfirmationPage.class);

		home.clickOnFlightReservation();
		reservation.setFromLocation("London");
		reservation.setToLocation("New York");
		reservation.clickOnContinue();
		Assert.assertTrue(confirmation.reservationMessage.isDisplayed());
	}
}