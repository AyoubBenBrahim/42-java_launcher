
package aircraftRelated;

import java.util.HashMap;

import weatherRelated.*;

import weatherRelated.*;

public interface Flyable {
    public void updateConditions();
    // public void updateCoordinates(String weatherTower, HashMap<String, String> params);
    public void registerTower(WeatherTower weatherTower);
  }