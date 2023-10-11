import com.google.gson.gson;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonParser;

public class WeatherApp {
  private static final String APIKEY = "";
  private static final String APIURL = "";
  private static final String APIUNITS = "metric";


  public static void main(String[] args) {
    String Location = "";

    try {
      WeatherData weatherData = getWeatherData(Location);
      displayWeather(weatherData);

    } catch (IOException e) {
      e.printStackTrace();
    }
}
private static <Gson> WeatherData getWeatherData(String Location) throws IOException{
  String apiURL = String.format("%s?q=%s&units=%s&appid=%s",APIURL,Location,APIUNITS,APIKEY);

  // URL url = new URL(apiURL);
  // HttpURLConnection connection = (HttpURLConnection)url.openUrlConnection();

  URL url = new URL(apiURL);
HttpURLConnection connection = (HttpURLConnection) url.openConnection();


  if (connection.getResponseCode() == 200) {
    Gson gson = new Gson();
    InputStreamReader reader = new InputStreamReader(connection.getInputStream());
    WeatherData weatherData = gson.fromJson(reader, WeatherData.class);
    reader.close();
    return weatherData;
} else {
    throw new IOException("Unable to fetch weather data.");
}
}

private static void displayWeather(WeatherData weatherData) {
if (weatherData != null) {
    System.out.println("Weather in " + weatherData.getCityName() + ":");
    System.out.println("Temperature: " + weatherData.getTemperature() + "°C");
    System.out.println("Description: " + weatherData.getWeatherDescription());
} else {
    System.out.println("Weather data not available for the specified location.");
}
}
}



