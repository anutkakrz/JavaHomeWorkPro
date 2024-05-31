package org.example._2024_05_31;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//import static java.util.stream.Nodes.collect;

public class TaskiInputOutput {

    public static Map<String, List<Double>> streamsToRatings = new HashMap<>();
    public static Map<String, Double> avarageRating = new HashMap<>();

    public static String line = null;
    public static String task2 = null;
    public static String task3 = null;
    public static String task4 = null;
    public static String task5min = null;
    public static String task5max = null;
    public static String task6 = null;
    public static String task7 = null;
    public static String task8 = null;
    public static String task9 = null;
    public static String task10 = null;

    public static void main(String[] args) {
        read();
        System.out.println(streamsToRatings);
        writeToFile("1.txt", getAvarageRetingALL(), false);
        System.out.println(getAverageRating());
        String strimAvarage = avarageRating.toString();
        writeToFile("1_1.txt", strimAvarage, false);
        getAvarageRatingMore4and5();
        writeToFile("2.txt", task2, false);
        getNumbersStreams();
        writeToFile("3.txt", task3, false);
        getSortRating();
        writeToFile("4.txt", task4, false);
        getMinRating();
        writeToFile("5.txt", task5min, false);
        getMaxRating();
        getStatistic();
        writeToFile("6.txt", task6, false);
        plusPrefiks();
        writeToFile("7.txt", task7, false);
        getStraemsWithLowRating();
        writeToFile("8.txt", task8, false);
        getAllNames();
        writeToFile("10.txt", task10, false);
//        writeToFile("9.txt", task9, false);


    }

    public static void read() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("f.txt"));
            while ((reader.readLine()) != null) {
                String line = reader.readLine();
                String key = keyGetter(line);
                Double value = valueGetter(line);
                if (key != null && value != null) {
                    List<Double> list = streamsToRatings.getOrDefault(key, new ArrayList<>());
                    list.add(value);
                    streamsToRatings.put(key, list);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Double valueGetter(String line) {
        Pattern pattern = Pattern.compile("\\d+\\.\\d+");
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
//            System.out.println(matcher.group());
            return Double.parseDouble(matcher.group());
        }
        return null;
    }

    private static String keyGetter(String line) {
        Pattern pattern = Pattern.compile("\\d+:\\s*\\[([^\\]]+)\\]");
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
//            System.out.println(matcher.group(1));
            return matcher.group(1);
        }
        return null;
    }

    public static void writeToFile(String fileName, String line, Boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, append))) {
            writer.write(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //    !!!Прочитайте файл и посчитайте средний рейтинг всех стримов. Запишите результат в новый файл.
    private static String getAvarageRetingALL() {
        line = String.valueOf(streamsToRatings.entrySet()
                .stream()
                .flatMap((el) -> el.getValue().stream())
                .mapToDouble(el -> el)
                .average()
                .getAsDouble());
        return line;
    }
    //    !!!Прочитайте файл и посчитайте средний рейтинг всех стримов.  - средний рейтинг каждого стрима по отдельности.

    private static Map<String, Double> getAverageRating() {
        avarageRating = streamsToRatings.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .mapToDouble(Double::doubleValue)
                                .average()
                                .orElse(0.0)
                ));
        return avarageRating;
    }

    //    Отфильтруйте стримы, имеющие рейтинг выше 4.5, и запишите их в новый файл.
    private static String getAvarageRatingMore4and5() {
        task2 = avarageRating.entrySet().stream()
                .filter(entry -> entry.getValue() > 4.5)
                .collect(Collectors.toMap(entry ->
                        entry.getKey(), entry -> entry.getValue()))
                .toString();
        return task2;
    }

//    Сгруппируйте стримы по названию и запишите количество стримов в каждой группе в новый файл.

    private static String getNumbersStreams() {
        task3 = streamsToRatings.entrySet().stream()
                .collect(Collectors.toMap(entry -> entry.getKey(),
                        entry -> entry.getValue().stream()
                                .mapToDouble(Double::doubleValue)
                                .count()))
                .toString();
        return task3;
    }

//    Отсортируйте стримы по рейтингу от наибольшего к наименьшему и запишите результаты в новый файл.
private static String getSortRating() {
    task4 = avarageRating.entrySet().stream()
            .sorted(Map.Entry.comparingByValue((el1,el2)-> (int) (el2-el1)))
            .collect(Collectors.toMap(entry ->
                    entry.getKey(), entry -> entry.getValue()))
            .toString();
    return task4;
}

//    Найдите стримы с минимальным рейтингом и выведите их в новый файл.
private static String getMinRating() {
    task5min = avarageRating.entrySet().stream()
            .min(Map.Entry.comparingByValue())
            .map(entry->Collections.singletonMap(entry.getKey(),entry.getValue()))
            .orElse(Collections.emptyMap())
            .toString();
    return task5min;
}
    private static String getMaxRating() {
        task5max = avarageRating.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(entry->Collections.singletonMap(entry.getKey(),entry.getValue()))
                .orElse(Collections.emptyMap())
                .toString();
        return task5max;
    }


//    Соберите статистику по рейтингам (минимальный, максимальный, средний) и запишите ее в новый файл.
    private static String getStatistic(){
        return task6 = "Min rating: "+task5min+", "+"Avarage rating: "+line+", "+"Max rating: "+task5max;
    }

//    Измените названия всех стримов, добавив к ним префикс "Stream-" и запишите обновленные названия в новый файл.
    private static String plusPrefiks(){
        task7 = avarageRating.entrySet().stream()
                .map(entry->"Stream-" +entry.getKey())
                .collect(Collectors.toSet())
                .toString();
        return task7;
    }

//    Отфильтруйте стримы с рейтингом ниже 4.7 и преобразуйте их названия, добавив в конец "-
//    Low Rated". Запишите результаты в новый файл.
    private static String getStraemsWithLowRating(){
        task8 = avarageRating.entrySet().stream()
                .filter(entry ->entry.getValue()<4.7)
                .collect(Collectors.toMap(entry ->entry.getKey(),
                        entry ->entry.getValue()+" - Low Rated"))
                .toString();
        return task8;
    }

//    Создайте сводку, включающую идентификатор стрима, название и рейтинг, и запишите ее в
//    новый файл в формате "ID: Название - Рейтинг".
// !!!!!!! не поняла условие задачи!!!!!!!

//    Соберите все названия стримов в одну длинную строку, разделяя их запятыми, и запишите эту строку в новый файл.
    private static String getAllNames(){
        task10 = avarageRating.entrySet().stream()
                .map(entry->entry.getKey())
                .toList()
                .toString();
        return task10;
    }
}





