package bank;

import java.util.Date;

public class Client {
    public static void main(String[] args) {
        Account pooja =new Account("ankita","1223",0, new Date(2019, 5, 21));
        pooja.credit(100);
        pooja.debit(50);
        System.out.println(pooja);
        pooja.getBalance(3);
    }
}
