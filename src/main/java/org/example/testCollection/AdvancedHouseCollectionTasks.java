package org.example.testCollection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdvancedHouseCollectionTasks {

    // Задание 1: Вернуть список номеров квартир, у которых количество комнат больше среднего
    // кол-ва комнат по всем квартирам каждого дома (List)
    public static List<Integer> getFlatsWithMoreRoomsThanAverage(List<House> houses) {
        List<Integer> flatNumbers = new ArrayList<>();
        int sumKomn = 0;
        int count = 0;
        for (House house : houses) {
            for (Flat flat : house.flats) {
                sumKomn += flat.roomList.size();
                count++;
            }
        }
        int avgNumbKomn = sumKomn/count;
        for (House house : houses) {
            for (Flat flat : house.flats) {
                if (flat.roomList.size()>avgNumbKomn){
                    flatNumbers.add(flat.flatnumber);
                }
            }
        }

        return flatNumbers;
    }

    // Задание 2: Вернуть список этажей, на которых есть лифт (List и Set для исключения повторений)
    public static List<Integer> getFloorsWithElevator(List<House> houses) {
        Set<Integer> floorsWithElevator = new HashSet<>();
        for (House house : houses) {
            for (Flat flat : house.flats) {
                if (house.hasElevator){
                    floorsWithElevator.add(flat.floor);
                }
            }
        }

        return new ArrayList<>(floorsWithElevator);
    }

    // Задание 3: Подсчитать общее количество подъездов в домах, которые имеют больше 100 квартир (List)
    public static int getTotalEntrancesInLargeHouses(List<House> houses) {
        int totalEntrances = 0;
        for (House house : houses) {
          while (house.flats.size()>20){
              totalEntrances += house.entrance;
              break;
          }
        }
        return totalEntrances;
    }

    // Задание 4: Определить, все ли дома имеют лифт (List)
    public static boolean areAllHousesWithElevator(List<House> houses) {
        for (House house : houses) {
            if (!house.hasElevator) return false;
        }
        return true;
    }

    // Задание 5: Подсчитать общее количество квартир, расположенных на первом этаже (List)
    public static int getTotalFirstFloorFlats(List<House> houses) {
        int count = 0;
        for (House house : houses) {
            for (Flat flat : house.flats) {
               if (flat.floor == 0) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<House> houses = HouseGenerator.generateHouses(7); // Генерируем дома для примера

        System.out.println(houses);
        System.out.println(getFlatsWithMoreRoomsThanAverage(houses));
        System.out.println(getFloorsWithElevator(houses));
        System.out.println(getTotalEntrancesInLargeHouses(houses));
        System.out.println(areAllHousesWithElevator(houses));
        System.out.println(getTotalFirstFloorFlats(houses));
    }
}