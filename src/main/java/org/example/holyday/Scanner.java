package org.example.holyday;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//@AllArgsConstructor
@Getter
@Setter
public class Scanner extends OfficeEquipment{
    public Scanner(int id, String modelName, String manufacturer, int yearOfManufacture, int price, int weight, boolean isOperational) {
        super(id, modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
    }
    private int  scanResolution;
    private int scanSpeed;
    private int colorDepth;
    private int maxPaperSize;
    private String connectivity;
    private boolean isDuplexScanning;
    private String scannerType;

    public Scanner(int id, String modelName, String manufacturer, int yearOfManufacture, int price, int weight, boolean isOperational, int scanResolution, int scanSpeed, int colorDepth, int maxPaperSize, String connectivity, boolean isDuplexScanning, String scannerType) {
        super(id, modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
        this.scanResolution = scanResolution;
        this.scanSpeed = scanSpeed;
        this.colorDepth = colorDepth;
        this.maxPaperSize = maxPaperSize;
        this.connectivity = connectivity;
        this.isDuplexScanning = isDuplexScanning;
        this.scannerType = scannerType;
    }

    @Override
    public String toString() {
        return "Scanner: " +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", price=" + price +
                ", weight=" + weight +
                ", isOperational=" + isOperational +
                ", scanResolution=" + scanResolution +
                ", scanSpeed=" + scanSpeed +
                ", colorDepth='" + colorDepth + '\'' +
                ", maxPaperSize='" + maxPaperSize + '\'' +
                ", connectivity='" + connectivity + '\'' +
                ", isDuplexScanning=" + isDuplexScanning +
                ", scannerType='" + scannerType + '\'' +
                '.';
    }
}
