import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
public class WeatherApiClient {
    private static final String API_KEY = "config.properties";
    private static final String API_URL = "api.openweathermap.org/data/2.5/forecast/daily?q=London&units=metric&cnt=7&appid={API key}";

    public WeatherData getWeatherData(String city) throws IOException {
        String apiUrl = String.format("%s?q=%s&appid=%s", API_URL, city, API_KEY);

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            Gson gson = new Gson();
            return gson.fromJson(response.toString(), WeatherData.class);
        } finally {
            connection.disconnect();
        }
    }
}
