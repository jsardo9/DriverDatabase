import java.util.*;

public class DriverDatabase {
    private TreeMap<String, Driver> drivers;

    public DriverDatabase() {
        drivers = new TreeMap<>();
    }

    // Public Methods
    public void addDriver(Driver driver) {
        drivers.put(driver.getName(), driver);
    }

    public Driver removeDriver(String name) {
        return drivers.remove(name);
    }

    public Driver getDriver(String name) {
        return drivers.get(name);
    }

    public void printByMileage() {
        ArrayList<Driver> allDrivers = new ArrayList<>(drivers.values());
        Collections.sort(allDrivers, (d1, d2) -> (int) (d2.getMiles() - d1.getMiles()));
        for (Driver driver : allDrivers) {
            System.out.println(driver);
        }
    }

    // Overloaded Methods
    public String toString() {
        String driverString = "";
        for (Driver driver : drivers.values()) {
            driverString += driver + "\n";
        }
        return driverString;
    }
}
