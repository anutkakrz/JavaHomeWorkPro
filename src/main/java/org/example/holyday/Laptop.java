package org.example.holyday;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
//@AllArgsConstructor
@Getter
@Setter
class Laptop extends OfficeEquipment {


   private String processorType;
   private int ramSize;
   private int storageSize;
   private int batteryLife;
   private int screenSize;
   private String operatingSystem;
   private boolean isTouchscreen;

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
