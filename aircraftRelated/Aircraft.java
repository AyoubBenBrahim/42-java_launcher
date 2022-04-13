package aircraftRelated;

import weatherRelated.*;

public class Aircraft {

    protected long id;
    protected String name;
    protected Coordinates coordinates;

    private long idCounter;

    protected Aircraft(String name, Coordinates coordinates)
    {
        this.id = nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextId()
    {
        idCounter += 1;
        return  idCounter;
    }
}