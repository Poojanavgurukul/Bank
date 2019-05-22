package bank;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class AccountBalanceTest {
    @Test
    public void shouldGiveBalance() {
        Account ankita = new Account("ankita", "123", 0, new Date(2019, 5, 21));
        assertEquals(0.0, ankita.getBalance(), 1);
    }

    @Test
    public void shouldCredit() {
        Account pooja = new Account("pooja", "124", 0, new Date(2019, 5, 21));
        pooja.credit(50);
        assertEquals(50.0, pooja.getBalance(), 0.1);
    }

    @Test
    public void shouldDebit() {
        Account pooja = new Account("pooja", "124", 100.0, new Date(2019, 5, 21));
        pooja.debit(50);
        assertEquals(50.0, pooja.getBalance(), 1);
    }
    @Test
    public void amountShouldNotChange() {
        Account shipi = new Account("shipi", "126", 100, new Date(2019, 5, 21));
        shipi.debit(10);
        shipi.credit(10);
        assertEquals(100, shipi.getBalance(), 1);
    }

    @Test
    public void creditOfOneAccountShouldNotAffectOther() {
        Account icici = new Account("diva", "127", 101, new Date(2019, 5, 21));
        icici.credit(10);
        Account indian = new Account("rahul", "128", 110, new Date(2019, 5, 21));
        indian.credit(11);
        assertEquals(121, indian.getBalance(), 1);
        assertEquals(111, icici.getBalance(), 1);
    }

    @Test
    public void creditShouldNotMoreThanBalance() {
        Account komal = new Account("komal", "129", 100, new Date(2019, 5, 21));
        komal.debit(200);
        assertEquals(100, komal.getBalance(), 1);
    }
    @Test
    public void netBalanceWithSimpleInterest(){
        Account karishma = new Account("karishma","130",100,new Date(2019,5,5));
        assertEquals(100,karishma.getBalance(0),1);
        assertEquals(110,karishma.getBalance(1),1);
        assertEquals(120,karishma.getBalance(2),1);
    }
}