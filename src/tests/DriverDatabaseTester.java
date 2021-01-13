package com.github.jsardo9.worksample;

public class DriverDatabaseTester {
    public static void main(String[] args) {
        // Creating a sample Database
        DriverDatabase testDB = new DriverDatabase();

        // Creating sample drivers with sample trips
        Driver Dave = new Driver("Dave");
        Dave.addTrip(new Trip(730, 760, 5.4));
        Dave.addTrip(new Trip(1120, 1155, 9.5));
        Dave.addTrip(new Trip(1301, 1355, 16.2));

        Driver Alex = new Driver("Alex");
        Alex.addTrip(new Trip(11, 95, 30.3));
        Alex.addTrip(new Trip(1200, 1342, 70.5));

        Driver James = new Driver("James");
        James.addTrip(new Trip(130, 350, 56.6));
        James.addTrip(new Trip(444, 560, 30.5));
        James.addTrip(new Trip(700, 720, 15.2));

        // Running Basic Tests
        System.out.println("Testing addDriver() Function");
        testDB.addDriver(Dave);
        testDB.addDriver(Alex);
        testDB.addDriver(James);
        System.out.println(testDB);
        System.out.println("Testing getDriver() Function");
        System.out.println("Retreiving Driver 'James':");
        System.out.println(testDB.getDriver("James") + "\n");
        System.out.println("Testing removeDriver() Function");
        System.out.println("Removing Driver 'Alex':");
        testDB.removeDriver("Alex");
        System.out.println(testDB);
        System.out.println("Testing printByMileage() Function");
        testDB.printByMileage();
    }
}
