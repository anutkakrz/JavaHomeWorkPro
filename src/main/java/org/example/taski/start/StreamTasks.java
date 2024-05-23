package org.example.taski.start;


import java.sql.Array;
import java.util.*;
import java.util.stream.*;

public class StreamTasks {

    // 1. filter()
    // Задача: Отфильтровать список чисел, оставив только четные.
    public List<Integer> filterEvenNumbers(List<Integer> numbers) {
        List<Integer> list = numbers.stream()
                .filter(number ->
                        number % 2 == 0)
                .collect(Collectors.toList());
        return list;
    }

    // 2. filter()
    // Задача: Отфильтровать список строк, оставив только те, которые начинаются с буквы "A".
    public List<String> filterStringsStartingWithA(List<String> strings) {
        List<String> list = strings.stream()
                .filter(element -> element.startsWith("A"))
                .collect(Collectors.toList());
        return list;
    }

    // 3. map()
    // Задача: Преобразовать список строк в список их длин.
    public List<Integer> mapToStringLengths(List<String> strings) {
        List<Integer> list = strings.stream()
                .map(el -> el.length())
                .collect(Collectors.toList());
        return list;
    }

    // 4. map()
    // Задача: Преобразовать список чисел в список их квадратов.
    public List<Integer> mapToSquares(List<Integer> numbers) {
        List<Integer> list = numbers.stream()
                .map(el -> (int) Math.pow(el, 2))
                .collect(Collectors.toList());
        return list;
    }

    // 5. distinct()
    // Задача: Удалить дубликаты из списка чисел.
    public List<Integer> distinctNumbers(List<Integer> numbers) {
        List<Integer> list = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        return list;
    }

    // 6. distinct()
    // Задача: Удалить дубликаты строк из списка.
    public List<String> distinctStrings(List<String> strings) {
        List<String> list = strings.stream()
                .distinct()
                .collect(Collectors.toList());
        return list;
    }

    // 7. sorted()
    // Задача: Отсортировать список чисел по возрастанию.
    public List<Integer> sortNumbersAscending(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    // 8. sorted()
    // Задача: Отсортировать список строк по алфавиту.
    public List<String> sortStringsAlphabetically(List<String> strings) {
        return strings.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    // 9. limit()
    // Задача: Вернуть первые 5 элементов из списка чисел.
    public List<Integer> limitFirstFiveNumbers(List<Integer> numbers) {
        return numbers.stream()
                .limit(5)
                .collect(Collectors.toList());
    }

    // 10. limit()
    // Задача: Вернуть первые 3 строки из списка.
    public List<String> limitFirstThreeStrings(List<String> strings) {
        return strings.stream()
                .limit(3)
                .collect(Collectors.toList());
    }

    // 11. skip()
    // Задача: Пропустить первые 3 элемента списка чисел.
    public List<Integer> skipFirstThreeNumbers(List<Integer> numbers) {
        return numbers.stream()
                .skip(3)
                .collect(Collectors.toList());
    }

    // 12. skip()
    // Задача: Пропустить первые 2 строки из списка.
    public List<String> skipFirstTwoStrings(List<String> strings) {
        return strings.stream()
                .skip(2)
                .collect(Collectors.toList());
    }

    // 13. forEach()
    // Задача: Напечатать каждое число из списка.
    public void forEachPrintNumber(List<Integer> numbers) {
        numbers.stream()
                .forEach(number -> System.out.println());
    }

    // 14. forEach()
    // Задача: Напечатать каждую строку из списка.
    public void forEachPrintString(List<String> strings) {
        strings
                .forEach(string -> System.out.println());
    }

    // 15. allMatch()
    // Задача: Проверить, все ли числа в списке четные.
    public boolean allMatchEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number -> number % 2 == 0);

    }

    // 16. anyMatch()
    // Задача: Проверить, есть ли в списке хотя бы одно отрицательное число.
    public boolean anyMatchNegativeNumber(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < 0);
    }

    // 17. noneMatch()
    // Задача: Проверить, нет ли в списке нулевых значений.
    public boolean noneMatchZero(List<Integer> numbers) {
        return numbers.stream()
                .noneMatch(number -> number != 0);
    }

    // 18. findFirst()
    // Задача: Найти первый элемент в списке строк.
    public Optional<String> findFirstString(List<String> strings) {
        return strings.stream()
                .findFirst();
    }

    // 19. reduce()
    // Задача: Найти сумму всех чисел в списке.
    public int reduceSum(List<Integer> numbers) {
        return numbers.stream()
                .reduce(Integer::sum).get();
    }

    // 20. collect()
    // Задача: Собрать все строки в список, которые начинаются с буквы "B".
    public static List<String> collectStringsStartingWithB(List<String> strings) {
        return strings.stream()
                .filter(element -> element.startsWith("B"))
                .toList();
    }


    // 21. flatMap()
    // Задача: Преобразовать список списков чисел в один плоский список.
    public static List<Integer> flatMapLists(List<List<Integer>> listOfLists) {
        return listOfLists.stream()
                .flatMap(el -> el.stream())
                .toList();
    }

    // 22. count()
    // Задача: Посчитать количество строк в списке, которые длиннее 3 символов.
    public static long countLongStrings(List<String> strings) {
        return strings.stream()
                .filter(el -> el.length()>3)
                .count();
    }

    // 23. max()
    // Задача: Найти максимальное значение в списке чисел.
    public static Optional<Integer> findMaxValue(List<Integer> numbers) {
 return numbers.stream()
         .max(Comparator.naturalOrder());
    }

    // 24. min()
    // Задача: Найти минимальное значение в списке чисел.
    public Optional<Integer> findMinValue(List<Integer> numbers) {
       return numbers.stream()
               .min(Comparator.naturalOrder());
    }

    // 25. findAny()
    // Задача: Найти любой элемент в списке строк, начинающийся с буквы "C".
    public Optional<String> findAnyStringStartingWithC(List<String> strings) {
       return strings.stream()
               .filter(el -> el.startsWith("C"))
               .findAny();
    }

    // 26. toArray()
    // Задача: Преобразовать список строк в массив строк.
    public String[] toArrayStrings(List<String> strings) {
      return (String[]) strings.stream()
              .toArray();
    }

    // 27. peek()
    // Задача: Вывести на экран каждое число из списка перед удвоением значения.
    public List<Integer> peekAndDoubleNumbers(List<Integer> numbers) {
      return numbers.stream()
              .peek(System.out::println)
              .map(el ->el*2)
              .toList();
    }

    // 28. mapToInt()
    // Задача: Преобразовать список строк в список их длин и найти сумму длин всех строк.
    public static int mapToIntAndSum(List<String> strings) {
      return strings.stream()
              .mapToInt(el ->el.length())
              .sum();

    }
    public static void main(String[] args) {
        List <String> list = Arrays.asList("kol","Boom","dse","bil","Body");
//        System.out.println(collectStringsStartingWithB(list));
//        List <Integer> list1 = Arrays.asList(1,1,1,10,1,11,1,1);
//        List <Integer> list2 = Arrays.asList(2,2,2,2,2,2,2,2);
//        List<List<Integer>> lists = Arrays.asList(list1,list2);
//        System.out.println(flatMapLists(lists));
//        System.out.println(countLongStrings(list));
//        System.out.println(findMaxValue(list1));
        System.out.println(mapToIntAndSum(list));
    }
}
