package org.example.java240325;

public class Task7 {
//    Найдите сумму всех четных элементов массива которые находятся на нечетных индексах.
public static void main(String[] args) {
    int[] array = {1, 3, 3, 1, 5, 6, 7, 10, 1};
    System.out.println("Сумма четных элементов массива рассположенных в нечетных индексах равна: "+getEvenSumOddIndex(array));
}
    public static int getEvenSumOddIndex(int[] array){
        int sum = 0;
        for (int i = 1; i < array.length; i+=2) {
                if (array[i]%2==0){
                    sum+=array[i];
                }
        }return sum;
    }
}
