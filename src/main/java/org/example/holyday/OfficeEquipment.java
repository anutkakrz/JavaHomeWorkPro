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
//        OfficeEquipment[] officeEquipments = new OfficeEquipment[10];
        Random random = new Random();
        Faker faker = new Faker();
        Class[] classes = new Class[]{Laptop.class, Monitor.class,
                Phone.class, Printer.class, Projector.class, Router.class, Scanner.class,
                Switch.class, Tablet.class};
        OfficeEquipment[] officeObjects = new OfficeEquipment[10];

        for (int i = 0; i < officeObjects.length; i++) {
            int randomIndex = random.nextInt(classes.length);
            Class selectedClass = classes[randomIndex];

            if (selectedClass==Monitor.class) {
                officeObjects[i] = new Monitor(faker.number().randomDigit(),
                        faker.name().lastName(),
                        "Jerde, O'Kon and Quigley",
                        faker.number().numberBetween(1900, 2023),
                        faker.number().numberBetween(100, 10000),
                        faker.number().numberBetween(1, 10),
                        faker.bool().bool(),
                        faker.number().numberBetween(13, 40),
                        faker.number().numberBetween(300, 1600),
                        faker.name().lastName(),
                        faker.number().numberBetween(100, 400),
                        faker.bool().bool(),
                        faker.name().lastName(),
                        faker.bool().bool()
                );


            } else if (selectedClass==Phone.class) {
                officeObjects[i] = new Phone(faker.number().randomDigit(),
                        faker.name().lastName(),
                        "Hoeger-Pagac",
                        faker.number().numberBetween(1900, 2023),
                        faker.number().numberBetween(100, 10000),
                        faker.number().numberBetween(1, 10),
                        faker.bool().bool(),
                        faker.number().numberBetween(3, 13),
                        faker.number().numberBetween(4, 1000),
                        faker.name().lastName(),
                        faker.number().numberBetween(10, 100),
                        faker.bool().bool(),
                        faker.number().numberBetween(12, 200),
                        faker.name().lastName()
                );


            } else if (selectedClass==Printer.class) {
                officeObjects[i] = new Printer(faker.number().randomDigit(),
                        faker.name().lastName(),
                        "Hoeger-Pagac",
                        faker.number().numberBetween(1900, 2023),
                        faker.number().numberBetween(100, 10000),
                        faker.number().numberBetween(1, 10),
                        faker.bool().bool(),
                        faker.name().lastName(),
                        faker.number().numberBetween(10, 100),
                        faker.number().numberBetween(70, 1400),
                        faker.bool().bool(),
                        faker.number().numberBetween(10, 1000),
                        faker.name().lastName(),
                        faker.name().lastName()
                );


            } else if (selectedClass==Projector.class) {
                officeObjects[i] = new Projector(faker.number().randomDigit(),
                        faker.name().lastName(),
                        "Hoeger-Pagac",
                        faker.number().numberBetween(1900, 2023),
                        faker.number().numberBetween(100, 10000),
                        faker.number().numberBetween(1, 10),
                        faker.bool().bool(),
                        faker.number().numberBetween(100, 6000),
                        faker.number().numberBetween(300, 1600),
                        faker.number().numberBetween(5, 100),
                        faker.number().numberBetween(100, 10000),
                        faker.number().numberBetween(100, 1000),
                        faker.name().lastName(),
                        faker.bool().bool()
                );


            } else if (selectedClass==Router.class) {
                officeObjects[i] = new Router(faker.number().randomDigit(),
                        faker.name().lastName(),
                        faker.company().name(),
                        faker.number().numberBetween(1900, 2023),
                        faker.number().numberBetween(100, 10000),
                        faker.number().numberBetween(1, 10),
                        faker.bool().bool(),
                        faker.number().numberBetween(100, 10000),
                        faker.name().lastName(),
                        faker.name().lastName(),
                        faker.name().lastName(),
                        faker.name().lastName(),
                        faker.bool().bool(),
                        faker.name().lastName()
                );


            } else if (selectedClass==Scanner.class) {
                officeObjects[i] = new Scanner(faker.number().randomDigit(),
                        faker.name().lastName(),
                        faker.company().name(),
                        faker.number().numberBetween(1900, 2023),
                        faker.number().numberBetween(100, 10000),
                        faker.number().numberBetween(1, 10),
                        faker.bool().bool(),
                        faker.number().numberBetween(100, 1200),
                        faker.number().numberBetween(10, 50),
                        faker.number().numberBetween(24, 1000),
                        faker.number().numberBetween(100, 1000),
                        faker.name().lastName(),
                        faker.bool().bool(),
                        faker.name().lastName()
                );


            } else if (selectedClass==Switch.class) {
                officeObjects[i] = new Switch(faker.number().randomDigit(),
                        faker.name().lastName(),
                        faker.company().name(),
                        faker.number().numberBetween(1900, 2023),
                        faker.number().numberBetween(100, 10000),
                        faker.number().numberBetween(1, 10),
                        faker.bool().bool(),
                        faker.number().numberBetween(1, 10),
                        faker.number().numberBetween(100, 10000),
                        faker.number().numberBetween(1, 4),
                        faker.name().lastName(),
                        faker.name().lastName(),
                        faker.name().lastName(),
                        faker.name().lastName()
                );

            } else if (selectedClass==Tablet.class) {
                officeObjects[i] = new Tablet(faker.number().randomDigit(),
                        faker.name().lastName(),
                        faker.company().name(),
                        faker.number().numberBetween(1900, 2023),
                        faker.number().numberBetween(100, 10000),
                        faker.number().numberBetween(1, 10),
                        faker.bool().bool(),
                        faker.number().numberBetween(3, 17),
                        faker.number().numberBetween(4, 1000),
                        faker.name().lastName(),
                        faker.number().numberBetween(100, 1000),
                        faker.bool().bool(),
                        faker.number().numberBetween(12, 200),
                        faker.name().lastName());

            }
        }
        return officeObjects;
    }
}

