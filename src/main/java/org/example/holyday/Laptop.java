package org.example.holyday;


public class Laptop extends OfficeEquipment {


   String processorType;
   int ramSize;
   int storageSize;
   int batteryLife;
   int screenSize;
   String operatingSystem;
    boolean isTouchscreen;

    public Laptop(int id, String modelName, String manufacturer, int yearOfManufacture, int price, int weight, boolean isOperational) {
        super(id, modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
    }

    public Laptop(int id, String modelName, String manufacturer, int yearOfManufacture, int price, int weight, boolean isOperational, String processorType, int ramSize, int storageSize, int batteryLife, int screenSize, String operatingSystem, boolean isTouchscreen) {
        super(id, modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
        this.processorType = processorType;
        this.ramSize = ramSize;
        this.storageSize = storageSize;
        this.batteryLife = batteryLife;
        this.screenSize = screenSize;
        this.operatingSystem = operatingSystem;
        this.isTouchscreen = isTouchscreen;
    }

    @Override
    public String toString() {
        return "Laptop: " +
                "id = " + id +
                ", modelName = '" + modelName + '\'' +
                ", manufacturer = '" + manufacturer + '\'' +
                ", yearOfManufacture = " + yearOfManufacture +
                ", price = " + price +
                ", weight = " + weight +
                ", isOperational = " + isOperational +
                ", processorType = '" + processorType + '\'' +
                ", ramSize = " + ramSize +
                ", storageSize = " + storageSize +
                ", batteryLife = " + batteryLife +
                ", screenSize = " + screenSize +
                ", operatingSystem = '" + operatingSystem + '\'' +
                ", isTouchscreen = " + isTouchscreen +
                '.';
    }
}
