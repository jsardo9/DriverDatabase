public class Car {
    private String make;
    private String model;

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    // Public accessor methods
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    // Overriden parent methods
    public String toString() {
        return "Car: " + make + " " + model;
    }
}
