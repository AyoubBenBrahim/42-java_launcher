package aircraftRelated;

import java.io.*;
import java.util.*;
import weatherRelated.*;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    HashMap<String, String> logMessage = new HashMap<String, String>();
    public FileWriter myWriter;
    
    WeatherTower getWeatherTower() {
        return weatherTower;
    }
    
    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
        
        logMessage.put("SUN", "OMG! Winter is coming! | 0 10 2");
        logMessage.put("RAIN", "It's raining. Better watch out for lightings. | 0 5 0");
        logMessage.put("FOG", "Fog, can't see. | 0 1 0");
        logMessage.put("SNOW", "It's snowing. We're gonna crash. | 0 0 -7");
    }
    
    @Override
    public void updateConditions() {
        outputHandler(this);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        try {

            this.weatherTower = weatherTower;
            this.weatherTower.register(this);

            // myWriter = new FileWriter("simulation.txt");
            File myObj = new File("simulation.txt");
            myWriter = new FileWriter(myObj, true);
            myWriter.write("Tower says: JetPlane#" + name + "(" + id + ")" + " registered to weather tower.\n");
            myWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}