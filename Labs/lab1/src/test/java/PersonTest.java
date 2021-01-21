import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    private Person harry;

    @Before
    public void setUp() throws Exception {
        harry = new Person("Harry", "Potter");
    }

    @Test
    public void getFirstName() {
        assertEquals("Harry", harry.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Potter", harry.getLastName());
    }
}