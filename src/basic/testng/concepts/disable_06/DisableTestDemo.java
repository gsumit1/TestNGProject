package basic.testng.concepts.disable_06;

import org.testng.annotations.Test;


public class DisableTestDemo
{
	@Test(enabled = true)
	public void testMethodOne() {
		System.out.println("Test method one.");
	}

	@Test(enabled = false)
	public void testMethodTwo() {
		System.out.println("Test method two.");
	}

	@Test
	public void testMethodThree() {
		System.out.println("Test method three.");
	}
}