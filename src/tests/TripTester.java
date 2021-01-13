package com.github.jsardo9.worksample;

public class TripTester {
    public static void main(String[] args) {
        // Creating a sample Trip
        Trip testTrip = new Trip(130, 350, 55.3);

        // Running Basic Tests
        System.out.println("Testing Overridden toString() Function");
        System.out.println(testTrip + "\n");
        System.out.println("Testing getDuration() Function");
        System.out.println("Trip Duration: " + testTrip.getDuration() + "\n");
        System.out.println("Testing getEndTime() Function");
        System.out.println("Trip End Time: " + testTrip.getEndTime() + "\n");
        System.out.println("Testing getMiles() Function");
        System.out.println("Trip Miles: " + testTrip.getMiles() + "\n");
        System.out.println("Testing getMPH() Function");
        System.out.println("Trip MPH: " + testTrip.getMPH() + "\n");
        System.out.println("Testing getStartTime() Function");
        System.out.println("Trip Start Time: " + testTrip.getStartTime());
    }
}
