import java.io.*;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Enter Input File As Command Line Argument");
        }

        // File driverInput = new File(args[0]);
        // BufferedReader br = new BufferedReader(new FileReader(file));

        Trip testTrip = new Trip(10, 400, 40);
        Driver testDriver = new Driver("Dave");
        System.out.println(testTrip);
        testDriver.addTrip(testTrip);
        System.out.println(testDriver);

    }

}