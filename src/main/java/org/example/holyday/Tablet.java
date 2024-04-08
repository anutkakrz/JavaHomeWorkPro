package org.example.holyday;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Tablet extends OfficeEquipment{
    public Tablet(int id, String modelName, String manufacturer, int yearOfManufacture, int price, int weight, boolean isOperational) {
        super(id, modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
    }
    private int screenSize;
    private int storageSize;
    private String operatingSystem;
    private int batteryLife;
    private boolean isCellular;
    private int cameraResolution;
    private String processorType;

    public Tablet(int id, String modelName, String manufacturer, int yearOfManufacture, int price, int weight, boolean isOperational, int screenSize, int storageSize, String operatingSystem, int batteryLife, boolean isCellular, int cameraResolution, String processorType) {
        super(id, modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
        this.screenSize = screenSize;
        this.storageSize = storageSize;
        this.operatingSystem = operatingSystem;
        this.batteryLife = batteryLife;
        this.isCellular = isCellular;
        this.cameraResolution = cameraResolution;
        this.processorType = processorType;
    }

    @Override
    public String toString() {
        return "Tablet: " +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", price=" + price +
                ", weight=" + weight +
                ", isOperational=" + isOperational +
                ", screenSize=" + screenSize +
                ", storageSize=" + storageSize +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", batteryLife=" + batteryLife +
                ", isCellular=" + isCellular +
                ", cameraResolution=" + cameraResolution +
                ", processorType='" + processorType + '\'' +
                '.';
    }
}
