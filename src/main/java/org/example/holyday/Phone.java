package org.example.holyday;


public class Phone extends OfficeEquipment{
    public Phone(int id, String modelName, String manufacturer, int yearOfManufacture, int price, int weight, boolean isOperational) {
        super(id, modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
    }
    int screenSize;
    int storageSize;
    String operatingSystem;
    int batteryLife;
    boolean isSmart;
    int cameraResolution;
    String processorType;

    public Phone(int id, String modelName, String manufacturer, int yearOfManufacture, int price, int weight, boolean isOperational, int screenSize, int storageSize, String operatingSystem, int batteryLife, boolean isSmart, int cameraResolution, String processorType) {
        super(id, modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
        this.screenSize = screenSize;
        this.storageSize = storageSize;
        this.operatingSystem = operatingSystem;
        this.batteryLife = batteryLife;
        this.isSmart = isSmart;
        this.cameraResolution = cameraResolution;
        this.processorType = processorType;
    }

    @Override
    public String toString() {
        return "Phone: " +
                "id = " + id +
                ", modelName = '" + modelName + '\'' +
                ", manufacturer = '" + manufacturer + '\'' +
                ", yearOfManufacture = " + yearOfManufacture +
                ", price = " + price +
                ", weight = " + weight +
                ", isOperational = " + isOperational +
                ", screenSize = " + screenSize +
                ", storageSize = " + storageSize +
                ", operatingSystem = '" + operatingSystem + '\'' +
                ", batteryLife = " + batteryLife +
                ", isSmart = " + isSmart +
                ", cameraResolution = " + cameraResolution +
                ", processorType = '" + processorType + '\'' +
                '.';
    }
}
