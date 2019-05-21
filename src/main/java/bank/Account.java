package main.java.bank;

public class Account {
    String holderName;
    String number;
    private double balance;

    public Account(String holderName, String number, double balance) {
        this.holderName = holderName;
        this.number = number;
        this.balance = balance;
    }
    public void credit(int amount){
        balance+=amount;
    }

    public double getBalance() {
        return balance;
    }
    public void debit(int amount){
        if(amount<0){}
        else {
            balance-=amount;
        }
    }
}
