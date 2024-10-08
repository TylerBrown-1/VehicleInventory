package com.pluralsight;

public class Vehicle {
    private long vehicleId;
    private String makeModel;
    private String color;
    private int odometerReading;
    private float price;

    // Constructor
    public Vehicle(long vehicleId, String makeModel, String color, int odometerReading, float price) {
        this.vehicleId = vehicleId;
        this.makeModel = makeModel;
        this.color = color;
        this.odometerReading = odometerReading;
        this.price = price;
    }

    // Getters and Setters
    public long getVehicleId() {
        return vehicleId;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public String getColor() {
        return color;
    }

    public int getOdometerReading() {
        return odometerReading;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ID: " + vehicleId + ", Model: " + makeModel + ", Color: " + color +
                ", Odometer: " + odometerReading + ", Price: $" + price;
    }
}
