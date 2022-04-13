package weatherRelated;
import aircraftRelated.*;


public class WeatherTower extends Tower
{
    public String getWeather(Coordinates coordinates){return "";}

    public void changeWeather()
    {
        this.conditionsChanged();
    }
}