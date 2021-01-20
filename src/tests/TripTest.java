import static org.junit.Assert.*;
import org.junit.*;

public class TripTest {
    // Creating a sample Trip and ITS information
    static final int START = 130;
    static final int END = 350;
    static final double MILES = 55.3;
    static final double MPH = MILES / ((END - START) / 60.0);
    Trip testTrip = new Trip(START, END, MILES);

    @Test
    public void testAccessingTripDuration() {
        assertEquals(END - START, testTrip.getDuration());
    }

    @Test
    public void testAccessingTripEndTime() {
        assertEquals(END, testTrip.getEndTime());
    }

    @Test
    public void testAccessingTripMiles() {
        assertTrue(MILES == testTrip.getMiles());
    }

    @Test
    public void testAccessingTripMPH() {
        assertTrue(MPH == testTrip.getMPH());
    }

    @Test
    public void testAccessingTripStartTime() {
        assertEquals(START, testTrip.getStartTime());
    }

    @Test
    public void testConvertingTripToString() {
        String message = "Trip Start: 2:10 | Trip End: 5:50 | Miles Driven: 55 | Average MPH: 15";
        assertEquals(message, testTrip.toString());
    }

}