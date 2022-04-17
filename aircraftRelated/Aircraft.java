package aircraftRelated;

import java.util.HashMap;

public class Aircraft {

    protected long id;
    protected String name;
    protected Coordinates coordinates;

    private long idCounter;

    protected Aircraft(String name, Coordinates coordinates) {
        this.id = nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextId() {
        idCounter += 1;
        return idCounter;
    }

    public void updateCoordinates(String weather, HashMap<String, String> params) {
        int new_Longtitude;
        int new_Latitude;
        int new_Height;

        new_Longtitude = Integer.parseInt(params.get(weather).split("|")[1].split(" ")[0]);
        new_Latitude = Integer.parseInt(params.get(weather).split("|")[1].split(" ")[1]);
        new_Height = Integer.parseInt(params.get(weather).split("|")[1].split(" ")[2]);

        new_Height = (coordinates.getHeight() + new_Height > 100) ? 100 : this.coordinates.getHeight() + new_Height;

        coordinates = new Coordinates(
                coordinates.getLongitude() + new_Longtitude,
                coordinates.getLatitude() + new_Latitude,
                new_Height);
        /*
         * switch (weather) {
         * case "SUN":
         * coordinates = new Coordinates(
         * coordinates.getLongitude() +
         * Integer.parseInt(params.get("SUN").split("|")[1].split(" ")[0]),
         * coordinates.getLatitude() +
         * Integer.parseInt(params.get("SUN").split("|")[1].split(" ")[1]),
         * coordinates.getHeight() +
         * Integer.parseInt(params.get("SUN").split("|")[1].split(" ")[2]));
         * break;
         * case "RAIN":
         * coordinates = new Coordinates(
         * coordinates.getLongitude() +
         * Integer.parseInt(params.get("RAIN").split("|")[1].split(" ")[0]),
         * coordinates.getLatitude() +
         * Integer.parseInt(params.get("RAIN").split("|")[1].split(" ")[1]),
         * coordinates.getHeight() +
         * Integer.parseInt(params.get("RAIN").split("|")[1].split(" ")[2]));
         * break;
         * case "FOG":
         * coordinates = new Coordinates(
         * coordinates.getLongitude() +
         * Integer.parseInt(params.get("FOG").split("|")[1].split(" ")[0]),
         * coordinates.getLatitude() +
         * Integer.parseInt(params.get("FOG").split("|")[1].split(" ")[1]),
         * coordinates.getHeight() +
         * Integer.parseInt(params.get("FOG").split("|")[1].split(" ")[2]));
         * break;
         * case "SNOW":
         * coordinates = new Coordinates(
         * coordinates.getLongitude() +
         * Integer.parseInt(params.get("SNOW").split("|")[1].split(" ")[0]),
         * coordinates.getLatitude() +
         * Integer.parseInt(params.get("SNOW").split("|")[1].split(" ")[1]),
         * coordinates.getHeight() +
         * Integer.parseInt(params.get("SNOW").split("|")[1].split(" ")[2]));
         * break;
         * }
         */
    }
}