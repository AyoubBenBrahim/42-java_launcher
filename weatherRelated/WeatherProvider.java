package weatherRelated;

import java.util.Random;
import aircraftRelated.*;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();;
    private static final String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };;

    WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
     
        //     weatherProvider = new WeatherProvider();

        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return weather[new Random().nextInt(4)];
    }

}