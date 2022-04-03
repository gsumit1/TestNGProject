package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class HomePage {
	@SuppressWarnings("unused")
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//a[contains(.,'Home')]")
	public WebElement home;

	@FindBy(xpath = "//a[contains(.,'REGISTER')]")
	public WebElement rEGISTER;

	@FindBy(xpath = "//a")
	public List<WebElement> all;

	@FindBy(xpath = "//a[contains(.,'Flights')]")
	public WebElement Flight_lnk;
	
	
	public void clickOnRegistration() {
		rEGISTER.click();
		
	}

	
	public void clickOnFlightReservation() {
		Flight_lnk.click();
		
	}

}
