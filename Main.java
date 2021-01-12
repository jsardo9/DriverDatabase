import java.io.*;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Enter Input File As Command Line Argument");
        }

        // Primary Data Structure
        DriverDatabase driverDB = new DriverDatabase();

        // Input File Reader
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String currLine;
            while ((currLine = br.readLine()) != null) {
                Util.parseCommand(currLine, driverDB);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Printing DB After Parsing Input Commands
        driverDB.printByMileage();
    }
}