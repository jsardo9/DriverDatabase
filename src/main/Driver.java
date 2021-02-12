import java.util.*;

public class Driver {
    private String name;
    private List<Car> cars;
    private ArrayList<Trip> trips;
    private double milesDriven;
    private int timeDriven; // timeDriven in minutes

    public Driver(String name) {
        this.name = name;
        trips = new ArrayList<>();
        milesDriven = 0;
        timeDriven = 0;
        cars = new ArrayList<Car>();
    }

    // Public Methods
    public void addCar(String make, String model) {
        // System.out.println("car added");
        cars.add(new Car(make, model));
    }

    public void addTrip(Trip trp) {
        milesDriven += trp.getMiles();
        timeDriven += trp.getDuration();
        trips.add(trp);
    }

    public List<Car> getCars() {
        return cars;
    }

    public double getMiles() {
        return milesDriven * 10;
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

    public int compareTo(Driver other) {
        return name.compareTo(other.name);
    }

    // Overloaded Methods
    public String toString() {
        String driver = name + ": " + (int) milesDriven + " miles";
        if (milesDriven > 0) {
            driver += " @ " + (int) getMPH() + " mph";
        }
        driver += "\n";
        for (Car car : cars) {
            driver += car;
        }
        return driver;
    }
}
