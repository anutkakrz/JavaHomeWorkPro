package org.example.holyday;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
@AllArgsConstructor

public class OfficeEquipment {
    int id;
    String modelName;
    String manufacturer;
    int yearOfManufacture;
    int price;
    int weight;
    boolean isOperational; // (исправность)


    @Override
    public String toString() {
        return "OfficeEquipment{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", price=" + price +
                ", weight=" + weight +
                ", isOperational=" + isOperational +
                '}';
    }

    public static OfficeEquipment[] getFullArray() {
        Random random = new Random();
        Faker faker = new Faker();
        Class<? extends OfficeEquipment>[] classes = new Class[]{Laptop.class, Monitor.class,
                Phone.class, Printer.class, Projector.class, Router.class, Scanner.class,
                Switch.class, Tablet.class};
        OfficeEquipment[] officeObjects = new OfficeEquipment[10];

        for (int i = 0; i < officeObjects.length; i++) {
            int randomIndex = random.nextInt(classes.length);
            Class<? extends OfficeEquipment> selectedClass = classes[randomIndex];

            if (selectedClass == Laptop.class) {
                int id = faker.number().randomDigit();
                String modelName = faker.name().lastName();
                String manufacturer = "Jerde, O'Kon and Quigley" ;
                int yearOfManufacture = faker.number().numberBetween(1900, 2023);
                int price = faker.number().numberBetween(100, 10000);
                int weight = faker.number().numberBetween(1, 10);
                boolean isOperational = faker.bool().bool();
                String processorType = faker.name().lastName();
                int ramSize = faker.number().numberBetween(4, 32);
                int storageSize = faker.number().numberBetween(128, 2048);
                int batteryLife = faker.number().numberBetween(4, 24);
                int screenSize = faker.number().numberBetween(5, 25);
                String operatingSystem = faker.name().lastName();
                boolean isTouchscreen = faker.random().nextBoolean();

                officeObjects[i] = new Laptop(id,
                        modelName,
                        manufacturer,
                        yearOfManufacture,
                        price,
                        weight,
                        isOperational,
                        processorType,
                        ramSize,
                        storageSize,
                        batteryLife,
                        screenSize,
                        operatingSystem,
                        isTouchscreen);

            } else if (selectedClass == Monitor.class) {
                int id = faker.number().randomDigit();
                String modelName = faker.name().lastName();
                String manufacturer =  "Jerde, O'Kon and Quigley" ;
                int yearOfManufacture = faker.number().numberBetween(1900, 2023);
                int price = faker.number().numberBetween(100, 10000);
                int weight = faker.number().numberBetween(1, 10);
                boolean isOperational = faker.bool().bool();
                int screenSize = faker.number().numberBetween(13, 40);
                int resolution = faker.number().numberBetween(300, 1600); //разрешение
                String panelType = faker.name().lastName();
                int refreshRate = faker.number().numberBetween(100, 400); //частота обновления
                boolean isCurved = faker.bool().bool(); //   Изогнутый
                String ports = faker.name().lastName();
                boolean isHDR = faker.bool().bool();

                officeObjects[i] = new Monitor(id,
                        modelName,
                        manufacturer,
                        yearOfManufacture,
                        price,
                        weight,
                        isOperational,
                        screenSize,
                        resolution,
                        panelType,
                        refreshRate,
                        isCurved,
                        ports,
                        isHDR);
            } else if (selectedClass == Phone.class) {
                int id = faker.number().randomDigit();
                String modelName = faker.name().lastName();
                String manufacturer ="Hoeger-Pagac";
                int yearOfManufacture = faker.number().numberBetween(1900, 2023);
                int price = faker.number().numberBetween(100, 10000);
                int weight = faker.number().numberBetween(1, 10);
                boolean isOperational = faker.bool().bool();
                int screenSize = faker.number().numberBetween(3, 13);
                int storageSize = faker.number().numberBetween(4, 1000);
                String operatingSystem = faker.name().lastName();
                int batteryLife = faker.number().numberBetween(10, 100); //
                boolean isSmart = faker.bool().bool();
                int cameraResolution = faker.number().numberBetween(12, 200);
                String processorType = faker.name().lastName();

                officeObjects[i] = new Phone(id,
                        modelName,
                        manufacturer,
                        yearOfManufacture,
                        price,
                        weight,
                        isOperational,
                        screenSize,
                        storageSize,
                        operatingSystem,
                        batteryLife,
                        isSmart,
                        cameraResolution,
                        processorType);
            } else if (selectedClass == Printer.class) {
                int id = faker.number().randomDigit();
                String modelName = faker.name().lastName();
                String manufacturer ="Hoeger-Pagac";
                int yearOfManufacture = faker.number().numberBetween(1900, 2023);
                int price = faker.number().numberBetween(100, 10000);
                int weight = faker.number().numberBetween(1, 10);
                boolean isOperational = faker.bool().bool();
                String printTechnology = faker.name().lastName();
                int printSpeed = faker.number().numberBetween(10, 100);
                int maxResolution = faker.number().numberBetween(70, 1400);
                boolean isColor = faker.bool().bool();
                int paperSize = faker.number().numberBetween(10, 1000);
                String connectivity = faker.name().lastName();
                String dutyCycle = faker.name().lastName();

                officeObjects[i] = new Printer(id,
                        modelName,
                        manufacturer,
                        yearOfManufacture,
                        price,
                        weight,
                        isOperational,
                        printTechnology,
                        printSpeed,
                        maxResolution,
                        isColor,
                        paperSize,
                        connectivity,
                        dutyCycle);

            } else if (selectedClass == Projector.class) {
                int id = faker.number().randomDigit();
                String modelName = faker.name().lastName();
                String manufacturer = "Hoeger-Pagac";
                int yearOfManufacture = faker.number().numberBetween(1900, 2023);
                int price = faker.number().numberBetween(100, 10000);
                int weight = faker.number().numberBetween(1, 10);
                boolean isOperational = faker.bool().bool();
                int lumens = faker.number().numberBetween(100, 6000);
                int resolution = faker.number().numberBetween(300, 1600);
                int contrastRatio = faker.number().numberBetween(5, 100);
                int lampLife = faker.number().numberBetween(100, 10000);
                int projectionSize = faker.number().numberBetween(100, 1000);
                String connectivity = faker.name().lastName();
                boolean is3DReady = faker.bool().bool();


                officeObjects[i] = new Projector(id,
                        modelName,
                        manufacturer,
                        yearOfManufacture,
                        price,
                        weight,
                        isOperational,
                        lumens,
                        resolution,
                        contrastRatio,
                        lampLife,
                        projectionSize,
                        connectivity,
                        is3DReady);

            } else if (selectedClass == Router.class) {
                int id = faker.number().randomDigit();
                String modelName = faker.name().lastName();
                String manufacturer = faker.company().name();
                int yearOfManufacture = faker.number().numberBetween(1900, 2023);
                int price = faker.number().numberBetween(100, 10000);
                int weight = faker.number().numberBetween(1, 10);
                boolean isOperational = faker.bool().bool();
                int speed = faker.number().numberBetween(100, 10000);
                String band = faker.name().lastName();
                String security = faker.name().lastName();
                String ports = faker.name().lastName();
                String range = faker.name().lastName();
                boolean isDualBand = faker.bool().bool();
                String connectivityType = faker.name().lastName();


                officeObjects[i] = new Router(id,
                        modelName,
                        manufacturer,
                        yearOfManufacture,
                        price,
                        weight,
                        isOperational,
                        speed,
                        band,
                        security,
                        ports,
                        range,
                        isDualBand,
                        connectivityType);

            } else if (selectedClass == Scanner.class) {
                int id = faker.number().randomDigit();
                String modelName = faker.name().lastName();
                String manufacturer = faker.company().name();
                int yearOfManufacture = faker.number().numberBetween(1900, 2023);
                int price = faker.number().numberBetween(100, 10000);
                int weight = faker.number().numberBetween(1, 10);
                boolean isOperational = faker.bool().bool();
                int scanResolution = faker.number().numberBetween(100, 1200);
                int scanSpeed = faker.number().numberBetween(10, 50);
                int colorDepth = faker.number().numberBetween(24, 1000);
                int maxPaperSize = faker.number().numberBetween(100, 1000);
                String connectivity = faker.name().lastName();
                boolean isDuplexScanning = faker.bool().bool();
                String scannerType = faker.name().lastName();

                officeObjects[i] = new Scanner(id,
                        modelName,
                        manufacturer,
                        yearOfManufacture,
                        price,
                        weight,
                        isOperational,
                        scanResolution,
                        scanSpeed,
                        colorDepth,
                        maxPaperSize,
                        connectivity,
                        isDuplexScanning,
                        scannerType);

            } else if (selectedClass == Switch.class) {
                int id = faker.number().randomDigit();
                String modelName = faker.name().lastName();
                String manufacturer = faker.company().name();
                int yearOfManufacture = faker.number().numberBetween(1900, 2023);
                int price = faker.number().numberBetween(100, 10000);
                int weight = faker.number().numberBetween(1, 10);
                boolean isOperational = faker.bool().bool();
                int portCount = faker.number().numberBetween(1, 10);
                int speed = faker.number().numberBetween(100, 10000);
                int layer = faker.number().numberBetween(1, 4);
                String managementType = faker.name().lastName();
                String powerOverEthernet = faker.name().lastName();
                String stackable = faker.name().lastName();
                String formFactor = faker.name().lastName();

                officeObjects[i] = new Switch(id,
                        modelName,
                        manufacturer,
                        yearOfManufacture,
                        price,
                        weight,
                        isOperational,
                        portCount,
                        speed,
                        layer,
                        managementType,
                        powerOverEthernet,
                        stackable,
                        formFactor);

            } else if (selectedClass == Tablet.class) {
                int id = faker.number().randomDigit();
                String modelName = faker.name().lastName();
                String manufacturer = faker.company().name();
                int yearOfManufacture = faker.number().numberBetween(1900, 2023);
                int price = faker.number().numberBetween(100, 10000);
                int weight = faker.number().numberBetween(1, 10);
                boolean isOperational = faker.bool().bool();
                int screenSize = faker.number().numberBetween(3, 17);
                int storageSize = faker.number().numberBetween(4, 1000);
                String operatingSystem = faker.name().lastName();
                int batteryLife = faker.number().numberBetween(100, 1000);
                boolean isCellular = faker.bool().bool();
                int cameraResolution = faker.number().numberBetween(12, 200);
                String processorType = faker.name().lastName();
//

                officeObjects[i] = new Tablet(id,
                        modelName,
                        manufacturer,
                        yearOfManufacture,
                        price,
                        weight,
                        isOperational,
                        screenSize,
                        storageSize,
                        operatingSystem,
                        batteryLife,
                        isCellular,
                        cameraResolution,
                        processorType);

            }
        }
        return officeObjects;
    }
}

