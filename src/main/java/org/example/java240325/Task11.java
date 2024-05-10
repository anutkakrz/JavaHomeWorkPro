package org.example.java240325;

public class Task11 {
    //    Найдите самую длинную строку в массиве строк
    public static void main(String[] args) {
String[] strings = {"Main","Forest","Woman","Hello People!"};
        System.out.println(findLongestString(strings));
    }

    public static String findLongestString(String[] strings) {
        String longest = strings[0];
        for (int i = 0; i < strings.length; i++) {
            if (longest.length() < strings[i].length()) {
                longest = strings[i];
            }
        }
        return longest;
    }
}
