package aircraftRelated;

import weatherRelated.*;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import myExceptions.MyCustomException;

public class Aircraft {

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates) {
        this.id = nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextId() {
        idCounter++;
        return idCounter;
    }

    public void updateCoordinates(String weather, HashMap<String, String> params) {
        int new_Longtitude;
        int new_Latitude;
        int new_Height;

        String parsCoords = params.get(weather).substring(params.get(weather).lastIndexOf('|') + 1);
        String[] arrOfStr = parsCoords.split(" ");

        new_Longtitude = Integer.parseInt(arrOfStr[1]);
        new_Latitude = Integer.parseInt(arrOfStr[2]);
        new_Height = Integer.parseInt(arrOfStr[3]);

        new_Height = (coordinates.getHeight() + new_Height > 100) ? 100 : this.coordinates.getHeight() + new_Height;

        coordinates = new Coordinates(
                coordinates.getLongitude() + new_Longtitude,
                coordinates.getLatitude() + new_Latitude,
                new_Height);
    }

    public void outputHandler(Aircraft airCraft) {

        String weather;
        String type;
        HashMap<String, String> logMessage;
        String name;
        Coordinates coords;
        long id;
        WeatherTower weatherTower;
        try {
            if (airCraft instanceof Helicopter) {
                coords = ((Helicopter) airCraft).coordinates;
                weather = ((Helicopter) airCraft).weatherTower.getWeather(coords);
                logMessage = ((Helicopter) airCraft).logMessage;
                name = ((Helicopter) airCraft).name;
                id = ((Helicopter) airCraft).id;
                type = "Helicopter";
                weatherTower = ((Helicopter) airCraft).weatherTower;
            } else if (airCraft instanceof Baloon) {
                coords = ((Baloon) airCraft).coordinates;
                weather = ((Baloon) airCraft).weatherTower.getWeather(coords);
                logMessage = ((Baloon) airCraft).logMessage;
                name = ((Baloon) airCraft).name;
                type = "Baloon";
                id = ((Baloon) airCraft).id;
                weatherTower = ((Baloon) airCraft).weatherTower;

            } else {
                coords = ((JetPlane) airCraft).coordinates;
                weather = ((JetPlane) airCraft).weatherTower.getWeather(coords);
                logMessage = ((JetPlane) airCraft).logMessage;
                name = ((JetPlane) airCraft).name;
                type = "JetPlane";
                id = ((JetPlane) airCraft).id;
                weatherTower = ((JetPlane) airCraft).weatherTower;
            }

            File myObj = new File("simulation.txt");
            FileWriter myWriter = new FileWriter(myObj, true);

            if (logMessage.get(weather) != null) {
                updateCoordinates(weather, logMessage);
                String strOut = logMessage.get(weather).substring(0, logMessage.get(weather).indexOf("|"));

                myWriter.write(type + "#" + name + "(" + id + "): " + strOut + "\n");

                if (coords.getHeight() <= 0) {
                    weatherTower.unregister((Flyable) airCraft);
                    myWriter.write(
                            "Tower says: " + type + "#" + name + "(" + id + ")"
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

}
