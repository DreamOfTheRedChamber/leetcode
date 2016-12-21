package systemDesign.locationBasedService;

import java.util.HashMap;
import java.util.Map;

/*
Support two basic uber features:

Drivers report their locations.
Rider request a uber, return a matched driver.
When rider request a uber, match a closest available driver with him, then mark the driver not available.

When next time this matched driver report his location, return with the rider's information.

You can implement it with the following instructions:

report(driver_id, lat, lng)
1) return null if no matched rider.
2) return matched trip information.

request(rider_id, lat, lng)
1) create a trip with rider's information.
2) find a closest driver, mark this driver not available.
3) fill driver_id into this trip.
4) return trip

This is the definition of Trip in Java:

public class Trip {
    public int id; // trip's id, primary key
    public int driver_id, rider_id; // foreign key
    public double lat, lng; // pick up location
}
Have you met this question in a real interview? Yes
Example
report(1, 36.1344, 77.5672) // return null
report(2, 45.1344, 76.5672) // return null
request(2, 39.1344, 76.5672) // return a trip, LOG(INFO): Trip(rider_id: 2, driver_id: 1, lat: 39.1344, lng: 76.5672)
report(1, 38.1344, 75.5672) // return a trip, LOG(INFO): Trip(rider_id: 2, driver_id: 1, lat: 39.1344, lng: 76.5672)
report(2, 45.1344, 76.5672) // return null
 * */

class Location {
    public double lat, lng;
    public Location(double _lat, double _lng) {
        lat = _lat;
        lng = _lng;
    }
}

public class MiniUber {

    Map<Integer, Trip> driver2Trip = null;
    Map<Integer, Location> driver2Location = null;

    public MiniUber() {
        // initialize your data structure here.
        driver2Trip = new HashMap<Integer, Trip>();
        driver2Location = new HashMap<Integer, Location>();
    }

    // @param driver_id an integer
    // @param lat, lng driver's location
    // return matched trip information if there have matched rider or null
    public Trip report(int driver_id, double lat, double lng) {
        // Write your code here
        if (driver2Trip.containsKey(driver_id))
            return driver2Trip.get(driver_id);

        if (driver2Location.containsKey(driver_id)) {
            driver2Location.get(driver_id).lat = lat;
            driver2Location.get(driver_id).lng = lng;
        } else {
            driver2Location.put(driver_id, new Location(lat, lng));
        }
        return null;
    }

    // @param rider_id an integer
    // @param lat, lng driver's location
    // return a trip
    public Trip request(int rider_id, double lat, double lng) {
        // Write your code here
        Trip trip = new Trip(rider_id, lat, lng);
        double distance = -1;
        int driver_id = -1;
        for (Map.Entry<Integer, Location> entry : driver2Location.entrySet()) {
            Location location = entry.getValue();
            double dis = Helper.get_distance(location.lat, location.lng, lat, lng);
            if (distance < 0 || distance > dis) {
                driver_id = entry.getKey();
                distance = dis;
            }
        }

        if (driver_id != -1)
            driver2Location.remove(driver_id);
        trip.driver_id = driver_id;
        driver2Trip.put(driver_id, trip);
        return trip;
    }
}
