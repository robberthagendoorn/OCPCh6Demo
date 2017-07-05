import java.io.*;
import java.awt.Desktop;

public class WeatherByCity {
	
	private String URL;
	private static final String API_KEY = "f9a2266dcb5a5577dcb3efa7dde67a5a"; 

	WeatherByCity(String cityCountry, String language, String unitType) {
		String query = "http://api.openweathermap.org/data/2.5/weather?q=" + cityCountry;
		String lang = "&lang=" + language;	
		String key = "&appid=" + API_KEY;
		String unit = "&units=" + unitType;
		String mode = "&mode=" + "html";
		URL = query + lang + unit + mode + key;
	}	

	public String getURL() {
		return URL;
	}

	public void getWeather() throws IOException {
		HttpUrlConnectionReader connection = new HttpUrlConnectionReader();
		try {
			String output = connection.connect(URL);
			displayWeather(output);
		} catch (IOException e) {
			System.out.print(e.getMessage());
			throw e;
		}
	}

	public static void displayWeather(String output) throws IOException {
		File file = new File("weather.html");
		try (FileWriter writer = new FileWriter(file)) {
			writer.write(output);
		} catch (IOException e) {
			throw e;
		}	
	}
}

