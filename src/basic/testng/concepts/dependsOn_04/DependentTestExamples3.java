package basic.testng.concepts.dependsOn_04;

import org.testng.annotations.Test;



public class DependentTestExamples3
{
	@Test(dependsOnGroups = { "test-group" })
	public void groupTestOne() {
		System.out.println("Group Test method one");
	}

	@Test(groups = { "test-group" })
	public void groupTestTwo() {
		System.out.println("Group test method two");
	}

	@Test(groups = { "test-group" })
	public void groupTestThree() {
		System.out.println("Group Test method three");
	}
}