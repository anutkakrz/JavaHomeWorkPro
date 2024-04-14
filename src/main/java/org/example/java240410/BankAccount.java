package org.example.java240410;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BankAccount {
    private Currency currency;
    private int balance;
    private int accountNumber;

    public BankAccount(Currency currency, int balance, int accountNumber, int i) {
    }

    @Override
    public String toString() {
        return "Account{" +
                "currency=" + currency +
                ", balance=" + balance +
                ", accountNumber=" + accountNumber +
                '}';
    }
}

