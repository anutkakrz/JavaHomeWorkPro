package org.example.holyday;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Switch extends OfficeEquipment{
    public Switch(int id, String modelName, String manufacturer, int yearOfManufacture, int price, int weight, boolean isOperational) {
        super(id, modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
    }
    private int portCount;
    private int speed;
    private int layer;
    private String managementType;
    private String powerOverEthernet;
    private String stackable;
    private String formFactor;

    public Switch(int id, String modelName, String manufacturer, int yearOfManufacture, int price, int weight, boolean isOperational, int portCount, int speed, int layer, String managementType, String powerOverEthernet, String stackable, String formFactor) {
        super(id, modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
        this.portCount = portCount;
        this.speed = speed;
        this.layer = layer;
        this.managementType = managementType;
        this.powerOverEthernet = powerOverEthernet;
        this.stackable = stackable;
        this.formFactor = formFactor;
    }

    @Override
    public String toString() {
        return "Switch: " +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", price=" + price +
                ", weight=" + weight +
                ", isOperational=" + isOperational +
                ", portCount='" + portCount + '\'' +
                ", speed=" + speed +
                ", layer='" + layer + '\'' +
                ", managementType='" + managementType + '\'' +
                ", powerOverEthernet='" + powerOverEthernet + '\'' +
                ", stackable='" + stackable + '\'' +
                ", formFactor='" + formFactor + '\'' +
                '.';
    }
}
