package org.example.java2105;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stream2105 {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,4,7,22,8,9,10);
        getAVG(list1);

        List<Integer> list = List.of(1, 2, 3, 4, 4, 5, 2, 5, 5);

        List<Integer> newList = list.stream()
                .distinct()
                .sorted((num1, num2) -> num2 - num1)
                .toList();

        System.out.println(newList);
    }
    public static void getAVG (List<Integer> list){
        list.stream()
                .distinct()
                .sorted()
                .map(num -> {
                    if(num%2 ==0) {
                        num = num *10;
                    }
                    return num;
                })
                .forEach(el -> System.out.println(el));

    }

}
