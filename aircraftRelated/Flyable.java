
package aircraftRelated;

import weatherRelated.*;

import weatherRelated.*;

public interface Flyable {
    public void updateConditions();
    public void updateCoordinates(String weatherTower);
    public void registerTower(WeatherTower weatherTower);
  }