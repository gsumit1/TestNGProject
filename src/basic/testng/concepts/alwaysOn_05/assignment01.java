package basic.testng.concepts.alwaysOn_05;

import org.testng.Assert;
import org.testng.annotations.Test;

public class assignment01 {

	public class NewTest {
		@Test
		public void A() {
			//Assert.assertEquals("Sumit", "Ghosh");
		}

		@Test
		public void B() {
		}

		@Test(priority = 2)
		public void C() {
		}

		@Test(priority = 1, dependsOnMethods = "A", alwaysRun = true)
		public void D() {
		}
	}

}
//CDBA

//DCAB