package org.example.streamTaski.start;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

import static java.lang.Integer.sum;

public class StreamTasksWithChaining {
    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 4, 6, 8, 7, 9, 3, 4, 2, 16, 22);
//        System.out.println(filterSortLimit(list));
        List<String> list = Arrays.asList("kallyy", "Boom", "daebaey", "billy1", "Body", "Vada", "Lada");
//        System.out.println(filterSortReverseAndJoin(list));
//        System.out.println(filterDoubleSort(list));
//        System.out.println(maxLengthGreaterThanThree(list));
        System.out.println(findFirstLongStringSorted(list));
    }

    // 1. Отфильтровать четные числа, отсортировать и вернуть первые 3
    public static List<Integer> filterSortLimit(List<Integer> numbers) {
        return numbers.stream()
                .filter(el -> el % 2 == 0)
                .sorted()
                .limit(3)
                .toList();
    }

    // 2. Преобразовать список строк в их длины, удалить дубликаты, отсортировать
    public List<Integer> mapDistinctSort(List<String> strings) {
        return (List<Integer>) strings.stream()
                .map(el -> el.length())
                .distinct()
                .sorted()
                .toList();
    }

    // 3. Отфильтровать строки, начинающиеся с "A", отсортировать по длине, вернуть первые 5
    public List<String> filterSortLimitStrings(List<String> strings) {
        return strings.stream()
                .filter(el -> el.startsWith("A"))
                .sorted(Comparator.comparingInt(String::length))
                .limit(5)
                .toList();
    }

    // 4. Найти сумму квадратов всех четных чисел
    public int sumOfSquaresOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(el -> el % 2 == 0)
                .mapToInt(el -> (int) Math.pow(el, 2))
                .sum();

    }

    // 5. Отфильтровать строки, отсортировать и вернуть как массив
    public String[] filterSortToArray(List<String> strings) {
        return (String[]) strings.stream()
                .filter(el -> el.contains("a"))
                .sorted()
                .toArray();
    }

    // 6. Преобразовать список чисел в их квадратные корни, удалить дубликаты и посчитать количество
    public long countDistinctSquareRoots(List<Integer> numbers) {
        return numbers.stream()
                .map(el -> Math.sqrt((double) el))
                .distinct()
                .count();
    }

    // 7. Отфильтровать строки, отсортировать в обратном порядке и соединить в одну строку
    public static String filterSortReverseAndJoin(List<String> strings) {
        return strings.stream()
                .filter(el -> el.contains("a"))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining(", "));
    }

    // 8. Отфильтровать нечетные числа, удвоить, отсортировать и вернуть как список
    public static List<Integer> filterDoubleSort(List<Integer> numbers) {
        return numbers.stream()
                .filter(el -> el % 2 == 1)
                .map(el -> el * 2)
                .sorted()
                .toList();
    }

    // 9. Преобразовать список строк в список их длин, отфильтровать длины больше 3 и найти максимум
    public static Optional<Integer> maxLengthGreaterThanThree(List<String> strings) {
        return strings.stream()
                .map(el -> el.length())
                .filter(el -> el > 3)
                .max(Comparator.naturalOrder());

    }

    // 10. Отфильтровать строки, не начинающиеся с "A", отсортировать по алфавиту и вернуть первые 3
    public List<String> filterNotStartingWithASortLimit(List<String> strings) {
        return strings.stream()
                .filter(el -> el.startsWith("A"))
                .sorted()
                .limit(3)
                .toList();
    }

    // 11. Преобразовать список чисел в строки, удалить дубликаты, отсортировать и соединить через запятую
    public String mapDistinctSortAndJoin(List<Integer> numbers) {
        return numbers.stream()
                .map(el -> el.toString())
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
    }

    // 12. Отфильтровать числа больше 10, удвоить их, посчитать количество уникальных
    public long countDistinctDoubledGreaterThanTen(List<Integer> numbers) {
        return numbers.stream()
                .filter(el -> el > 10)
                .map(el -> el * 2)
                .distinct()
                .count();
    }

    // 13. Преобразовать строки в верхний регистр, удалить дубликаты, отсортировать и вернуть как список
    public List<String> toUpperCaseDistinctSort(List<String> strings) {
        return strings.stream()
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .toList();
    }

    // 14. Отфильтровать строки, длина которых больше 5, отсортировать по длине и найти первую
    public static Optional<String> findFirstLongStringSorted(List<String> strings) {
        return strings.stream()
                .filter(el->el.length()>5)
                .sorted(Comparator.comparingInt(String::length))
                .findFirst();
    }

    // 15. Преобразовать список чисел в их квадраты, отфильтровать те, что меньше 50, и найти минимум
    public Optional<Integer> minSquareLessThanFifty(List<Integer> numbers) {
        return numbers.stream()
                .map(el ->(int)Math.pow(el,2))
                .filter(el->el<50)
                .min(Comparator.naturalOrder());
    }

    // 16. Отфильтровать строки, начинающиеся с "B", отсортировать и посчитать количество
    public long countStartingWithBSorted(List<String> strings) {
      return strings.stream()
              .filter(el->el.startsWith("B"))
              .sorted()
              .count();
    }

    // 17. Преобразовать числа в их строки, удалить дубликаты, отсортировать и найти любую строку
    public Optional<String> findAnyDistinctSortedString(List<Integer> numbers) {
     return numbers.stream()
             .map(el->el.toString())
             .distinct()
             .sorted()
             .findAny();
    }

    // 18. Отфильтровать строки длиной больше 3, преобразовать в верхний регистр и вернуть как массив
    public String[] filterLengthGreaterThanThreeToUpperArray(List<String> strings) {
        return (String[]) strings.stream()
                .filter(el ->el.length()>3)
                .map(el->el.toUpperCase())
                .toArray();
    }

    // 19. Отфильтровать числа больше 5, преобразовать в их кубы и вернуть как список
    public List<Integer> filterGreaterThanFiveMapToCubes(List<Integer> numbers) {
        return numbers.stream()
                .filter(el->el>5)
                .map(el->(int)Math.pow(el,3))
                .toList();
    }

    // 20. Преобразовать строки в их длины, отфильтровать четные, отсортировать и вернуть как список
    public List<Integer> mapToLengthsFilterEvenSort(List<String> strings) {
     return strings.stream()
             .map(el->el.length())
             .filter(el->el%2==0)
             .sorted()
             .toList();
    }

    // 21. Отфильтровать строки, начинающиеся с "C", отсортировать, пропустить первые 2 и вернуть остальные
    public List<String> filterStartingWithCSkipFirstTwo(List<String> strings) {
      return strings.stream()
              .filter(el->el.startsWith("C"))
              .sorted()
              .skip(2)
              .toList();
    }

    // 22. Преобразовать числа в строки, удалить дубликаты, отсортировать по длине и вернуть как список
    public List<String> mapToStringDistinctSortByLength(List<Integer> numbers) {
       return numbers.stream()
               .map(el->el.toString())
               .distinct()
               .sorted(Comparator.comparingInt(String::length))
               .toList();
    }

    // 23. Отфильтровать строки, длина которых больше 2, отсортировать и посчитать количество уникальных
    public long countDistinctLengthGreaterThanTwo(List<String> strings) {
    return strings.stream()
            .filter(el->el.length()>2)
            .sorted()
            .distinct()
            .count();
    }

    // 24. Преобразовать строки в нижний регистр, удалить дубликаты, отсортировать и вернуть как список
    public List<String> toLowerCaseDistinctSort(List<String> strings) {
    return strings.stream()
            .map(el->el.toLowerCase())
            .distinct()
            .sorted()
            .toList();
    }

    // 25. Отфильтровать строки, начинающиеся с "D", преобразовать в их длины, удалить дубликаты и вернуть как список
    public List<Integer> filterStartingWithDMapToLengthsDistinct(List<String> strings) {
       return strings.stream()
               .filter(el->el.startsWith("D"))
               .map(el->el.length())
               .distinct()
               .toList();
    }
}
