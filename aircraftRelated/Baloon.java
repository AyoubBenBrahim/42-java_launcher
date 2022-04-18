package aircraftRelated;

import java.io.*;
import java.util.*;
import myExceptions.MyCustomException;
import weatherRelated.*;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    HashMap<String, String> logMessage = new HashMap<String, String>();
    public FileWriter myWriter;
    
    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
        System.out.println("\t**** Balooooooooooon Constr ****");
        
        logMessage.put("SUN", "Let's enjoy the good weather and take some pics. | 2 0 4");
        logMessage.put("RAIN", "Damn you rain! You messed up my baloon. | 0 0 -5");
        logMessage.put("FOG", "Fog, can't see. | 0 0 -3");
        logMessage.put("SNOW", "It's snowing. We're gonna crash. | 0 0 -15");
    }
    
    @Override
    public void updateConditions() {
        
        try {
            String weather = weatherTower.getWeather(coordinates);
            File myObj = new File("simulation.txt");
            // if (!myObj.createNewFile())
            //     throw new MyCustomException("the named file already exists simulation.txt");
            // myWriter = new FileWriter("simulation.txt");
            myWriter = new FileWriter(myObj, true);

            if (logMessage.get(weather) != null) {
                updateCoordinates(weather, logMessage);
                myWriter.write("Baloon#" + this.name + "(" + this.id + "): " + logMessage.get(weather).split("|")[0]
                        + ".\n");

                if (coordinates.getHeight() <= 0) {
                    weatherTower.unregister(this);
                    myWriter.write(
                            "Tower says: Baloon#" + this.name + "(" + this.id + ")"
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
            myWriter.write("Tower says: Baloon#" + name + "(" + id + ")" + " registered to weather tower.\n");
            myWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}