import static org.junit.Assert.*;
import org.junit.*;

public class TripTest {
    // Creating a sample Trip
    Trip testTrip = new Trip(130, 350, 55.3);

    @Test
    public void accessingTripDuration() {
        assertEquals(220, testTrip.getDuration());
    }

    @Test
    public void accessingTripEndTime() {
        assertEquals(350, testTrip.getEndTime());
    }

    @Test
    public void accessingTripMiles() {
        assertTrue(55.3 == testTrip.getMiles());
    }

    @Test
    public void accessingTripMPH() {
        assertTrue(55.3 / ((350 - 130) / 60.0) == testTrip.getMPH());
    }

    @Test
    public void accessingTripStartTime() {
        assertEquals(130, testTrip.getStartTime());
    }

    @Test
    public void convertingTripToString() {
        String message = "Trip Start: 2:10 | Trip End: 5:50 | Miles Driven: 55 | Average MPH: 15";
        assertEquals(message, testTrip.toString());
    }

}