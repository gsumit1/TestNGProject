package Parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
	@Parameters({"name1"})
	@Test
	public void TestCaseParameter(String name) {
		
		System.out.println(name);
		
	}
	

}