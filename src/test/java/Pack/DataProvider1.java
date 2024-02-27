package Pack;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {
	@Test(dataProvider = "driveTest")
	public void testCase(String greeting,String communication,String id) {
		System.out.println(greeting+communication+id);

	}

	@DataProvider(name = "driveTest")
	public Object[][] getData() {
		Object[][] data = { { "hello", "text", "1" }, { "bye", "message", "143" }, { "solo", "call", "453" } };
		return data;

	}
}
