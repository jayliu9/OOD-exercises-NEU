package problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NameTest {
    Name testedName;

    @Before
    public void setUp() throws Exception {
        testedName = new Name("Abc", "Efg");
    }

    @Test
    public void getFirstName() {
        assertEquals("Abc", testedName.getFirstName());
    }

    @Test
    public void setFirstName() {
        testedName.setFirstName("Lmn");
        assertEquals("Lmn", testedName.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Efg", testedName.getLastName());
    }

    @Test
    public void setLastName() {
        testedName.setLastName("Opq");
        assertEquals("Opq", testedName.getLastName());
    }
}