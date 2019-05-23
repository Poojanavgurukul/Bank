package bank;

import java.util.Date;
import java.util.Objects;

public class Transaction {
    public String number;
    public Date transactionDate;
    public double amount;

    public Transaction(String number, Date transactionDate, double amount) {
        this.number = number;
        this.transactionDate = transactionDate;
        this.amount = amount;
    }

    public String toString() {
        return "Transaction{" +
                "number='" + number + '\'' +
                ", transactionDate=" + transactionDate +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.amount, amount) == 0 &&
                Objects.equals(number, that.number) &&
                Objects.equals(transactionDate, that.transactionDate);
    }
}
