package basic.testng.concepts.dependsOn_04;

import org.testng.annotations.Test;

public class DependentTestExamples1
{
	@Test(dependsOnMethods = { "testTwo" })
	public void testOne() {
		System.out.println("Test method one");
	}

	@Test
	public void testTwo() throws Exception {
		System.out.println("Test method two");
	}
}

//throw new Exception();