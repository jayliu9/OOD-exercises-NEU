package problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    Account testedAccount;

    @Before
    public void setUp() throws Exception {
        Name holder = new Name("Harry", "Potter");
        Amount balance = new Amount(123, 45);
        testedAccount = new Account(holder, balance);
    }

    @Test
    public void getHolder() {
        assertEquals("Harry", testedAccount.getHolder().getFirstName());
        assertEquals("Potter", testedAccount.getHolder().getLastName());
    }


    @Test
    public void getAccountBalance() {
        assertEquals(123, testedAccount.getAccountBalance().getDollar());
        assertEquals(45, testedAccount.getAccountBalance().getCent());
    }

    @Test
    public void changeFirstName() {
        Name newHolder = new Name("James", "Bond");
        Account newAccount = testedAccount.changeHolder(newHolder);
        assertEquals("James", newAccount.getHolder().getFirstName());
        assertEquals("Bond", newAccount.getHolder().getLastName());
        assertEquals(123, newAccount.getAccountBalance().getDollar());
        assertEquals(45, newAccount.getAccountBalance().getCent());
    }


    @Test
    public void changeAccountBalance() {
        Amount newBalance = new Amount(246, 88);
        Account newAccount = testedAccount.changeAccountBalance(newBalance);
        assertEquals("Harry", newAccount.getHolder().getFirstName());
        assertEquals("Potter", newAccount.getHolder().getLastName());
        assertEquals(246, newAccount.getAccountBalance().getDollar());
        assertEquals(88, newAccount.getAccountBalance().getCent());
    }

    @Test
    public void deposit() {
        Amount moneyToAdd = new Amount(100,50);
        Account newAccount = testedAccount.deposit(moneyToAdd);
        assertEquals("Harry", newAccount.getHolder().getFirstName());
        assertEquals("Potter", newAccount.getHolder().getLastName());
        assertEquals(223, newAccount.getAccountBalance().getDollar());
        assertEquals(95, newAccount.getAccountBalance().getCent());
    }

    @Test
    public void withdraw() {
        Amount moneyToDraw = new Amount(100,50);
        Account newAccount = testedAccount.withdraw(moneyToDraw);
        assertEquals("Harry", newAccount.getHolder().getFirstName());
        assertEquals("Potter", newAccount.getHolder().getLastName());
        assertEquals(22, newAccount.getAccountBalance().getDollar());
        assertEquals(95, newAccount.getAccountBalance().getCent());
    }
}