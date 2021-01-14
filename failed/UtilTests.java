public class UtilTests {
    public static void main(String[] args) {
        // Creating a sample inputs
        String driverTest1 = "Driver Steve";
        String driverTest2 = "Driver Andrew";
        String tripTest1 = "Trip Steve 03:14 03:55 18.3";
        String tripTest2 = "Trip Andrew 07:15 07:45 17.3";
        String tripTest3 = "Trip Steve 08:21 09:49 58.1";

        // Database to store results
        DriverDatabase testDB = new DriverDatabase();

        // Running Basic Tests
        System.out.println("Parsing Driver Commands: ");
        System.out.println(driverTest1);
        System.out.println(driverTest2);
        Util.parseCommand(driverTest1, testDB);
        Util.parseCommand(driverTest2, testDB);
        System.out.println(testDB);
        System.out.println("Parsing Trip Commands");
        System.out.println(tripTest1);
        System.out.println(tripTest2);
        System.out.println(tripTest3);
        Util.parseCommand(tripTest1, testDB);
        Util.parseCommand(tripTest2, testDB);
        Util.parseCommand(tripTest3, testDB);
        System.out.println(testDB);
    }
}
