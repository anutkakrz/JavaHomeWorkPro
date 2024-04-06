package org.example.java240325;

public class Task1 {
    //    Найдите сумму всех нечетных элементов массива.
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        System.out.println(getOddSum(array));
    }

    public static int getOddSum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                sum += array[i];
            }
        }
        return sum;
    }
}
