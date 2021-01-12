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

    // Public Accessor Method
    // ----------------------
    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getDuration() {
        return endTime - startTime;
    }

    public double getMiles() {
        return miles;
    }

    public double getMPH() {
        return miles / ((endTime - startTime) / 60.0);
    }

    // Overloaded Print Method
    public String toString() {
        String start = (startTime / 60) + ":" + (startTime % 60);
        String end = (endTime / 60) + ":" + (endTime % 60);
        return "Trip Start: " + start + " | Trip End: " + end + " | Miles Driven: " + (int) miles + " | Avergage MPH: "
                + (int) getMPH();
    }
}
