import main.java.bank.Account;

public class Client {
    public static void main(String[] args) {
        Account Pooja =new Account("pooja","1223",0);
        Pooja.credit(100);
        Pooja.debit(20);
        System.out.println(Pooja.getBalance());
    }
}
