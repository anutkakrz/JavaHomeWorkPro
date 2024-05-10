package org.example.java240410;
import org.example.java240410.Persons;

import java.util.List;

import static org.example.java240410.BrandCar.AUDI;
import static org.example.java240410.Color.RED;
import static org.example.java240410.Color.WHITE;
import static org.example.java240410.Country.JAPAN;
import static org.example.java240410.Country.UKRAINE;
import static org.example.java240410.Currency.EUR;

public class ToWork {
    public static void main(String[] args) {
       List<Person> persons = Persons.getListPersons(10);
       Methods.printAllPersons(persons);
        Methods.printNameNoRedCar(persons);
        Methods.getAverageSalaryFromCountry(persons, UKRAINE);
        Methods.getPersonOrderWithCurrencyAndBalance(persons, EUR, 600000);
        Methods.getPersonCarYear(persons,2005);
//        Methods.getPersonSameStreetsDifferentHouses(persons);
        Methods.getPersonsWithoutCar(persons);
        Methods.getPersonSportCarPower300(persons);
        Methods.getPersonWithBankAccountSS(persons);
        Methods.getMorePowerCarSportAndNosport(persons);
        Methods.getPersonsHouses5(persons);
        Methods.getPersonsWithBrandAndColorCar(persons, AUDI, RED);
        Methods.getAboveAverageSalary(persons);
        Methods.getPersonMaxBalance(persons);
        Methods.getPersonsWithNewCar(persons);
        Methods.getPersonColorAndNoSportCar(persons, WHITE);
        Methods.getPersonsApartmentDwellers(persons);
        Methods.getPersonsWithPriceAbove(persons,150000);
        Methods.getPersonsWithCarEvenDoors(persons);
        Methods.getPersonMinBalance(persons);
        Methods.getPersonsWithCarExpensiveSalary(persons);

    }
}
