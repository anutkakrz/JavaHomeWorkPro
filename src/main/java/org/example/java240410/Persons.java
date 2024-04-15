package org.example.java240410;

import com.github.javafaker.Faker;

import java.util.*;


public class Persons {

    public static List<Person> getListPersons(int numPers) {
        List<Person> persons = new ArrayList<>(numPers);
        Faker faker = new Faker();
        Random random = new Random();
        List<BrandCar> BrandCars = new ArrayList<>();
        List<Country> countries = new ArrayList<>();
        List<Color> colors = new ArrayList<>();

        BrandCars.add(BrandCar.PORSCHE);
        BrandCars.add(BrandCar.AUDI);
        BrandCars.add(BrandCar.BMW);
        BrandCars.add(BrandCar.LADA);
        BrandCars.add(BrandCar.NISSAN);

        countries.add(Country.UKRAINE);
        countries.add(Country.GERMANY);
        countries.add(Country.USA);
        countries.add(Country.JAPAN);
        countries.add(Country.SPAIN);

        colors.add(Color.BLUE);
        colors.add(Color.ROSE);
        colors.add(Color.RED);
        colors.add(Color.WHITE);
        colors.add(Color.BLACK);


//        Country[] countries = Country.values();
//        BrandCar[] brandCars = BrandCar.values();
//        Color[] colors = Color.values();


        for (int i = 0; i < numPers; i++) {
            int randomIntColor = random.nextInt(colors.size());
            int randomIndBrandCar = random.nextInt(BrandCars.size());
            int randomIndexCountry = random.nextInt(countries.size());

            persons.add(new Person(faker.name().name(),
                    faker.name().name(),
                    new Address(countries.get(randomIndexCountry),
                            faker.address().streetAddress(),
                            faker.address().buildingNumber(),
                            faker.number().numberBetween(0, 250)),
                    random.nextInt(1000, 95000),
                    new Car(BrandCars.get(randomIndBrandCar),
                            faker.number().numberBetween(1, 6),
                            faker.bool().bool(),
                            faker.number().numberBetween(100, 1000),
                            faker.number().numberBetween(1000, 300000),
                            faker.number().numberBetween(1999, 2025),
                            colors.get(randomIntColor)),
                    getBankAccounts(faker.number().numberBetween(1, 5))));

        }
        return persons;
    }

    public static List<BankAccount> getBankAccounts(int num) {
        List<BankAccount> bankAccounts = new ArrayList<>(num);
        List<Currency> currencies = new ArrayList<>();
        currencies.add(Currency.AUD);
        currencies.add(Currency.CAD);
        currencies.add(Currency.EUR);
        currencies.add(Currency.GBR);
        currencies.add(Currency.USD);

        Random random = new Random();
        Faker faker = new Faker();

        for (int i = 0; i < num; i++) {
            int randomIntAcc = random.nextInt( currencies.size());
           bankAccounts.add(new BankAccount( currencies.get(randomIntAcc),
                    faker.number().numberBetween(1, 1000000),
                    faker.number().numberBetween(100000000, 999999999)));
        }
        return bankAccounts;
    }
}




