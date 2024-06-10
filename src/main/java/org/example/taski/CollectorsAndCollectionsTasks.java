package org.example.taski;

import lombok.Getter;
import lombok.ToString;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toSet;
import static org.yaml.snakeyaml.nodes.NodeId.mapping;

//import static java.util.stream.Nodes.collect;

public class CollectorsAndCollectionsTasks {

    public static void main(String[] args) {
        // Задача 1: Собрать элементы потока в список.
        List<String> task1 = Stream.of("A", "B", "C").toList();
        System.out.println("Task 1: " + task1);

        // Задача 2: Удалить дубликаты из списка и собрать их в множество.
        List<String> task2Input = Arrays.asList("A", "B", "A", "C");
        Set<String> task2 = task2Input.stream().collect(Collectors.toSet());
        System.out.println("Task 2: " + task2);

        // Задача 3: Группировка строк по длине.
        List<String> list = Arrays.asList("mama", "papa", "key", "windows", "key", "la", "windows", "sun", "windows", "abrikose");

        Map<Integer, List<String>> task3 = list.stream()
                .collect(Collectors.groupingBy
                        (el -> el.length(), Collectors.toList()));

        System.out.println("Task 3: " + task3);

//         Задача 4: Подсчет повторяющихся элементов и создание мапа.
        Map<String, Integer> task4 = list.stream()
                .flatMap(el -> Arrays.stream(el.split("\\s+ ")))
                .collect(Collectors.toMap(el -> el, el -> 1, Integer::sum));

        System.out.println("Task 4: " + task4);

        // Задача 5: Собрать только уникальные элементы в список.
        List<String> task5Input = Arrays.asList("A", "B", "A", "C", "B", "D");
        List<String> task5 = task5Input.stream()
                .distinct()
                .toList();
        System.out.println("Task 5: " + task5);

        // Задача 6: Максимальные длины.
        String task6 = String.valueOf(list.stream()
                .map(el -> el.length())
                .max(Comparator.naturalOrder()));
        System.out.println("Task 6: " + task6);

        // Задача 7: Разбиение строки на символы и сбор их в множество.
        String task7Input = "hello";
        Set<Character> task7 = Arrays.stream(new String[]{task7Input})
                .flatMapToInt(el -> el.chars())
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        System.out.println("Task 7: " + task7);

//        // Задача 8: Построение кастомной мапы из элементов.
//        Map<String, Integer> task8 =
//        System.out.println("Task 8: " + task8);
//
        // Задача 9: Подсчет суммы значений объектов.
        List<Person> task9Input = Arrays.asList(
                new Person("Ivan", 19),
                new Person("Ira", 29),
                new Person("Oleg", 49),
                new Person("Nitka", 61),
                new Person("Sveta", 13),
                new Person("Zlata", 18),
                new Person("Igor", 24),
                new Person("Masha", 51)
        );
        Integer totalAge = task9Input.stream()
                .map(el -> el.age)
                .mapToInt(el -> el)
                .sum();
        System.out.println("Task 9: " + totalAge);

        // Задача 10: Группировка по критерию и подсчет среднего.
        List<Person> task10Input = Arrays.asList(
                new Person("Ivan", 19),
                new Person("Ira", 29),
                new Person("Oleg", 49),
                new Person("Nitka", 61),
                new Person("Sveta", 13),
                new Person("Zlata", 18),
                new Person("Igor", 24),
                new Person("Masha", 51)
        );

        Map<String,Double> task10 = task10Input.stream()
                .collect(Collectors.groupingBy(el -> String.valueOf(el.name.startsWith("I")),
                        Collectors.averagingDouble(el->el.age)));


        System.out.println("Task 10: " + task10);
    }

    @Getter
    @ToString
    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

    }
}
