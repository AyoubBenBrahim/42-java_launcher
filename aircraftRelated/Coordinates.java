
package aircraftRelated;

public class Coordinates {

    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height)
    {
        this.height = height;
        if (this.height < 0)
            this.height = 0;
        else if (this.height > 100)
            this.height = 100;

        this.latitude = longitude;
        if(longitude < 0)
            this.latitude = 0;

        this.longitude = latitude;
        if(latitude < 0)
            this.longitude = 0;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int getHeight() {
        return this.height;
    }

}