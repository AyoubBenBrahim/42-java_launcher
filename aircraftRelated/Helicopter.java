package aircraftRelated;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import myExceptions.*;
import weatherRelated.*;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    HashMap<String, String> logMessage = new HashMap<String, String>();
    public FileWriter myWriter;
    
    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
        
        logMessage.put("SUN", "This is hot. | 10 0 2");
        logMessage.put("RAIN", "Rain time | 5 0 0");
        logMessage.put("FOG", "Fog, can't see. | 1 0 0");
        logMessage.put("SNOW", "My rotor is going to freeze! | 0 0 -12");
    }
    
    @Override
    public void updateConditions() {
        
        try {
            String weather = weatherTower.getWeather(coordinates);

            File myObj = new File("simulation.txt");
            // if (myObj.createNewFile() == false)
            //     throw new MyCustomException("the named file already exists simulation.txt");
            // myWriter = new FileWriter("simulation.txt");
            myWriter = new FileWriter(myObj, true);

            if (logMessage.get(weather) != null) {
                // int arr[] = {};
                // updateCoordinates(weather, arr);
                // HashMap<String, String> params = new HashMap<String, String>();
                // params.put("SUN", "10 0 2");
                // params.put("RAIN", "5 0 0");
                // params.put("FOG", "1 0 0");
                // params.put("SNOW", "0 0 -12 ");

                updateCoordinates(weather, logMessage);

                myWriter.write("Helicopter#" + this.name + "(" + this.id + "): " + logMessage.get(weather).split("|")[0]
                        + ".\n");

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
        try {

            this.weatherTower = weatherTower;
            this.weatherTower.register(this);

            myWriter = new FileWriter("simulation.txt");
            myWriter.write("Tower says: Helicopter#" + name + "(" + id + ")" + " registered to weather tower.\n");
            myWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}