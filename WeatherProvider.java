public class WeatherProvider{
    private WeatherProvider weatherProvider;
    private String[] weather;
    WeatherProvider(){}
    public WeatherProvider getProvider() {
        return this.weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){return "null";}

}