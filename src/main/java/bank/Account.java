package bank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    String holderName;
    String number;
    private double balance;
    private LocalDate openingDate = LocalDate.now();
    public final int RATE_OF_INTEREST_PER_ANNUM = 10;
    private final List<Transaction> passbook = new ArrayList<>();


    public Account(String holderName, String number, double balance) {
        this.holderName = holderName;
        this.number = number;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return holderName + ":" + number + ":" + balance;
    }

    public Account credit(double amount, Date date) {
        Transaction credit = new Transaction(number, date, amount);
        passbook.add(credit);
        this.balance += amount;
        return this;
    }

    public Account debit(double amount, Date date) {
        Transaction debit = new Transaction(number, date, -amount);
        if (amount < balance) {
            passbook.add(debit);
            this.balance -= amount;
        }
        return this;
    }

    public double getBalance() {
        return getBalance(0);
    }

    public double getBalance(int year) {
        double interest = (RATE_OF_INTEREST_PER_ANNUM * year * balance) / 100;
        double netAmount = interest + balance;
        return netAmount;
    }

    public List<Transaction> getPassbook() {
        return passbook;
    }

}

