package org.example.java240325;

public class Task9 {
//    Найдите разность между максимальным и минимальным элементами массива.
    public static void main(String[] args) {
        int[] array = {4, 3, 3, 8, 5, 6, 7, 10, 15};
        System.out.println("Разница между максимальным и минимальным элементами массива равна: "+getSubtractionMaxMin(array));
    }
    public static int getSubtractionMaxMin(int[] array){
        int max = 0;
        int min = 2147483647;
        int subtraction = 0;
        for (int i = 0; i < array.length ; i++) {
            if(array[i]>max){
                max = array[i];
            } else if (array[i]<min) {
                min = array[i];
            }
        } return subtraction = max-min;
    }

}
