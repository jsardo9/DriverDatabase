import static org.junit.Assert.*;
import org.junit.*;

public class DriverTest {
    // Creating Sample Driver
    Driver testDriver = new Driver("Dave");

    @Before // Adding Sample Trips Before Executing Tests
    public void CreateSampleDriver() {
        testDriver.addTrip(new Trip(130, 350, 56.6));
        testDriver.addTrip(new Trip(444, 560, 30.5));
        testDriver.addTrip(new Trip(700, 720, 15.2));
    }

    @Test // Testing that Trips were added correctly during @Before
    public void addingTrips() {
        assertEquals(3, testDriver.numTrips());
    }

    @Test
    public void accessingTotalDriverMiles() {
        assertTrue(102.3 == testDriver.getMiles());
    }

    @Test
    public void accessingAverageDriverMPH() {
        assertTrue(102.3 / (356 / 60.0) == testDriver.getMPH());
    }

    @Test
    public void accessingDriverName() {
        assertEquals("Dave", testDriver.getName());
    }

    @Test
    public void accessingDriversTrips() {
        assertEquals(3, testDriver.getTrips().size());
    }

    @Test
    public void convertingDriverToString() {
        String message = "Dave: 102 miles @ 17 mph";
        assertEquals(message, testDriver.toString());
    }

}