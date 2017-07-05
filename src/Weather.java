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
				//Fall-through
			case 3:
				builder.setLanguage(args[2]);
				//Fall-through
			case 2:
				builder.setCountry(args[1]);
				//Fall-through
			case 1:
				builder.setCity(args[0]);
				//Fall-through		
			case 0: 
				break;
			default:

				System.out.println("USAGE: Weather [city] [country] [language] [unit]");
				System.exit(1);
		}
		return builder.build();
	}
}

