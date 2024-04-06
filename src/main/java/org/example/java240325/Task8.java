package org.example.java240325;

public class Task8 {
    //    Найдите произведение всех нечетных элементов массива.
    public static void main(String[] args) {
        int[] array = {1, 3, 3, 1, 5, 6, 7, 10, 1};
        System.out.println("Произведение всех нечетных элементов массива равнщ: "+getMultiplicationOddElements(array));
    }

    public static int getMultiplicationOddElements(int[] array) {
        int mult = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                mult *= array[i];
            }
        }
        return mult;
    }
}
