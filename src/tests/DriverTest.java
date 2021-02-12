import static org.junit.Assert.*;
import org.junit.*;

public class DriverTest {
    // Creating Sample Driver
    static final String NAME = "Dave";
    static final int TRIPS = 3;
    static final double TOTAL_MILES = 102.3;
    static final int TIME_DRIVEN = 356;
    static final double MPH = TOTAL_MILES / (TIME_DRIVEN / 60.0);
    Driver testDriver = new Driver(NAME);

    @Before // Adding Sample Trips To Match Constants Before Executing Tests
    public void setUpDriver() {
        testDriver.addTrip(new Trip(130, 350, 56.6));
        testDriver.addTrip(new Trip(444, 560, 30.5));
        testDriver.addTrip(new Trip(700, 720, 15.2));
    }

    @Test // Testing that Trips were added correctly during @Before
    public void testAddingTrips() {
        assertEquals(TRIPS, testDriver.numTrips());
    }

    @Test
    public void testAccessingTotalDriverMiles() {
        assertTrue(TOTAL_MILES == testDriver.getMiles());
    }

    @Test
    public void testAccessingAverageDriverMPH() {
        assertTrue(MPH == testDriver.getMPH());
    }

    @Test
    public void testAccessingDriverName() {
        assertEquals(NAME, testDriver.getName());
    }

    @Test
    public void testConvertingDriverToString() {
        String message = NAME + ": " + (int) (TOTAL_MILES) + " miles @ " + (int) (MPH) + " mph\n";
        assertEquals(message, testDriver.toString());
    }

    @Test
    public void testRemovingTrip() {
        // Removing existing trip should be true
        assertTrue(testDriver.removeTrip(130));
        testDriver.addTrip(new Trip(130, 350, 56.6));

        // Removing non-existant trip should be false
        assertFalse(testDriver.removeTrip(1000000));
    }

}