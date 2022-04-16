package aircraftRelated;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import myExceptions.*;
import weatherRelated.*;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    String weather = weatherTower.getWeather(coordinates);
    HashMap<String, String> logMessage = new HashMap<String, String>();
    public FileWriter myWriter;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);

        logMessage.put("SUN", "This is hot.");
        logMessage.put("RAIN", "Rain time");
        logMessage.put("FOG", "Fog, can't see.");
        logMessage.put("SNOW", "My rotor is going to freeze!");
    }

    @Override
    public void updateConditions() {

        try {
            File myObj = new File("simulation.txt");
            if (!myObj.createNewFile())
                throw new MyCustomException("Failed to create File simulation.txt");
            myWriter = new FileWriter("simulation.txt");

            if (logMessage.get(weather) != null) {
                updateCoordinates(weather);
                myWriter.write("Helicopter#" + this.name + "(" + this.id + "): " + logMessage.get(weather) + ".\n");

                if (coordinates.getHeight() <= 0) {
                    weatherTower.unregister(this);
                    myWriter.write(
                            "Tower says: Helicopter#" + this.name + "(" + this.id + ")"
                                    + " unregistered from weather tower.\n");
                    myWriter.close();
                }
                myWriter.close();
            } else {
                myWriter.close();
                throw new MyCustomException("Uknown Weather!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
    }

    @Override
    public void updateCoordinates(String weatherTower) {
        switch (weather) {
            case "SUN":
                coordinates = new Coordinates(
                        coordinates.getLongitude() + 10,
                        coordinates.getLatitude(),
                        coordinates.getHeight() + 2);
                break;
            case "RAIN":
                coordinates = new Coordinates(
                        coordinates.getLongitude() + 5,
                        coordinates.getLatitude(),
                        coordinates.getHeight());
                break;
            case "FOG":
                coordinates = new Coordinates(
                        coordinates.getLongitude() + 1,
                        coordinates.getLatitude(),
                        coordinates.getHeight());
                break;
            case "SNOW":
                coordinates = new Coordinates(
                        coordinates.getLongitude(),
                        coordinates.getLatitude(),
                        coordinates.getHeight() - 12);
                break;
        }
    }
}