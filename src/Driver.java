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

    public int numTrips() {
        return trips.size();
    }

    // Overloaded Methods
    public String toString() {
        return name + ": " + (int) milesDriven + " miles @ " + (int) getMPH() + " mph";
    }
}
