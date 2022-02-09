package problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AmountTest {
    Amount validAmount;
    Amount tooManyDollar;
    Amount tooManyCent;
    Amount negativeCent;

    @Before
    public void setUp() throws Exception {
        validAmount = new Amount(100, 50);
        tooManyDollar = new Amount(-25,75);
        tooManyCent = new Amount(37,100);
        negativeCent = new Amount(81, -5);
    }

    @Test
    public void getDollar() {
        assertEquals(100, validAmount.getDollar());
    }

    @Test
    public void getCent() {
        assertEquals(50, validAmount.getCent());
    }

    @Test
    public void changeDollar() {
        Amount newAmount = validAmount.changeDollar(66);
        assertEquals(66, newAmount.getDollar());
        assertEquals(50, newAmount.getCent());
    }

    @Test
    public void changeCent() {
        Amount newAmount = validAmount.changeCent(77);
        assertEquals(100, newAmount.getDollar());
        assertEquals(77, newAmount.getCent());
    }

    @Test
    public void invalidDollar() {
        assertEquals(0, tooManyDollar.getDollar());
    }

    @Test
    public void invalidCent() {
        assertEquals(0, tooManyCent.getCent());
        assertEquals(0, negativeCent.getCent());
    }
}