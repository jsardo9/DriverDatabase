public class Util {
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
            default: {
                throw new IllegalArgumentException("Input File Contains Unknown Command");
            }
        }
    }

    public static void commandDriver(String[] command, DriverDatabase driverDB) {
        if (command.length != 2) {
            throw new IllegalArgumentException(
                    "Input File Command 'Driver' Contains Incorrect Numerber Of Parameters | Driver [NAME]");
        }

        // Adding New Driver
        driverDB.addDriver(new Driver(command[1]));
    }

    public static void commandTrip(String[] command, DriverDatabase driverDB) {
        if (command.length != 5) {
            throw new IllegalArgumentException(
                    "Input File Command 'Trip' Contains Incorrect Numerber Of Parameters | Trip [NAME] [STARTTIME] [ENDTIME] [MILES]");
        }

        // Reading In Command Parameters
        String driver = command[1];
        int start = (Integer.parseInt(command[2].split(":")[0]) * 60) + Integer.parseInt(command[2].split(":")[1]);
        int end = (Integer.parseInt(command[3].split(":")[0]) * 60) + Integer.parseInt(command[3].split(":")[1]);
        double miles = Double.parseDouble(command[4]);

        Trip currTrip = new Trip(start, end, miles);
        // Adding Trip if 5 <= MPH <= 100
        if (currTrip.getMPH() >= 5 && currTrip.getMPH() <= 100) {
            driverDB.getDriver(driver).addTrip(currTrip);
        }
    }
}
