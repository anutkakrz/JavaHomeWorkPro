package org.example.holyday;

import com.github.javafaker.Faker;


import java.util.Arrays;
import java.util.Random;

import static org.example.holyday.OfficeEquipment.getFullArray;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getFullArray()));

    }

}
