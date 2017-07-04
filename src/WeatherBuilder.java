public class WeatherBuilder {

	private String city;
	private String country;
	private String language;
	private String unit;

	public WeatherBuilder setCity(String city) {
		this.city = city;
		return this;
	}

	public WeatherBuilder setCountry(String country) {
		this.country = country;
		return this;
	}

	public WeatherBuilder setLanguage(String language) {
		this.language = language;
		return this;
	}

	public WeatherBuilder setUnit(String unit) {
		this.unit = unit;
		return this;
	}

	public WeatherByCity build() {
		String cityCountry = (country != null) ? city + "," + country : city;
		return new WeatherByCity(cityCountry, language, unit);
	}
}
