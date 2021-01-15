import static org.junit.Assert.*;
import org.junit.*;

public class UtilTest {
    // Creating sample inputs to test
    String driverTest1 = "Driver Steve";
    String driverTest2 = "Driver Andrew";
    String tripTest1 = "Trip Steve 03:14 03:55 18.3";
    String tripTest2 = "Trip Andrew 07:15 07:45 17.3";
    String tripTest3 = "Trip Steve 08:21 09:49 58.1";

    @Test
    public void runningDriverCommand() {
        // Creating Test Database
        DriverDatabase testDB = new DriverDatabase();

        // Testing Driver Input Commands
        Util.parseCommand(driverTest1, testDB);
        Util.parseCommand(driverTest2, testDB);
        assertNotNull(testDB.getDriver("Steve"));
        assertNotNull(testDB.getDriver("Andrew"));
    }

    @Test
    public void runningTripCommand() {
        // Creating Test Database
        DriverDatabase testDB = new DriverDatabase();
        testDB.addDriver(new Driver("Steve"));
        testDB.addDriver(new Driver("Andrew"));

        // Testing Trip Input Commands
        Util.parseCommand(tripTest1, testDB);
        Util.parseCommand(tripTest2, testDB);
        Util.parseCommand(tripTest3, testDB);
        assertEquals(2, testDB.getDriver("Steve").numTrips());
        assertEquals(1, testDB.getDriver("Andrew").numTrips());
    }

}
