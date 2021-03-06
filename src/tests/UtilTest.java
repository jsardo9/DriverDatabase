import static org.junit.Assert.*;
import org.junit.*;

public class UtilTest {
    // Creating sample inputs to test
    static final String DRIVERTEST1 = "Driver Steve";
    static final String DRIVERTEST2 = "Driver Andrew";
    static final String TRIPTEST1 = "Trip Steve 03:14 03:55 18.3";
    static final String TRIPTEST2 = "Trip Andrew 07:15 07:45 17.3";
    static final String TRIPTEST3 = "Trip Steve 08:21 09:49 58.1";

    @Test
    public void testDriverCommand() {
        // Creating Test Database
        DriverDatabase testDB = new DriverDatabase();

        // Testing Driver Input Commands
        Util.parseCommand(DRIVERTEST1, testDB);
        Util.parseCommand(DRIVERTEST2, testDB);
        assertNotNull(testDB.getDriver("Steve"));
        assertNotNull(testDB.getDriver("Andrew"));
    }

    @Test
    public void testTripCommand() {
        // Creating Test Database
        DriverDatabase testDB = new DriverDatabase();
        testDB.addDriver(new Driver("Steve"));
        testDB.addDriver(new Driver("Andrew"));

        // Testing Trip Input Commands
        Util.parseCommand(TRIPTEST1, testDB);
        Util.parseCommand(TRIPTEST2, testDB);
        Util.parseCommand(TRIPTEST3, testDB);
        assertEquals(2, testDB.getDriver("Steve").numTrips());
        assertEquals(1, testDB.getDriver("Andrew").numTrips());
    }

}
