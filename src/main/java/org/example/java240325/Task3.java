package org.example.java240325;

import java.util.Scanner;

public class Task3 {
    //    Проверьте, содержит ли массив заданный элемент.
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        chekNum(array);
    }

    public static void chekNum(int[] array) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int num = scanner.nextInt();
        for (int i = 0; i < array.length; i++) {
            if (num == array[i]) {
                System.out.println("Введенное вами чило " + num + " совпадает с " + i + " элементом в массиве.");
            }
        } System.out.println("совпадений нет");
    }
}
// вижу не красивость из-за надписи "совпадений нет", которая высвечивается в любом способе. Спросила у чата GPT как
// исправить эту ошибку, но не исправляла, т.к. отправляю код в том виде на который у меня мозгов хватило)))