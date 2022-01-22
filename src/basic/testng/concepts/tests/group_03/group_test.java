package basic.testng.concepts.tests.group_03;

import org.testng.annotations.Test;

public class group_test {
	 @Test
	    public void starting_point(){
	    	System.out.println("This is the starting point of the test");
	 }
	 
	 @Test(groups = { "demo" })	
	    public void checkTitle() {	
		 System.out.println("Free QA Automation Tools For Everyone");
	 }
	 
	  @Test(groups = { "demo" })	
	    public void click_element() {	
		  System.out.println("Free QA Automation Tools For Everyone2");
	  }
}
