package org.example.java240325;

public class Task13 {
    //    Проверьте, все ли строки в массиве имеют одинаковую длину
    public static void main(String[] args) {
        String[] strings = {"Main","Main","Main","Main"};
        checkEqualsLength(strings);
    }
public static void checkEqualsLength(String[] strings){
        boolean equalsLength = true;
    for (int i = 0; i < strings.length-1; i++) {
        if(strings[i].length()!=strings[i+1].length()){
            equalsLength =false;
            break;
        }
    }
    if (equalsLength == true) {
        System.out.println("все строки в массиве имеют одинаковую длину");
    } else System.out.println("строки в массиве имеют разную длину");
}
}
