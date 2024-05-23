package org.example.taski.taski1;//package PROF.streams.streams.taski1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//уровень 3
public class TaskSTREAM {
    /**
     * //     * List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
     * //     * -- Отфильтровать нв четные и не четные
     * //     * -- Просуммировать все числа
     * //     * -- Получить среднее значение
     * //     * -- Найти суммы чисел кратных 3 и 5
     * //     * <p>
     * //     * List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
     * //     * -- Преобразовать список строк в список чисел
     * //     * <p>
     * //     * <p>
     * //     * List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry", "kiwi")
     * //     * -- Отфильтровать строки на те которые начинаются на 'a' и преобразовать из в верхний регистр
     * //     * -- Получить список слов которые содержат только уникальные символы
     * //     * <p>
     * //     * class Person {
     * //     * String name
     * //     * int age
     * //     * }
     * //     *
     * //     * -- Сделать из списка объектов список имен и отфильтровать по возрасту
     * //
     */

    //Задание 1: Фильтрация списка целых чисел на нечетные числа
    private static void m1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> oddNumbers = numbers.stream()
                .filter(el -> el % 2 == 1)
                .toList();
        System.out.println(oddNumbers); // [1, 3, 5, 7, 9]
    }

    //Задание 2: Преобразование списка строк в список чисел
    private static void m2() {
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
        List<Integer> numbers = strings.stream()
                .map(Integer::parseInt)
                .toList();
        System.out.println(numbers); // [1, 2, 3, 4, 5]
    }

    //Задание 3: Суммирование списка чисел
    private static void m3() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .mapToInt(el -> el)
                .sum();
        System.out.println(sum); // 15
    }

    //Задание 4: Определение максимального значения в списке
    private static void m4() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> max = numbers.stream()
                .max(Comparator.naturalOrder());
        System.out.println(max.get()); // 5
    }

    //Задание 5: Фильтрация списка строк на те, которые начинаются с определенной буквы и преобразование их в верхний регистр
    private static void m5() {
        List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry", "kiwi");
        List<String> list = words.stream()
                .filter(el -> el.startsWith("a"))
                .map(el -> el.toUpperCase())
                .toList();

        System.out.println(list);
    }

    //Задание 6: Получение списка уникальных слов из списка строк, длина которых больше 4 символов
    private static void m6() {
        List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry", "kiwi", "cherry", "kiwi");
        List<String> result = words.stream()
                .distinct()
                .filter(el -> el.length() > 4)
                .toList();
        System.out.println(result); // [banana, apricot, cherry]
    }

    //Задание 7:Преобразование списка объектов класса в список их имен, отсортированных по возрасту
    private static void m7() {
        List<Person> people = Arrays.asList(new Person("John", 25), new Person("Alice", 22), new Person("Bob", 30));
        List<String> names = people.stream()
                .flatMap(el -> Stream.of(el.getName()))
                .toList();
        System.out.println(names); // [Alice, John, Bob] = не сделала сортировку!!!!
    }

    //Задание 8:Нахождение суммы чисел, кратных 3 и 5, из списка чисел
    private static void m8() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        Optional<Integer> sum = numbers.stream()
                .filter(el -> ((el % 3) == 0) || (el % 5) == 0)
                .reduce(Integer::sum);
        System.out.println(sum); // 33 (3 + 5 + 6 + 9 + 10)
    }
//
//    //Задание 9:Получение списка слов, содержащих только уникальные символы, из списка строк
//    private static void m9() {
//        List<String> words =
//        System.out.println(result); // [kiwi, grape]
//    }

//    //Задание 10:
//    private static void m10(String[] strings) {
//        Map<Character, Long> characterFrequency =
//    }


    public static void main(String[] args) {
        m1();
        m2();
        m3();
        m4();
        m5();
        m6();
        m7();
        m8();
//        m6();
//        m10(new String[]{"mama", "papa"});
    }
}