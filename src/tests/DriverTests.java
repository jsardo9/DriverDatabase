public class DriverTests {
    public static void main(String[] args) {
        // Creating a sample Driver and his trips
        Driver testDriver = new Driver("Dave");
        Trip daveTrip1 = new Trip(130, 350, 56.6);
        Trip daveTrip2 = new Trip(444, 560, 30.5);
        Trip daveTrip3 = new Trip(700, 720, 15.2);

        // Running Basic Tests
        System.out.println("Testing Overridden toString() Function");
        System.out.println(testDriver + "\n");
        System.out.println("Testing addTrip() Function");
        testDriver.addTrip(daveTrip1);
        testDriver.addTrip(daveTrip2);
        testDriver.addTrip(daveTrip3);
        System.out.println(testDriver + "\n");
        System.out.println("Testing getMiles() Function");
        System.out.println("Total Driver Miles: " + testDriver.getMiles() + "\n");
        System.out.println("Testing getMPH() Function");
        System.out.println("Average Driver MPH: " + testDriver.getMPH() + "\n");
        System.out.println("Testing getName() Function");
        System.out.println("Driver Name: " + testDriver.getName() + "\n");
        System.out.println("Testing getTrips() Function");
        System.out.println("Total Trips:");
        for (Trip trp : testDriver.getTrips()) {
            System.out.println(trp);
        }
        System.out.println("\nTesting numTrips() Function");
        System.out.println("Number of Trips: " + testDriver.numTrips());
    }
}
