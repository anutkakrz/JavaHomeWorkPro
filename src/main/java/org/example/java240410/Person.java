package org.example.java240410;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@AllArgsConstructor
 @Setter
 @Getter
public class Person {
    private String name;
    private String LastName;
    private Address address;
    private int salary;
    private Car car;
    private BankAccount[] bankAccounts;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", LastName='" + LastName + '\'' +
                ", address=" + address +
                ", salary=" + salary +
                ", car=" + car +
                ", bankAccounts=" + Arrays.toString(bankAccounts) +
                '}';
    }
}
