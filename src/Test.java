import java.io.*;

public class Test {

	public static void main(String... args) {
		testAPI();
		testBuilder();
		testDisplay();
		System.out.println("All test succesfully passed");
	}

	private static void testAPI() {
		try {
			HttpUrlConnectionReader connection = new HttpUrlConnectionReader();			
			connection.connect("http://www.google.com");
		} catch (IOException e) {
			assert false: "API test failed";
		}
	}

	private static void testBuilder() {
		WeatherBuilder wb = new WeatherBuilder();
		wb.setCity("Rijswijk")
		  .setCountry("nl")
		  .setLanguage("nl")
		  .setUnit("metric");
		WeatherByCity weatherByCity = wb.build();
		WeatherByCity testWBC = new WeatherByCity("Rijswijk,nl", "nl", "metric");
		assert weatherByCity.getURL().equals(testWBC.getURL()): "Builder test failed"; 			
	}

	private static void testDisplay() {
		String HTML = "<html><header><title>This is title</title></header><body>Hello world</body></html>"; 
		try {
			WeatherByCity.displayWeather(HTML);
		} catch (IOException e) {
			assert false: "HTML parsing failed";
		}
	}
}
		
