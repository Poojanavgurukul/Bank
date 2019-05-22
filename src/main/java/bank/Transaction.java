package bank;

import java.util.Date;

public class Transaction {
    public String number;
    public Date transactionDate;
    public double amount;

    public Transaction(String number, Date transactionDate, double amount) {
        this.number = number;
        this.transactionDate = transactionDate;
        this.amount = amount;
    }
}
