import java.io.IOException;
import java.util.Scanner;
public class WeatherApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter city name: ");
        String city = scanner.nextLine();

        WeatherApiClient weatherApiClient = new WeatherApiClient();

        try {
            WeatherData weatherData = weatherApiClient.getWeatherData(city);
            displayWeatherInfo(weatherData);
        } catch (IOException e) {
            System.err.println("Error fetching weather data: " + e.getMessage());
        }
    }

    private static void displayWeatherInfo(WeatherData weatherData) {
        System.out.println("\nWeather Information:");
        System.out.println("Temperature: " + weatherData.getTemperature() + "°C");
        System.out.println("Description: " + weatherData.getDescription());
    }
}
