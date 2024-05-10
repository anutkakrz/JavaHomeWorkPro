package org.example.holyday;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//@AllArgsConstructor
@Setter
@Getter
public class Printer extends OfficeEquipment {
    private String printTechnology;
    private int printSpeed;
    private int maxResolution;
    private boolean isColor;
    private int paperSize;
    private String connectivity;
    private String dutyCycle;

    public Printer(int id, String modelName, String manufacturer, int yearOfManufacture, int price, int weight, boolean isOperational) {
        super(id, modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
    }

    public Printer(int id, String modelName, String manufacturer, int yearOfManufacture, int price, int weight, boolean isOperational, String printTechnology, int printSpeed, int maxResolution, boolean isColor, int paperSize, String connectivity, String dutyCycle) {
        super(id, modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
        this.printTechnology = printTechnology;
        this.printSpeed = printSpeed;
        this.maxResolution = maxResolution;
        this.isColor = isColor;
        this.paperSize = paperSize;
        this.connectivity = connectivity;
        this.dutyCycle = dutyCycle;
    }

    @Override
    public String toString() {
        return "Printer: " +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", price=" + price +
                ", weight=" + weight +
                ", isOperational=" + isOperational +
                ", printTechnology='" + printTechnology + '\'' +
                ", printSpeed='" + printSpeed + '\'' +
                ", maxResolution=" + maxResolution +
                ", isColor=" + isColor +
                ", paperSize='" + paperSize + '\'' +
                ", connectivity='" + connectivity + '\'' +
                ", dutyCycle='" + dutyCycle + '\'' +
                '.';
    }
}
