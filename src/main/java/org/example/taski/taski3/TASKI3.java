package org.example.taski.taski3;


import org.example.taski.taski1.Person;

import java.util.*;
import java.util.stream.Collectors;

public class TASKI3 {
    public static void main(String[] args) {
        m1();
        m2();
        m3();
        m4();
    }

    /**
     * Дан список строк. Необходимо найти количество строк, которые содержат з
     * аданное подстроку. Решение с использованием Stream API:
     */
    private static void m1() {
        List<String> list = Arrays.asList("Java", "JavaScript", "Python", "Ruby");
        String substring = "Ja";
        int count;
        count = (int) list.stream()
                .filter(el -> el.contains(substring))
                .count();
        System.out.println("Количество строк, содержащих подстроку '" + substring + "': " + count);
    }


    /**
     * Дан список целых чисел. Необходимо найти максимальный
     * элемент списка, который делится на заданное число без остатка.
     * Решение с использованием Stream API:
     */
    private static void m2() {
        List<Integer> list = Arrays.asList(10, 15, 20, 25, 30);
        int number = 5;
        OptionalInt maxN;
        maxN = list.stream()
                .filter(el ->el% number==0)
                .mapToInt(Integer::intValue)
                .max();
        System.out.println("Максимальный элемент списка, который делится на число: "+number+
                ", без остатка: "+maxN);

    }


    /**
     * Дана коллекция объектов класса Person. Класс Person содержит поля name и age.
     * Необходимо найти средний возраст людей, чьи имена начинаются на заданную букву.
     * Решение с использованием Stream API:
     */
    private static void m3() {
        List<Person> people = Arrays.asList(
                new Person("John", 20),
                new Person("Dane", 25),
                new Person("Hack", 30),
                new Person("James", 35),
                new Person("Jill", 40)
        );
        String bukva = "J";
OptionalDouble averageAge = people.stream()
        .filter(el->el.getName().startsWith(String.valueOf(bukva)))
        .mapToDouble(el-> el.getAge())
        .average();
        System.out.println("Средний возраст людей у которых имя начинается на букву: "+bukva+
                " - "+averageAge);
    }


    /**
     * Дана коллекция строк. Необходимо найти все уникальные слова, которые содержатся в
     * этой коллекции строк, и вернуть их в виде списка. Решение с использованием Stream API:
     */
    private static void m4() {
        List<String> lines = Arrays.asList(
                "Java is a programming a language.",
                "Java is widely used in enterprise applications.",
                "Python is gaining popularity as a data science tool.",
                "Python is a versatile programming language."
        );
        List<String> uniqueWords = lines.stream()
                .flatMap(el -> Arrays.stream(el.split(" ")))
//                .peek(System.out::println)
                .distinct()
                .toList();
//        .collect(Collectors.toSet());

        System.out.println("уникальные слова: "+ uniqueWords);
    }
}
