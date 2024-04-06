package org.example.java240325;

import java.util.Arrays;

public class Task5 {
    //    Инвертируйте элементы массива.
    public static void main(String[] args) {
String[] array = {"11","22","33","44","55","66"};
        System.out.println(Arrays.toString(invertElementsArray(array)));
    }
    public static String[] invertElementsArray(String[] array){
        int middleArray = array.length/2;
        int startIndex = 0;
        int endIndex = array.length-1;
        String temp;

        for (int i = 0; i < middleArray ; i++) {
            temp = array[startIndex];
            array[startIndex]=array[endIndex];
            array[endIndex]=temp;
            startIndex++;
            endIndex--;
        }return array;
    }
}
