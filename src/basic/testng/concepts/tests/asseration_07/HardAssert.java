package basic.testng.concepts.tests.asseration_07;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.base.BaseClass;
import com.pages.HomePage;

public class HardAssert extends BaseClass{
	
	@Test
	public void test_my_page() {
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		Assert.assertEquals(driver.getTitle(), "WelCome: Mercury Tours1","Title Mismatch");
		Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours","Title Mismatch");
		Assert.assertEquals(home.rEGISTER.getText(), "Welcome", "Incorrect Link Name");		
		
	}

	

}
