package org.example.java240325;

public class Task12 {
    //    Подсчитайте, сколько раз в массиве встречается строка, равная заданной.
    public static void main(String[] args) {
        String[] strings = {"Main","Forest","Woman","Hello People!","Main","Main"};
        String string = "Forest";
        System.out.println("Слово "+string+ " встречается в массиве " +getQuantityStrings(strings, string )+" раз.");
    }
    public static int getQuantityStrings(String[] strings, String string){
        int quantity =0;
        for (int i = 0; i < strings.length; i++) {
            if (string.equals(strings[i])){
                quantity++;
            }
        }return quantity;
    }
}
