package org.example.java240327_Taski1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[2];
        employees[0] = new Manager("Shmalko", "TopManager",10000,6);
        employees[1] = new Developer("Frolov", "Junior",6000, "Java");
        for (int i = 0; i < employees.length; i++) {
            System.out.println(Arrays.toString(employees));
        }
    }
}
