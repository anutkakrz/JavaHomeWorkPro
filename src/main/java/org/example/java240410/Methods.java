package org.example.java240410;

import java.time.Year;

public class Methods {
    public static void printAllPersons(Person[] persons) {
        for (Person person : persons) {
            System.out.println(person + "\n");
        }
    }

    //    Вывести имена и фамилии всех лиц, чьи автомобили не красные и не спортивные.
    public static void printNameNoRedCar(Person[] persons) {
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getCar().getColor() != Color.RED
                    && !persons[i].getCar().isSport()) {
                System.out.print("Владелец не спортивного не красного авто: " + persons[i].getName()
                        + " " + persons[i].getLastName() + " владеет автомобилем: " +
                        persons[i].getCar().getBrandCar() + " c атрибутом спорт = " +
                        persons[i].getCar().isSport() + " " + persons[i].getCar().getColor() + " - цвет \n");

            }
        }
    }

    //    Найти и вывести среднюю зарплату всех лиц, проживающих в определенной стране.
    public static void getAverageSalaryFromCountry(Person[] persons, Country country) {
        int count = 0;
        int sumSalary = 0;
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getAddress().getCountry() == country) {
                sumSalary += persons[i].getSalary();
                count++;
            }
        }
        System.out.println("средняя зарплата в " + country + " = " + (count > 0 ? sumSalary / count : count) + " \n");
    }

    //    Вывести информацию о всех лицах, у которых счет в определенной валюте превышает заданный баланс.
    public static void getPersonOrderWithCurrencyAndBalance(Person[] persons, Currency currency, int balance) {
        for (Person person : persons) {
            for (BankAccount bankAccount : person.getBankAccounts()) {
                if (bankAccount.getCurrency() == currency && bankAccount.getBalance() > balance) {
                    System.out.println("владелец счета в " + currency + " с баланосом более: " + balance + " " + person + " \n");
                }
            }
        }
    }

    //    Перечислить всех, у кого автомобиль был выпущен до определенного года.
    public static void getPersonCarYear(Person[] persons, int year) {
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getCar().getYearProduce() < year) {
                System.out.println("владелец с автомобилем до " + year + " года выпуска: "
                        + persons[i].getLastName() + " владелец авто: " + persons[i].getCar().getBrandCar() +
                        " выпущенного в " + persons[i].getCar().getYearProduce() + " году \n");
            }
        }
    }

    //    Найти лиц, живущих на одной улице, но в разных домах.
//    public static void getPersonSameStreetsDifferentHouses(Person[] persons) {
//        int count = 0;
//        int x=0;
//        int y = 0;
//        for (int i = 0; i < persons.length; i++) {
//            for (int j = 1; j < persons.length; j++) {
////                if (persons[i].getAddress().getStreet().equals(persons[j].getAddress().getNumberHouse()))
//                if (persons[i].getAddress().getCountry().equals(persons[j].getAddress().getCountry()))
//                {
//                    x = i;
//                    y = j;
//                    count++;
//                }
//            }
//        }
//        System.out.println("Люди живущие на одной улице но в разных домах: "
//                + (count > 0 ? persons[x] + " \n" + persons[y] + " \n" : " такие совпадения отсутствуют"));
//    }

    //    Вывести список всех лиц без автомобилей (предполагая, что авто может быть null).
    public static void getPersonsWithoutCar(Person[] persons) {
        for (Person person : persons)
            if (person.getCar().equals(null))
                System.out.println("у данной персоны отсутствует автомобиль: " + person + " \n");
    }
//    Определить количество лиц, имеющих спортивный автомобиль с мощностью более 300 л.с.

    public static void getPersonSportCarPower300(Person[] persons) {
        for (Person person : persons)
            if (person.getCar().isSport() && person.getCar().getPower() > 300) {
                System.out.println("владелец спортивного автомобиля с мощностью более 300 л.с.: "
                        + person.getLastName() + " автомобиль " + person.getCar().getBrandCar() +
                        " спортивный: " + person.getCar().isSport() + " с мощностью "
                        + person.getCar().getPower() + " л.с. \n");
            }
    }

//    Найти и вывести имена и фамилии лиц, имеющих более одного счета (предполагая наличие списка счетов).

    public static void getPersonWithBankAccountSS(Person[] persons) {
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getBankAccounts() != null) {
                System.out.println("владелец нескольких счетов: " + persons[i].getName() + persons[i].getLastName() + " \n");
            }
        }
    }
//    Вывести список лиц, чьи автомобили являются наиболее мощными в своем классе (спортивные/неспортивные).

    public static void getMorePowerCarSportAndNosport(Person[] persons) {
        int maxSport = 0;
        int maxNosport = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getCar().isSport()) {
                if (persons[i].getCar().getPower() > maxSport) {
                    maxSport = persons[i].getCar().getPower();
                    x = i;
                }
            } else if (persons[i].getCar().getPower() > maxNosport) {
                maxNosport = persons[i].getCar().getPower();
                y = i;
            }
        }
        System.out.println("макс мощность в спортивных авто у " + persons[x].getLastName() +
                " в автомобиле " + persons[x].getCar().getBrandCar() +
                " спорт: " + persons[x].getCar().isSport() + " с мощностью: " +
                persons[x].getCar().getPower() + " л.с. (" + maxSport + ")\n" + " а среди не спортивных авто, " +
                "владелец автомобиля с наибольшей мощностью: " + persons[y].getLastName() + " c автомобилем: " +
                persons[y].getCar().getBrandCar() + " который спортивный: " + persons[y].getCar().isSport() +
                " c мощностью: " + persons[y].getCar().getPower() + " л.с. (" + maxNosport + ") \n");
    }

    //    Вывести всех лиц, живущих в домах, номера которых заканчиваются на "5"
    public static void getPersonsHouses5(Person[] persons) {
        for (Person person : persons)
            if (person.getAddress().getNumberHouse().endsWith("5")) {
                System.out.println("Персона проживающая в доме с окончанием 5: " +
                        person.getLastName() + " дом: " + person.getAddress().getNumberHouse());
            }
    }

    //    Найти лиц с автомобилями определенной марки и цвета.
    public static void getPersonsWithBrandAndColorCar(Person[] persons, BrandCar brandCar, Color color) {
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

    public static void getAboveAverageSalary(Person[] persons) {
        int count = 0;
        int sumSalary = 0;
        for (int i = 0; i < persons.length; i++) {
            sumSalary += persons[i].getSalary();
            count++;
        }
        for (Person person : persons) {
            if (person.getSalary() > sumSalary / count)
                System.out.println("у данной персоны: " + person.getLastName() + " зарплата: " +
                        "" + person.getSalary() + " выше средней: " + sumSalary / count + " \n");
        }
    }

//    Определить лиц с наибольшим балансом на счету.

    public static void getPersonMaxBalance(Person[] persons) {
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

    public static void getPersonsWithNewCar(Person[] persons) {
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getCar().getYearProduce() == Year.now().getValue()) {
                System.out.println(persons[i].getLastName() + " - это владелец автомобиля: "
                        + persons[i].getCar().getBrandCar() + " выпущенного в текущем году ("
                        + persons[i].getCar().getYearProduce() + ") \n");
            }

        }
    }

    //    Найти лиц, у которых есть автомобиль определенного цвета, но не спортивный.
    public static void getPersonColorAndNoSportCar(Person[] persons, Color color) {
        for (int i = 0; i < persons.length; i++) {
            if ((persons[i].getCar().getColor() == color) && (!persons[i].getCar().isSport())) {
                System.out.print("Владелец не спортивного  авто, заданного " + color + " цвета: "
                        + persons[i].getLastName() + " владеет автомобилем: " +
                        persons[i].getCar().getBrandCar() + " c атрибутом спорт = " +
                        persons[i].getCar().isSport() + " " + persons[i].getCar().getColor() + " - цвет \n");

            }
        }

    }
//    Вывести список лиц, проживающих в квартирах (номер квартиры не равен 0).

    public static void getPersonsApartmentDwellers(Person[] persons) {
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getAddress().getNumberFlat() != 0) {
                System.out.println("данный человек: " + persons[i].getLastName() + " проживает в квартире," +
                        "номер: " + persons[i].getAddress().getNumberFlat() + "\n");
            }

        }
    }

    //    Найти и вывести лиц, чьи автомобили имеют стоимость выше заданной.
    public static void getPersonsWithPriceAbove(Person[] persons, int price) {
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getCar().getPrice() > price)
                System.out.println("этот человек: " + persons[i].getLastName() +
                        " владеет автомобилем который стоит: " + persons[i].getCar().getPrice() +
                        ", что больше заявленной стоимости: " + price + "\n");
        }
    }
//    Вывести имена и фамилии всех лиц, чьи автомобили имеют четное количество дверей.

    public static void getPersonsWithCarEvenDoors(Person[] persons) {
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getCar().getQuantityDoors() % 2 == 0)
                System.out.println("владелец: " + persons[i].getName() + " " + persons[i].getLastName() +
                        " автомобиля с четным колличством дверей: " + persons[i].getCar().getQuantityDoors() + " \n");

        }
    }

    //    Определить и вывести лицо, имеющего счет с наименьшим балансом.
    public static void getPersonMinBalance(Person[] persons) {
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
    public static void getPersonsWithCarExpensiveSalary (Person[] persons) {
        for (int i = 0; i < persons.length; i++) {
            if (persons[i].getCar().getPrice()>persons[i].getSalary())
                System.out.println(persons[i].getLastName()+" - это владелец автомобиля," +
                        "стоимость которого: "+persons[i].getCar().getPrice()+" - больще зарплаты: "+
                        persons[i].getSalary()+" \n");

        }
    }
//    Найти лиц, проживающих не в своей стране (предполагая, что есть поле гражданства в классе Person).

}





