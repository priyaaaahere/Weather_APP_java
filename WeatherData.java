public class WeatherData {
    private String cityName;
    private double temperature;
    private String weatherDescription;

    // Constructor
    public WeatherData(String cityName, double temperature, String weatherDescription) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.weatherDescription = weatherDescription;
    }

    // Getter methods
    public String getCityName() {
        return cityName;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }
}
