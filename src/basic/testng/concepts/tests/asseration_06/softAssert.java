package basic.testng.concepts.tests.asseration_06;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pages.HomePage;

public class softAssert extends BaseClass{
	
	@Test
	public void test_my_page() {
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		
		SoftAssert softAssert=new SoftAssert();
		
		softAssert.assertEquals(driver.getTitle(), "WelCome: Mercury Tours1","Title Mismatch");
		softAssert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours","Title Mismatch");
		softAssert.assertEquals(home.rEGISTER.getText(), "Welcome", "Incorrect Link Name");
		
		softAssert.assertAll();
		
		
		
	}

}