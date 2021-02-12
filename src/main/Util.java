public class Util {
    // Calls Corresponding Command Function From Input
    public static void parseCommand(String command, DriverDatabase driverDB) {
        String[] input = command.split(" ");
        switch (input[0]) {
            case "Driver": {
                commandDriver(input, driverDB);
                break;
            }
            case "Trip": {
                commandTrip(input, driverDB);
                break;
            }
            case "Remove": {
                commandRemove(input, driverDB);
                break;
            }
            case "Car": {
                commandCar(input, driverDB);
                break;
            }
            default: {
                throw new IllegalArgumentException("Input File Contains Unknown Command");
            }
        }
    }

    // Input Command "Driver [NAME]"
    // Creates and Adds New Driver to Database
    public static void commandDriver(String[] command, DriverDatabase driverDB) {
        if (command.length != 2) {
            throw new IllegalArgumentException(
                    "Input File Command 'Driver' Contains Incorrect Number Of Parameters | Driver [NAME]");
        }

        // Adding New Driver
        driverDB.addDriver(new Driver(command[1]));
    }

    // Input Command "Car [DRIVER] [MAKE] [MODEL]"
    // Creates and Adds New Car to Specified Driver
    public static void commandCar(String[] command, DriverDatabase driverDB) {
        if (command.length != 4) {
            throw new IllegalArgumentException(
                    "Input File Command 'Car' Contains Incorrect Number Of Parameters | Car [DRIVER] [MAKE] [MODEL]");
        }

        driverDB.getDriver(command[1]).addCar(command[2], command[3]);
    }

    // Input Command "Trip [NAME] [STARTTIME] [ENDTIME] [MILES]"
    // Adds Inputted Trip to Specified Driver within the Database
    public static void commandTrip(String[] command, DriverDatabase driverDB) {
        if (command.length != 5) {
            throw new IllegalArgumentException(
                    "Input File Command 'Trip' Contains Incorrect Number Of Parameters | Trip [NAME] [STARTTIME] [ENDTIME] [MILES]");
        }

        // Reading In Command Parameters
        String driver = command[1];
        // Converting time to correspending number of minutes (i.e. 1:20 -> 80)
        int start = (Integer.parseInt(command[2].split(":")[0]) * 60) + Integer.parseInt(command[2].split(":")[1]);
        int end = (Integer.parseInt(command[3].split(":")[0]) * 60) + Integer.parseInt(command[3].split(":")[1]);
        double miles = Double.parseDouble(command[4]);

        Trip currTrip = new Trip(start, end, miles);
        // Adding Trip if 5 <= MPH <= 100
        if (currTrip.getMPH() >= 5 && currTrip.getMPH() <= 100) {
            driverDB.getDriver(driver).addTrip(currTrip);
        }
    }

    // Input Command "Remove [NAME] [TRIPSTART]"
    // Removes trip from [NAME] at specified [TRIPSTART]
    public static void commandRemove(String[] command, DriverDatabase driverDB) {
        if (command.length != 3) {
            throw new IllegalArgumentException(
                    "Input File Command 'Remove' Contains Incorrect Number Of Parameters | Remove [NAME] [TRIPSTART]");
        }

        int startTime = Integer.parseInt(command[2].split(":")[0]) * 60 + Integer.parseInt(command[2].split(":")[1]);
        // Searching for trip to remove
        driverDB.getDriver(command[1]).removeTrip(startTime);
    }
}
