package bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AccountBalanceTest {

    public static final Date TODAY = new Date(2019, 5, 22);

    @Test
    public void shouldGiveBalance() {
        Account ankita = new Account("ankita", "123", 0);
        assertEquals(0.0, ankita.getBalance(), 1);
    }

    @Test
    public void shouldCredit() {
        Account pooja = new Account("pooja", "124", 0);
        pooja.credit(50, new Date(2019, 5, 22));
        assertEquals(50.0, pooja.getBalance(), 0.1);
    }

    @Test
    public void shouldDebit() {
        Account pooja = new Account("pooja", "124", 100.0);
        pooja.debit(50, new Date(2019, 5, 22));
        assertEquals(50.0, pooja.getBalance(), 1);
    }

    @Test
    public void amountShouldNotChange() {
        Account shipi = new Account("shipi", "126", 100);
        shipi.debit(10, new Date(2019, 5, 22));
        shipi.credit(10, new Date(2019, 5, 22));
        assertEquals(100, shipi.getBalance(), 1);
    }

    @Test
    public void creditOfOneAccountShouldNotAffectOther() {
        Account icici = new Account("diva", "127", 101);
        icici.credit(10, new Date(2019, 5, 22));
        Account indian = new Account("rahul", "128", 110);
        indian.credit(11, new Date(2019, 5, 22));
        assertEquals(121, indian.getBalance(), 1);
        assertEquals(111, icici.getBalance(), 1);
    }

    @Test
    public void creditShouldNotMoreThanBalance() {
        Account komal = new Account("komal", "129", 100);
        komal.debit(200, new Date(2019, 5, 22));
        assertEquals(100, komal.getBalance(), 1);
    }

    @Test
    public void netBalanceWithSimpleInterest() {
        Account karishma = new Account("karishma", "130", 100);
        assertEquals(100, karishma.getBalance(0), 1);
        assertEquals(110, karishma.getBalance(1), 1);
        assertEquals(120, karishma.getBalance(2), 1);
    }

    @Test
    public void noTransactionThenPassbookShouldBeEmpty() {
        List<Integer> passbook = new ArrayList<>();
        Account krish = new Account("krish", "131", 0.0);
        assertEquals(passbook, krish.getPassbook());
    }

    @Test
    public void creditShouldBeShownInTransaction() {
        Account ankita = new Account("ankita", "132", 0.0);
        List<Transaction> expectedPassbook = new ArrayList<>();
        Transaction credit = new Transaction("132", TODAY, 10);
        expectedPassbook.add(credit);
        ankita.credit(10, TODAY);
        assertEquals(expectedPassbook, ankita.getPassbook());
    }

    @Test
    public void debitShouldShowInTransaction() {
        Account divya = new Account("divya", "133", 100.0);
        List<Transaction> expectedPassbook = new ArrayList<>();
        Transaction debit = new Transaction("133", TODAY, -10);
        expectedPassbook.add(debit);
        divya.debit(10, TODAY);
        assertEquals(expectedPassbook, divya.getPassbook());
    }

    @Test
    public void debitShouldNotBeDoneIfBalanceIsInsufficient() {
        Account naresh = new Account("naresh", "134", 0.0);
        List<Transaction> expectedEmptyPassbook = new ArrayList<>();
        naresh.debit(100, TODAY);
        assertEquals(expectedEmptyPassbook, naresh.getPassbook());
    }

    @Test
    public void multipleTranscationShouldBeDone() {
        Account komal = new Account("komal", "135", 1000.0);
        komal.debit(50, TODAY);
        komal.credit(100, TODAY);
        List<Transaction> expectedPassbook = new ArrayList<>();
        Transaction credit = new Transaction("135", TODAY, 100);
        Transaction debit = new Transaction("135", TODAY, -50);
        expectedPassbook.add(debit);
        expectedPassbook.add(credit);
        assertEquals(expectedPassbook, komal.getPassbook());
    }
    @Test
    public void test(){
        Account komal = new Account("komal", "136", 1000.0);
        komal.credit(50,TODAY).debit(100,TODAY);
        assertEquals(950,komal.getBalance(),1);
    }
    @Test
    public void shouldBeAbleToDoMultipleCreditInOneAccount(){
        Account komal = new Account("komal", "137", 1000.0);
        komal.credit(50,TODAY).credit(50,TODAY);
        assertEquals(1100,komal.getBalance(),1);
    }
    @Test
    public void shouldBeAbleToDoMultipleDebitCredit(){
        Account komal = new Account("komal", "138", 1000.0);
        komal.credit(50,TODAY).credit(50,TODAY).debit(100,TODAY).debit(100,TODAY);
        assertEquals(900,komal.getBalance(),1);
    }
}