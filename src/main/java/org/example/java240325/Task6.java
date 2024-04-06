package org.example.java240325;

public class Task6 {
    //    Найдите сумму всех нечетных элементов массива которые находятся на нечетных индексах.
    public static void main(String[] args) {
        int[] array = {1, 3, 3, 1, 5, 6, 7, 7, 1};
        System.out.println("Сумма нечетных элементов массива рассположенных в нечетных индексах равна: "+getOddSumOddIndex(array));
    }
    public static int getOddSumOddIndex(int[] array){
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if(i%2!=0){
                if (array[i]%2!=0){
                    sum+=array[i];
                }
            }
        }return sum;
    }
}
