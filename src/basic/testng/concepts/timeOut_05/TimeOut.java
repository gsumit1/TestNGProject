package basic.testng.concepts.timeOut_05;

import org.testng.annotations.Test;

public class TimeOut
{
	@Test(timeOut = 500)
	public void timeTestOne() throws InterruptedException {          //Fails
		Thread.sleep(1000);
		System.out.println("Time test method one");
	}

	@Test(timeOut = 500)
	public void timeTestTwo() throws InterruptedException {
		Thread.sleep(400);
		System.out.println("Time test method two");
	}
}
