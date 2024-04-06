package org.example.java240325;

public class Task14 {
    //    Найдите строку в массиве, содержащую наибольшее количество гласных.
    public static void main(String[] args) {
        String[] strings = {"Main","Forest","Woman","Hello People!","Main","Main"};
        System.out.println(getStringMaxVowels(strings));
    }
    public static int getStringMaxVowels(String[] strings){
        int count = 0;

        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length(); j++) {
                char ch = strings[i].charAt(j);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                count++;
            }
        }return count;
    }
}
