//package org.example.java240410;
//
//import com.github.javafaker.Faker;
//
//import java.util.Random;
//
//
//public class Persons {
//
//    public static Person[] getArrayPersons(int numPers) {
//        Person[] persons = new Person[numPers];
//        Faker faker = new Faker();
//        Random random = new Random();
//        Country[] countries = Country.values();
//        BrandCar[] brandCars = BrandCar.values();
//        Color[] colors = Color.values();
//
//
//        for (int i = 0; i < persons.length; i++) {
//            int randomIntColor = random.nextInt(colors.length);
//            int randomIndBrandCar = random.nextInt(brandCars.length);
//            int randomIndexCountry = random.nextInt(countries.length);
//
//            persons[i] = new Person(faker.funnyName().name(),
//                    faker.funnyName().name(),
//                    new Address(countries[randomIndexCountry],
//                            faker.address().streetAddress(),
//                            faker.address().buildingNumber(),
//                            faker.number().numberBetween(0, 250)),
//                    random.nextInt(1000,25000),
//                    new Car(brandCars[randomIndBrandCar],
//                            faker.number().numberBetween(1, 6),
//                            faker.bool().bool(),
//                            faker.number().numberBetween(100, 1000),
//                            faker.number().numberBetween(1000, 300000),
//                            faker.number().numberBetween(1999, 2025),
//                            colors[randomIntColor]),
//                    getBankAccounts(faker.number().numberBetween(1,5)));
//
//        }
//        return persons;
//    }
//    public static BankAccount[] getBankAccounts(int num){
//        BankAccount[] bankAccounts = new BankAccount[num];
//        Currency[] currencies = Currency.values();
//        Random random = new Random();
//        Faker faker = new Faker();
//
//        for (int i = 0; i < bankAccounts.length; i++) {
//            int randomIntAcc = random.nextInt(currencies.length);
//            bankAccounts[i] = new BankAccount(currencies[randomIntAcc],
//                    faker.number().numberBetween(1, 1000000),
//                    faker.number().numberBetween(100000000, 999999999));
//        }
//        return  bankAccounts;
//    }
//}

