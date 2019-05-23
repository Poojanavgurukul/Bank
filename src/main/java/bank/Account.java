package bank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    String holderName;
    String number;
    private double balance;
    private Date openingDate;
    public final int RATE_OF_INTEREST_PER_ANNUM = 10;
    private final List<Transaction> passbook = new ArrayList<>();


    public Account(String holderName, String number, double balance, Date openingDate) {
        this.holderName = holderName;
        this.number = number;
        this.balance = balance;
        this.openingDate = openingDate;
    }

    @Override
    public String toString() {
        return holderName + ":" + number + ":" + balance;
    }

    public void credit(double amount, Date date) {
        Transaction credit = new Transaction(number, date, amount);
        passbook.add(credit);
        this.balance += amount;
    }

    public void debit(double amount, Date date) {
        Transaction debit = new Transaction(number, date, -amount);
        if (amount < balance) {
            passbook.add(debit);
            this.balance -= amount;
        }
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

