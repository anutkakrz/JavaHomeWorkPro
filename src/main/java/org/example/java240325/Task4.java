package org.example.java240325;

import java.util.Scanner;

public class Task4 {
    //    Посчитайте, сколько раз заданный элемент встречается в массиве.
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 1, 5, 6, 7, 7, 1};
        System.out.println("В массиве содержится: "+getQuantityElements(array)+" элемента совпадающие с введенным вами значением.");
    }

    public static int getQuantityElements(int[] array) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int element = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (element == array[i]) {
                count++;
            }
        }return count;
    }
}