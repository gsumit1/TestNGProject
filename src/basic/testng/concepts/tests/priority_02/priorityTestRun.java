package basic.testng.concepts.tests.priority_02;

import org.testng.annotations.Test;

public class priorityTestRun {
	@Test(priority=2)
	 public void b_method(){
	    System.out.println("B Method");
	  }

	@Test(priority=1)
	 public void a_method(){
	    System.out.println("A method");
	 }

}
