import java.io.*;

public class Main {

    public static void parseCommand(String command) {
        String[] input = command.split(" ");
        switch (input[0]) {
            case "Driver": {
                System.out.println("driver");
                break;
            }
            case "Trip": {
                System.out.println("trip");
                break;
            }
            default: {
                throw new IllegalArgumentException("Input File Contains Unknown Command");
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Enter Input File As Command Line Argument");
        }

        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String currLine;
            while ((currLine = br.readLine()) != null) {
                parseCommand(currLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}