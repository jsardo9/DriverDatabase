import java.io.*;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Enter Input File Name As Command Line Argument | java Main [FILENAME]");
        }

        // Primary Data Structure
        DriverDatabase driverDB = new DriverDatabase();

        // Input File Reader
        try (BufferedReader br = new BufferedReader(new FileReader("input/" + args[0]))) {
            String currLine;
            while ((currLine = br.readLine()) != null) {
                Util.parseCommand(currLine, driverDB);
                System.out.println("Input: " + currLine);
                driverDB.printByMileage();
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Printing DB After Parsing Input Commands
        driverDB.printByMileage();
    }
}