package aircraftRelated;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import myExceptions.*;
import weatherRelated.*;

public class Helicopter extends Aircraft implements Flyable {
    public WeatherTower weatherTower;
    HashMap<String, String> logMessage = new HashMap<String, String>();
    public FileWriter myWriter;
    File myObj;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);

        logMessage.put("SUN", "This is hot. | 10 0 2");
        logMessage.put("RAIN", "Rain time. | 5 0 0");
        logMessage.put("FOG", "Fog, can't see. | 1 0 0");
        logMessage.put("SNOW", "My rotor is going to freeze! | 0 0 -12");
    }

    @Override
    public void updateConditions() {

        // String weather = weatherTower.getWeather(coordinates);
        // try {
            

        //     myObj = new File("simulation.txt");
           
        //     myWriter = new FileWriter(myObj, true);

        //     if (logMessage.get(weather) != null) {

        //         updateCoordinates(weather, logMessage);
        //         String strOut = logMessage.get(weather).substring(0, logMessage.get(weather).indexOf("|"));

        //         myWriter.write("Helicopter#" + this.name + "(" + this.id + "): " + strOut + "\n");

        //         if (coordinates.getHeight() <= 0) {
        //             weatherTower.unregister(this);
        //             myWriter.write(
        //                     "Tower says: Helicopter#" + this.name + "(" + this.id + ")"
        //                             + " unregistered from weather tower.\n");
        //             myWriter.close();
        //         }
        //         myWriter.close();
        //     } else {
        //         myWriter.close();
        //         throw new MyCustomException("Uknown Weather!");
        //     }
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        outputHandler(this);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        try {

            this.weatherTower = weatherTower;
            this.weatherTower.register(this);

            myObj = new File("simulation.txt");
            myWriter = new FileWriter(myObj, true);
            myWriter.write("Tower says: Helicopter#" + name + "(" + id + ")" + " registered to weather tower.\n");
            myWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}