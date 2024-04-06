package org.example.holyday;

public class Router extends OfficeEquipment{
    public Router(int id, String modelName, String manufacturer, int yearOfManufacture, int price, int weight, boolean isOperational) {
        super(id, modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
    }
    int speed;
    String band;
    String security;
    String ports;
    String range;
    boolean isDualBand;
    String connectivityType;

    public Router(int id, String modelName, String manufacturer, int yearOfManufacture, int price, int weight, boolean isOperational, int speed, String band, String security, String ports, String range, boolean isDualBand, String connectivityType) {
        super(id, modelName, manufacturer, yearOfManufacture, price, weight, isOperational);
        this.speed = speed;
        this.band = band;
        this.security = security;
        this.ports = ports;
        this.range = range;
        this.isDualBand = isDualBand;
        this.connectivityType = connectivityType;
    }

    @Override
    public String toString() {
        return "Router: " +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", price=" + price +
                ", weight=" + weight +
                ", isOperational=" + isOperational +
                ", speed=" + speed +
                ", band='" + band + '\'' +
                ", security='" + security + '\'' +
                ", ports='" + ports + '\'' +
                ", range='" + range + '\'' +
                ", isDualBand=" + isDualBand +
                ", connectivityType='" + connectivityType + '\'' +
                '.';
    }
}
