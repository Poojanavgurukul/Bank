package bank;

import java.util.Date;

public class Client {

    public static void main(String[] args) {
        Account sbi= new Account("ishu","136",0.0,new Date(2019,5,23));
        sbi.credit(1000,new Date(2019,5,23));
        sbi.debit(100,new Date(2019,5,5));
        for (bank.Transaction transaction:sbi.getPassbook()) {
            System.out.println(transaction);
        }
    }
}
