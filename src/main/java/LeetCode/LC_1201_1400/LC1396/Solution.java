package LeetCode.LC_1201_1400.LC1396;

import java.util.Map;
import java.util.HashMap;

/**
 * Solution: 2 HashMap, optimal solution.
 */
public class Solution {
    class UndergroundSystem {
        Map<Integer, StartStationTime> checkin;
        Map<String, TravelTimeNumOfTravel> checkout;
        public UndergroundSystem() {
            checkin = new HashMap();
            checkout = new HashMap();
        }

        public void checkIn(int id, String stationName, int t) {
            checkin.put(id, new StartStationTime(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            String startStation = checkin.get(id).startStation; // current id checkin station.
            int startTime = checkin.get(id).time; // current id checkin time.
            String route = startStation + "->" + stationName; // current id travel route.
            int travelTime = t - startTime; // current travel time from start station to end station.

            if(!checkout.containsKey(route)) {
                checkout.put(route, new TravelTimeNumOfTravel(travelTime, 1));
            } else {
                checkout.get(route).travelTime += travelTime;
                checkout.get(route).numOfTravel++;
            }
        }

        public double getAverageTime(String startStation, String endStation) {
            String route = startStation + "->" + endStation;
            return (double)checkout.get(route).travelTime / checkout.get(route).numOfTravel;
        }
    }

    class StartStationTime {
        public String startStation;
        public int time;
        public StartStationTime(String startStation, int time) {
            this.startStation = startStation;
            this.time = time;
        }
    }

    class TravelTimeNumOfTravel {
        public int travelTime;
        public int numOfTravel;
        public TravelTimeNumOfTravel(int travelTime, int numOfTravel) {
            this.travelTime = travelTime;
            this.numOfTravel = numOfTravel;
        }
    }
}
