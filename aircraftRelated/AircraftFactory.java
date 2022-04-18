package aircraftRelated;

import myExceptions.*;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        try {
            if (longitude <= 0 || latitude <= 0 || height <= 0) {
                throw new MyCustomException("Coordinates Must Be Positive");
            }
            Coordinates coord = new Coordinates(longitude, latitude, height);
            
            if (type.equalsIgnoreCase("Baloon")) {
                
                return new Baloon(name, coord);
            } else if (type.equalsIgnoreCase("Helicopter")) {
                return new Helicopter(name, coord);
            } else if (type.equalsIgnoreCase("JetPlane")) {
                return new JetPlane(name, coord);
            } else {
                throw new MyCustomException("Aicraft type \"" + type + "\" is invalid");
            }
        } catch (MyCustomException e) {
            e.printStackTrace();
        }
        return null;
    }
}