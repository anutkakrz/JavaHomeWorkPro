package org.example.holyday;

import java.util.Arrays;

import static org.example.holyday.OfficeEquipment.getFullArray;

public class Main {
    public static void main(String[] args) {
        OfficeEquipment[] officeEquipments = getFullArray();
        Methods.printAllEquipment(officeEquipments);
        System.out.println();
        Methods.calculateTotalPrice(officeEquipments);
        Methods.listByManufacturer(officeEquipments,"Hoeger-Pagac");
        Methods.findOldestEquipment(officeEquipments);
        Methods.findEquipmentByYear(officeEquipments, 2021);
        Methods.findWorkingEquipment(officeEquipments);
    }

}
