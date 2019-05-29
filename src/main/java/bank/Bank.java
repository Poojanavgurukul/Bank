package bank;


public class Bank {
    public static void main(String[] args) {
        System.out.println(Bank.createAccount("ankita"));
    }

    private static int numberOfAccounts =0;
    public static Account createAccount(String name){
        numberOfAccounts++;
        return new Account(name,Integer.toString(numberOfAccounts),0);
    }
}
