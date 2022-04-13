package AvajPackage;

public class Helicopter extends Aircraft implements Flyable
{
   private WeatherTower weatherTower;

    // Helicopter(String name, Coordinates coordinates){}
    public Helicopter(String name, Coordinates coordinates)
    {
        super(name, coordinates);
        // super(name, coordinates, type);
    }

    @Override
    public void updateConditions(){
        
    }

    @Override
    public void registerTower(WeatherTower weatherTower)
    {
    }
}