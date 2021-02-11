import java.util.*;

public class Driver {
    private String name;
    private ArrayList<Trip> trips;
    private double milesDriven;
    private int timeDriven; // timeDriven in minutes

    public Driver(String name) {
        this.name = name;
        trips = new ArrayList<>();
        milesDriven = 0;
        timeDriven = 0;
    }

    // Public Methods
    public void addTrip(Trip trp) {
        milesDriven += trp.getMiles();
        timeDriven += trp.getDuration();
        trips.add(trp);
    }

    public double getMiles() {
        return milesDriven;
    }

    public double getMPH() {
        return milesDriven / (timeDriven / 60.0);
    }

    public String getName() {
        return name;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public int getTimeDriven() {
        return timeDriven;
    }

    public int numTrips() {
        return trips.size();
    }

    public boolean removeTrip(int startTime) {
        for (int i = 0; i < trips.size(); i++) {
            Trip trp = trips.get(i);
            if (trp.getStartTime() == startTime) {
                milesDriven -= trp.getMiles();
                timeDriven -= trp.getDuration();
                return trips.remove(trp);
            }
        }
        return false;
    }

    // Overloaded Methods
    public String toString() {
        String driver = name + ": " + (int) milesDriven + " miles";
        if (milesDriven > 0) {
            driver += " @ " + (int) getMPH() + " mph";
        }
        return driver;
    }
}
