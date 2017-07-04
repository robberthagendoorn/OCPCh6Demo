import java.io.*;

public class Weather {

	public static void main(String... args) throws IOException {
		WeatherByCity request = weatherByCityRequest(args);
		request.getWeather();
	}		

	private static WeatherByCity weatherByCityRequest(String... args) {
		WeatherBuilder builder = new WeatherBuilder();
		switch(args.length) {
			case 4:
				builder.setUnit(args[3]);
			case 3:
				builder.setLanguage(args[2]);
			case 2:
				builder.setCountry(args[1]);
			case 1:
				builder.setCity(args[0]);
			default:
		}
		return builder.build();
	}
}

