package org.example.holyday;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
//@AllArgsConstructor

public class Monitor extends OfficeEquipment {

    private int screenSize;
    private int resolution; //разрешение
    private String panelType;
    private int refreshRate; //частота обновления
    private boolean isCurved; //   Изогнутый
    private String ports;
    private boolean isHDR;

    public Monitor(int id, String modelName, String manufacturer, int yearOfManufacture, int price, int weight, boolean isOperational) {
        super(id, modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
    }

    public Monitor(int id, String modelName, String manufacturer, int yearOfManufacture, int price, int weight, boolean isOperational, int screenSize, int resolution, String panelType, int refreshRate, boolean isCurved, String ports, boolean isHDR) {
        super(id, modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.panelType = panelType;
        this.refreshRate = refreshRate;
        this.isCurved = isCurved;
        this.ports = ports;
        this.isHDR = isHDR;
    }

    @Override
    public String toString() {
        return "Monitor: " +
                "id = " + id +
                ", modelName = '" + modelName + '\'' +
                ", manufacturer = '" + manufacturer + '\'' +
                ", yearOfManufacture =  " + yearOfManufacture +
                ", price = " + price +
                ", weight = " + weight +
                ", isOperational = " + isOperational +
                ", screenSize = " + screenSize +
                ", resolution = '" + resolution + '\'' +
                ", panelType = '" + panelType + '\'' +
                ", refreshRate = " + refreshRate +
                ", isCurved = " + isCurved +
                ", ports = '" + ports + '\'' +
                ", isHDR = " + isHDR +
                '.';
    }
}
