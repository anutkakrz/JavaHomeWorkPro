package org.example.taski.taski2;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//уровень 7
public class TASKI2 {

    //Напишите метод, который принимает список чисел
    // и возвращает сумму квадратов всех нечетных чисел в списке.
    public static int sumOfSquaresOfOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(el -> el % 2 == 1)
                .mapToInt(el -> (int) Math.pow(el, 2))
                .sum();
    }

    //    public static int sumOfSquaresOfOddNumbers(List<Integer> numbers) {
//        return numbers.stream()
//                .reduce(0, (acc, el) ->{
//                    if (el % 2 > 0) {
//                        return  acc + el*el;
//                    }
//                    return acc;
//                });
//    }
    public static void main(String[] args) {
        List<String> strings = List.of("cat and dog",
                "hall in the city and cat");
//        System.out.println(uniqueSortedWords(strings));
//        System.out.println(uniqueChars(strings));
        System.out.println(longestString(strings));
    }
    //Напишите метод, который принимает список строк и возвращает
// список уникальных слов, отсортированных в лексикографическом порядке.
    public static List<String> uniqueSortedWords(List<String> strings) {
        return strings.stream()
                .flatMap(el-> Arrays.stream(el.split("\\W+")))
//                .peek(System.out::println)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
    //Напишите метод, который принимает список объектов и возвращает новый список, содержащий
    // только объекты, у которых определенное поле имеет заданное значение.
    public static <T> List<T> filterByField(List<T> objects , String fieldName, Object value) throws NoSuchFieldException {
        return (List<T>) objects.stream()
                .filter(el -> {
                    try {
                        return el.getClass().getDeclaredField(fieldName).get(el)
                                .equals(value);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toList());

    }
    //Напишите метод, который принимает список строк и возвращает список строк, содержащих
    // только уникальные символы (т.е. символы, которые не повторяются в строке).
    public static List<String> uniqueChars(List<String> strings) {
       return Collections.singletonList(strings.stream()
               .flatMap(el -> Arrays.stream(el.split("")))
               .distinct()
               .collect(Collectors.joining()));


    }
    //Напишите метод, который принимает список строк и возвращает самую длинную строку в списке.
    public static String longestString(List<String> strings) {
        return strings.stream()
                .sorted((el1,el2)->el2.length()-el1.length())
                .limit(1)
                .collect(Collectors.joining());

    }
//    //Напишите метод, который принимает список объектов и
//    // возвращает среднее значение заданного числового поля всех объектов в списке.
//    public static <T> double averageFieldValue(List<T> objects, String fieldName) throws NoSuchFieldException {
//
//    }
}

@AllArgsConstructor
@Getter
 class Person {
    String name;
    int age;
}
