import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorTest {
    Author jeff;

    @Before
    public void setUp() throws Exception {
        jeff = new Author(new Person("Jeff", "Tommy"), "jefftommy@gmail.com", "Westlake");
    }

    @Test
    public void getName() throws Exception {
        assertEquals("Jeff Tommy", jeff.getName());
    }

    @Test
    public void getEmail() throws Exception {
        assertEquals("jefftommy@gmail.com", jeff.getEmail());
    }

    @Test
    public void getAddress() throws Exception {
        assertEquals("Westlake", jeff.getAddress());
    }
}