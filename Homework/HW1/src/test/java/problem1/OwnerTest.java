package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OwnerTest {
    Owner harry;
    Owner invalidNum;

    @Before
    public void setUp() throws Exception {
        harry = new Owner("Harry", "Potter", "8866442200");
        invalidNum = new Owner("Invalid", "Number", "45678");
    }

    @Test
    public void getFirstName() {
        assertEquals("Harry", harry.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Potter", harry.getLastName());
    }

    @Test
    public void getPhoneNumber() {
        assertEquals("8866442200", harry.getPhoneNumber());
    }

    @Test
    public void setFirstName() {
        harry.setFirstName("ABC");
        assertEquals("ABC", harry.getFirstName());
    }

    @Test
    public void setLastName() {
        harry.setLastName("CDE");
        assertEquals("CDE", harry.getLastName());
    }

    @Test
    public void setPhoneNumber() {
        harry.setPhoneNumber("2468008642");
        assertEquals("2468008642", harry.getPhoneNumber());
    }

    @Test
    public void validatePhoneNum() {
        assertEquals("0000000000", invalidNum.getPhoneNumber());
    }
}