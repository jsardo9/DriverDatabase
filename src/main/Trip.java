package com.github.jsardo9.worksample;

public class Trip {
    // startTime and endTime stored as minutes on 24hr clock
    private int startTime;
    private int endTime;
    private double miles;

    public Trip(int startTime, int endTime, double miles) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.miles = miles;
    }

    // Public Accessor Methods
    public int getDuration() {
        return endTime - startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public double getMiles() {
        return miles;
    }

    public double getMPH() {
        return miles / ((endTime - startTime) / 60.0);
    }

    public int getStartTime() {
        return startTime;
    }

    // Overloaded Methods
    public String toString() {
        String start = (startTime / 60) + ":" + (startTime % 60);
        String end = (endTime / 60) + ":" + (endTime % 60);
        return "Trip Start: " + start + " | Trip End: " + end + " | Miles Driven: " + (int) miles + " | Average MPH: "
                + (int) getMPH();
    }
}
