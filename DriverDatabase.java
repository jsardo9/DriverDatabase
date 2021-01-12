import java.util.*;

public class DriverDatabase {
    private TreeMap<String, Driver> drivers;

    public DriverDatabase() {
        drivers = new TreeMap<>();
    }

    // Public Methods
    // ----------------------
    public void addTrip(Trip trp) {
    }

    // Overloaded Print Method
    public String toString() {
        String allDrivers = "";
        for (Driver driver : drivers.values()) {
            allDrivers += driver + "\n";
        }
        return allDrivers;
    }
}
