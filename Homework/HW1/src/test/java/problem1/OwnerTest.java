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
    public void getFirstName() throws Exception {
        assertEquals("Harry", harry.getFirstName());
    }

    @Test
    public void getLastName() throws Exception {
        assertEquals("Potter", harry.getLastName());
    }

    @Test
    public void getPhoneNumber() throws Exception {
        assertEquals("8866442200", harry.getPhoneNumber());
    }

    @Test
    public void setFirstName() throws Exception {
        harry.setFirstName("ABC");
        assertEquals("ABC", harry.getFirstName());
    }

    @Test
    public void setLastName() throws Exception {
        harry.setLastName("CDE");
        assertEquals("CDE", harry.getLastName());
    }

    @Test
    public void setPhoneNumber() throws Exception {
        harry.setPhoneNumber("2468008642");
        assertEquals("2468008642", harry.getPhoneNumber());
    }

    @Test
    public void validatePhoneNum() throws Exception {
        assertEquals("0000000000", invalidNum.getPhoneNumber());
    }
}