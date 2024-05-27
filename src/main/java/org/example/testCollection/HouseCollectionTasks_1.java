package org.example.testCollection;

import java.util.*;

public class HouseCollectionTasks_1 {
    
    // Задание 1: Вернуть список всех квартир во всех домах (List)
    public static List<Flat> getAllFlats(List<House> houses) {
        List<Flat> allFlats = new ArrayList<>();
        for (House house : houses)
            allFlats.addAll(house.flats);

        return allFlats;
    }

    // Задание 2: Вернуть множество всех уникальных цветов, используемых в комнатах квартир (Set)
    public static Set<Color> getUniqueRoomColors(List<House> houses) {
        Set<Color> colors = new HashSet<>();
        for (House house : houses) {
            for (Flat flat : house.flats) {
                for (Room room : flat.roomList) {
                    colors.add(room.color);
                }
            }
        }
        return colors;
    }

    // Задание 3: Вернуть карту, ключами которой являются номера этажей, а значениями - количество квартир на этом этаже (Map)
    public static Map<Integer, Integer> getFlatsCountByFloor(House house) {
        Map<Integer, Integer> floorMap = new HashMap<>();
        for (Flat flat : house.flats) {
            int floor = flat.floor;
            if (floorMap.containsKey(floor)) {
                floorMap.put(floor,floorMap.get(floor)+1);
            } else {
                floorMap.put(floor,1);
            }
        }
        return floorMap;
    }

    // Задание 4: Используя очередь, вернуть список номеров квартир в порядке, в котором они появляются, начиная с первого подъезда (Queue)
    public static List<Integer> getFlatNumbersInOrder(House house) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> orderedFlatNumbers = new ArrayList<>();
        for (Flat flat : house.flats) {
           queue.offer(flat.flatnumber);
        } while (!queue.isEmpty()) {
            orderedFlatNumbers.add(queue.poll());
        }
        return orderedFlatNumbers;
    }

    // Задание 5: Используя стек, вернуть список всех квартир в обратном порядке от последнего дома к первому (Stack)
    public static List<Flat> getFlatsInReverseOrder(House house) {
        Stack<Flat> stack = new Stack<>();
        List<Flat> reversedFlats = new ArrayList<>();
        for (Flat flat : house.flats) {
            stack.push(flat);
        }while (!stack.isEmpty()){
            reversedFlats.add(stack.pop());
        }

        return reversedFlats;
    }
    
    public static void main(String[] args) {
        List<House> houses = HouseGenerator.generateHouses(2);

        System.out.println("\nВсе квартиры: " + getAllFlats(houses));
        System.out.println("\nУникальные цвета комнат: " + getUniqueRoomColors(houses).size());
//        for (House house : houses) {
//            for (Flat flat : house.flats) {
//                for (Room room : flat.roomList) {
//                    System.out.println("квартира № "+flat.flatnumber+" с "+flat.roomList.size()+" комнатами с цветами: "+room.color);
//                }
//            }
//        }
        System.out.println("\nКвартиры по этажам: " + getFlatsCountByFloor(houses.get(0)));

        System.out.println("\n"+houses);
        System.out.println("\nНомера квартир по порядку: " + getFlatNumbersInOrder(houses.get(0)));
        System.out.println("\nКвартиры в обратном порядке: " + getFlatsInReverseOrder(houses.get(0)));
    }
}
