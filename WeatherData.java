public class WeatherData {
    private Main main;
    private Weather[] weather;

    public double getTemperature() {
        return main.temp;
    }

    public String getDescription() {
        return weather[0].description;
    }

    private static class Main {
        private double temp;
    }

    private static class Weather {
        private String description;
    }
}
