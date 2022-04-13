package weatherRelated;

import aircraftRelated.*;

public class WeatherProvider{
    private WeatherProvider weatherProvider;
    private String[] weather  = {"RAIN", "FOG", "SUN", "SNOW"};;
    WeatherProvider(){}
    public WeatherProvider getProvider() {
        if(weatherProvider != null)
        return weatherProvider;
    else
        weatherProvider = new WeatherProvider();
    
        return this.weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates)
    {
        int ran = (int) (Math.random()* 4);
        return weather[ran];
    }

}