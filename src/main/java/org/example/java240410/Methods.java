package org.example.java240410;

import java.time.Year;
import java.util.List;

public class Methods {

    public static void printAllPersons(List<Person> persons) {
        for (Person person : persons) {
            System.out.println(person + "\n");
        }
    }

    //    Вывести имена и фамилии всех лиц, чьи автомобили не красные и не спортивные.
    public static void printNameNoRedCar(List<Person> persons) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getCar().getColor() != Color.RED
                    && !persons.get(i).getCar().isSport()) {
                System.out.print("Владелец не спортивного не красного авто: " + persons.get(i).getName()
                        + " " + persons.get(i).getLastName() + " владеет автомобилем: " +
                        persons.get(i).getCar().getBrandCar() + " c атрибутом спорт = " +
                        persons.get(i).getCar().isSport() + " " + persons.get(i).getCar().getColor() + " - цвет "+ " \n");

            }
        }
    }


  //    Найти и вывести среднюю зарплату всех лиц, проживающих в определенной стране.
    public static void getAverageSalaryFromCountry(List<Person> persons, Country country) {
        int count = 0;
        int sumSalary = 0;
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getAddress().getCountry() == country) {
                sumSalary += persons.get(i).getSalary();
                count++;
            }
        }
        System.out.println("средняя зарплата в " + country + " = " + (count > 0 ? sumSalary / count : count) + " \n");
    }

    //    Вывести информацию о всех лицах, у которых счет в определенной валюте превышает заданный баланс.
    public static void getPersonOrderWithCurrencyAndBalance(List<Person> persons, Currency currency, int balance) {
        for (Person person : persons) {
            for (BankAccount bankAccount : person.getBankAccounts()) {
                if (bankAccount.getCurrency() == currency && bankAccount.getBalance() > balance) {
                    System.out.println("владелец счета в " + currency + " с баланосом более: " + balance + " "
                            + person +" \n");
                }
            }
        }
    }

    //    Перечислить всех, у кого автомобиль был выпущен до определенного года.
    public static void getPersonCarYear(List<Person> persons, int year) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getCar().getYearProduce() < year) {
                System.out.println("владелец с автомобилем до " + year + " года выпуска: "
                        + persons.get(i).getLastName() + " владелец авто: " + persons.get(i).getCar().getBrandCar() +
                        " выпущенного в " + persons.get(i).getCar().getYearProduce() + " году \n");
            }
        }
    }

//    //    Найти лиц, живущих на одной улице, но в разных домах.
////    public static void getPersonSameStreetsDifferentHouses(List<Person> personList) {
////        int count = 0;
////        int x=0;
////        int y = 0;
////        for (int i = 0; i < persons.length; i++) {
////            for (int j = 1; j < persons.length; j++) {
//////                if (persons[i].getAddress().getStreet().equals(persons[j].getAddress().getNumberHouse()))
////                if (persons[i].getAddress().getCountry().equals(persons[j].getAddress().getCountry()))
////                {
////                    x = i;
////                    y = j;
////                    count++;
////                }
////            }
////        }
////        System.out.println("Люди живущие на одной улице но в разных домах: "
////                + (count > 0 ? persons[x] + " \n" + persons[y] + " \n" : " такие совпадения отсутствуют"));
////    }

    //    Вывести список всех лиц без автомобилей (предполагая, что авто может быть null).
    public static void getPersonsWithoutCar(List<Person> persons) {
        for (Person person : persons)
            if (person.getCar().equals(null))
                System.out.println("у данной персоны отсутствует автомобиль: " + person + " \n");
    }
//    Определить количество лиц, имеющих спортивный автомобиль с мощностью более 300 л.с.

    public static void getPersonSportCarPower300(List<Person> persons) {
        for (Person person : persons)
            if (person.getCar().isSport() && person.getCar().getPower() > 300)
                System.out.println("владелец спортивного автомобиля с мощностью более 300 л.с.: "
                        + person.getLastName() + " автомобиль " + person.getCar().getBrandCar() +
                        " спортивный: " + true + " с мощностью "
                        + person.getCar().getPower() + " л.с. \n");
    }

//    Найти и вывести имена и фамилии лиц, имеющих более одного счета (предполагая наличие списка счетов).

    public static void getPersonWithBankAccountSS(List<Person> persons) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getBankAccounts() != null) {
                System.out.println("владелец нескольких счетов: " + persons.get(i).getName() +
                        persons.get(i).getLastName() + " \n");
            }
        }
    }
//    Вывести список лиц, чьи автомобили являются наиболее мощными в своем классе (спортивные/неспортивные).

    public static void getMorePowerCarSportAndNosport(List<Person> persons) {
        int maxSport = 0;
        int maxNosport = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getCar().isSport()) {
                if (persons.get(i).getCar().getPower() > maxSport) {
                    maxSport = persons.get(i).getCar().getPower();
                    x = i;
                }
            } else if (persons.get(i).getCar().getPower() > maxNosport) {
                maxNosport = persons.get(i).getCar().getPower();
                y = i;
            }
        }
        System.out.println("макс мощность в спортивных авто у " + persons.get(x).getLastName() +
                " в автомобиле " + persons.get(x).getCar().getBrandCar() +
                " спорт: " + persons.get(x).getCar().isSport() + " с мощностью: " +
                persons.get(x).getCar().getPower() + " л.с. (" + maxSport + ")\n" + " а среди не спортивных авто, " +
                "владелец автомобиля с наибольшей мощностью: " + persons.get(y).getLastName() + " c автомобилем: " +
                persons.get(y).getCar().getBrandCar() + " который спортивный: " + persons.get(y).getCar().isSport() +
                " c мощностью: " + persons.get(y).getCar().getPower() + " л.с. (" + maxNosport + ") \n");
    }

    //    Вывести всех лиц, живущих в домах, номера которых заканчиваются на "5"
    public static void getPersonsHouses5(List<Person> persons) {
        for (Person person : persons)
            if (person.getAddress().getNumberHouse().endsWith("5")) {
                System.out.println("Персона проживающая в доме с окончанием 5: " +
                        person.getLastName() + " дом: " + person.getAddress().getNumberHouse());
            }
    }

    //    Найти лиц с автомобилями определенной марки и цвета.
    public static void getPersonsWithBrandAndColorCar(List<Person> persons, BrandCar brandCar, Color color) {
        for (Person person : persons) {
            if (person.getCar().getBrandCar().equals(brandCar) &&
                    person.getCar().getColor().equals(color)) {
                System.out.println("Владелец автомобиля с заданными параметрами: "
                        + brandCar + ", " + color + " -" + person.getLastName() + " с автомобилем: "
                        + person.getCar().getBrandCar() + " цвет авто: " + person.getCar().getColor() + " \n");
            }
        }
    }
//    Вывести имена лиц, у которых зарплата выше среднего по массиву.

    public static void getAboveAverageSalary(List<Person> persons) {
        int count = 0;
        int sumSalary = 0;
        for (int i = 0; i < persons.size(); i++) {
            sumSalary += persons.get(i).getSalary();
            count++;
        }
        for (Person person : persons) {
            if (person.getSalary() > sumSalary / count)
                System.out.println("у данной персоны: " + person.getLastName() + " зарплата: " +
                        "" + person.getSalary() + " выше средней: " + sumSalary / count + " \n");
        }
    }

//    Определить лиц с наибольшим балансом на счету.

    public static void getPersonMaxBalance(List<Person> persons) {
        int maxBalance = 0;
        for (Person person : persons) {
            for (BankAccount bankAccount : person.getBankAccounts()) {
                if (bankAccount.getBalance() > maxBalance) {
                    maxBalance = bankAccount.getBalance();
                }
            }
        }
        for (Person person : persons) {
            for (BankAccount bankAccount : person.getBankAccounts()) {
                if (bankAccount.getBalance() == maxBalance) {
                    System.out.println("наибольший баланс у " + person.getLastName() +
                            " сумма на счету: " + maxBalance + " \n");

                }
            }

        }

    }
//    Вывести список лиц, чьи автомобили были куплены новыми (год выпуска авто равен текущему году).

    public static void getPersonsWithNewCar(List<Person> persons) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getCar().getYearProduce() == Year.now().getValue()) {
                System.out.println(persons.get(i).getLastName() + " - это владелец автомобиля: "
                        + persons.get(i).getCar().getBrandCar() + " выпущенного в текущем году ("
                        + persons.get(i).getCar().getYearProduce() + ") \n");
            }

        }
    }

    //    Найти лиц, у которых есть автомобиль определенного цвета, но не спортивный.
    public static void getPersonColorAndNoSportCar(List<Person> persons, Color color) {
        for (int i = 0; i < persons.size(); i++) {
            if ((persons.get(i).getCar().getColor() == color) && (!persons.get(i).getCar().isSport())) {
                System.out.print("Владелец не спортивного  авто, заданного " + color + " цвета: "
                        + persons.get(i).getLastName() + " владеет автомобилем: " +
                        persons.get(i).getCar().getBrandCar() + " c атрибутом спорт = " +
                        persons.get(i).getCar().isSport() + " " + persons.get(i).getCar().getColor() + " - цвет \n");

            }
        }

    }
//    Вывести список лиц, проживающих в квартирах (номер квартиры не равен 0).

    public static void getPersonsApartmentDwellers(List<Person> persons) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getAddress().getNumberFlat() != 0) {
                System.out.println("данный человек: " + persons.get(i).getLastName() + " проживает в квартире," +
                        "номер: " + persons.get(i).getAddress().getNumberFlat() + "\n");
            }

        }
    }

    //    Найти и вывести лиц, чьи автомобили имеют стоимость выше заданной.
    public static void getPersonsWithPriceAbove(List<Person> persons, int price) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getCar().getPrice() > price)
                System.out.println("этот человек: " + persons.get(i).getLastName() +
                        " владеет автомобилем который стоит: " + persons.get(i).getCar().getPrice() +
                        ", что больше заявленной стоимости: " + price + "\n");
        }
    }
//    Вывести имена и фамилии всех лиц, чьи автомобили имеют четное количество дверей.

    public static void getPersonsWithCarEvenDoors(List<Person> persons) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getCar().getQuantityDoors() % 2 == 0)
                System.out.println("владелец: " + persons.get(i).getName() + " " + persons.get(i).getLastName() +
                        " автомобиля с четным колличством дверей: " + persons.get(i).getCar().getQuantityDoors() + " \n");

        }
    }

    //    Определить и вывести лицо, имеющего счет с наименьшим балансом.
    public static void getPersonMinBalance(List<Person> persons) {
        int minBalance = Integer.MAX_VALUE;
        for (Person person : persons) {
            for (BankAccount bankAccount : person.getBankAccounts()) {
                if (bankAccount.getBalance() < minBalance) {
                    minBalance = bankAccount.getBalance();
                }
            }
        }
        for (Person person : persons) {
            for (BankAccount bankAccount : person.getBankAccounts()) {
                if (bankAccount.getBalance() == minBalance) {
                    System.out.println("наименьший баланс у " + person.getLastName() +
                            " сумма на счету: " + minBalance + " \n");
                }
            }
        }
    }
//    Вывести список лиц, имеющих автомобили, которые стоят дороже их зарплаты.
    public static void getPersonsWithCarExpensiveSalary (List<Person> persons) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getCar().getPrice()>persons.get(i).getSalary())
                System.out.println(persons.get(i).getLastName()+" - это владелец автомобиля," +
                        "стоимость которого: "+persons.get(i).getCar().getPrice()+" - больще зарплаты: "+
                        persons.get(i).getSalary()+" \n");

        }
    }
//    Найти лиц, проживающих не в своей стране (предполагая, что есть поле гражданства в классе Person).

}





