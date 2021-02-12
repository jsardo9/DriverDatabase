import static org.junit.Assert.*;
import org.junit.*;

public class DriverDatabaseTest {
    // Creating a sample Database and Drivers
    DriverDatabase testDB = new DriverDatabase();
    Driver Dave = new Driver("Dave");
    Driver Alex = new Driver("Alex");
    Driver James = new Driver("James");

    @Before // Adding Drivers To DB Before Running Tests
    public void setUpDatabase() {
        Dave.addTrip(new Trip(730, 760, 5.4));
        Dave.addTrip(new Trip(1120, 1155, 9.5));
        Dave.addTrip(new Trip(1301, 1355, 16.2));
        Alex.addTrip(new Trip(11, 95, 30.3));
        Alex.addTrip(new Trip(1200, 1342, 70.5));
        James.addTrip(new Trip(130, 350, 56.6));
        James.addTrip(new Trip(444, 560, 30.5));
        James.addTrip(new Trip(700, 720, 15.2));

        testDB.addDriver(Dave);
        testDB.addDriver(Alex);
        testDB.addDriver(James);
    }

    @Test // Testing that Trips were added correctly during @Before
    public void testAddingDrivers() {
        assertEquals(3, testDB.numDrivers());
    }

    @Test
    public void testAccessingDrivers() {
        assertSame(James, testDB.getDriver("James"));
    }

    @Test
    public void testRemovingDriver() {
        assertSame(Alex, testDB.getDriver("Alex"));
    }

    @Test
    public void testConvertingDatabaseToString() {
        String message = "Alex: 100 miles @ 26 mph\n\n";
        message += "Dave: 31 miles @ 15 mph\n\n";
        message += "James: 102 miles @ 17 mph\n\n";
        assertEquals(message, testDB.toString());
    }
}
