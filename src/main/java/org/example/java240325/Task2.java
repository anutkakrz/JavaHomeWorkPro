package org.example.java240325;

public class Task2 {
//    Найдите максимальный элемент в массиве.
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        System.out.println(getMaxElement(array));
    }
    public static int getMaxElement(int[] array) {
        int maxElement = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]>maxElement){
                maxElement=array[i];
            }
        } return  maxElement;
    }
}
