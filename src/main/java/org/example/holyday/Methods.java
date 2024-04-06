package org.example.holyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Methods {
    public static void printAllEquipment(OfficeEquipment[] officeEquipment) {
        for (OfficeEquipment equipment : officeEquipment) {
            System.out.println(equipment + "\n");
        }
    }

    public static void calculateTotalPrice(OfficeEquipment[] officeEquipment) {
        int sum = 0;
        for (OfficeEquipment equipment : officeEquipment) {
            sum += equipment.price;
        }
        System.out.println("общая стоимость техники: " + sum + " $");
    }

    public static void listByManufacturer(OfficeEquipment[] officeEquipment, String manufacturer) {
        List<String> list = new ArrayList<>();
        for (OfficeEquipment equipment : officeEquipment) {
            if (equipment.manufacturer == manufacturer) {
                list.add(equipment.getClass().getSimpleName());
            }
        }
        System.out.println("техника от производителя " + manufacturer + ": " + list);
    }

    public static void findOldestEquipment(OfficeEquipment[] officeEquipment) {
        int minYear = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < officeEquipment.length; i++) {
            if (officeEquipment[i].yearOfManufacture < minYear) {
                minYear = officeEquipment[i].yearOfManufacture;
                index = i;
            }
        }
        System.out.println("самая старая техника: " + officeEquipment[index]);
    }

    public static void findEquipmentByYear(OfficeEquipment[] officeEquipment, int year) {
        boolean isPresent = false;
        for (OfficeEquipment equipment : officeEquipment) {
            if (equipment.yearOfManufacture == year) {
                System.out.println("техника произведенная в " + year + ": " + equipment);
                isPresent = true;
            }
        }
        if (!isPresent) {
            System.out.println("отсутствует техника произведенная в " + year + " году");
        }
    }

    public static void findWorkingEquipment(OfficeEquipment[] officeEquipment) {
        int count = 0;
        for (OfficeEquipment equipment : officeEquipment) {
            if (equipment.isOperational) {
                count++;
            }
        }
        System.out.println("колличество исправной техники: " + count);
    }
}
