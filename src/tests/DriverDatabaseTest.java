import static org.junit.Assert.*;
import org.junit.*;

public class DriverDatabaseTest {
    // Creating a sample Database
    DriverDatabase testDB = new DriverDatabase();

    @Before // Adding Drivers To DB Before Running Tests
    public void CreateSampleDatabase() {
        Driver Dave = new Driver("Dave");
        Dave.addTrip(new Trip(730, 760, 5.4));
        Dave.addTrip(new Trip(1120, 1155, 9.5));
        Dave.addTrip(new Trip(1301, 1355, 16.2));

        Driver Alex = new Driver("Alex");
        Alex.addTrip(new Trip(11, 95, 30.3));
        Alex.addTrip(new Trip(1200, 1342, 70.5));

        Driver James = new Driver("James");
        James.addTrip(new Trip(130, 350, 56.6));
        James.addTrip(new Trip(444, 560, 30.5));
        James.addTrip(new Trip(700, 720, 15.2));

        testDB.addDriver(Dave);
        testDB.addDriver(Alex);
        testDB.addDriver(James);
    }

    @Test // Testing that Trips were added correctly during @Before
    public void addingDrivers() {
        assertEquals(3, testDB.numDrivers());
    }
}
