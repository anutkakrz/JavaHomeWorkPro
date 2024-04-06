package org.example.holyday;


public class Projector extends OfficeEquipment{
    public Projector(int id, String modelName, String manufacturer, int yearOfManufacture, int price, int weight, boolean isOperational) {
        super(id, modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
    }
    int lumens;
    int resolution;
    int contrastRatio;
    int lampLife;
    int projectionSize;
    String connectivity;
    boolean is3DReady; //

    public Projector(int id, String modelName, String manufacturer, int yearOfManufacture, int price, int weight, boolean isOperational, int lumens, int resolution, int contrastRatio, int lampLife, int projectionSize, String connectivity, boolean is3DReady) {
        super(id, modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
        this.lumens = lumens;
        this.resolution = resolution;
        this.contrastRatio = contrastRatio;
        this.lampLife = lampLife;
        this.projectionSize = projectionSize;
        this.connectivity = connectivity;
        this.is3DReady = is3DReady;
    }

    @Override
    public String toString() {
        return "Projector: " +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", price=" + price +
                ", weight=" + weight +
                ", isOperational=" + isOperational +
                ", lumens='" + lumens + '\'' +
                ", resolution='" + resolution + '\'' +
                ", contrastRatio='" + contrastRatio + '\'' +
                ", lampLife=" + lampLife +
                ", projectionSize=" + projectionSize +
                ", connectivity='" + connectivity + '\'' +
                ", is3DReady=" + is3DReady +
                '.';
    }
}
