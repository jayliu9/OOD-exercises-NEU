package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTest {
    Time timeIsValid;
    Time tooManyHour;
    Time tooFewHour;
    Time tooManyMin;
    Time tooFewSec;

    @Before
    public void setUp() throws Exception {
        timeIsValid = new Time(15, 45, 29);
        tooManyHour = new Time(30, 30, 30);
        tooFewHour = new Time(-5, 30, 30);
        tooManyMin = new Time(15, 80, 30);
        tooFewSec = new Time(15,30,-25);
    }

    @Test
    public void getHour() throws Exception {
        assertEquals(15, timeIsValid.getHour());
    }

    @Test
    public void getMinutes() throws Exception {
        assertEquals(45, timeIsValid.getMinutes());
    }

    @Test
    public void getSeconds() throws Exception {
        assertEquals(29, timeIsValid.getSeconds());
    }

    @Test
    public void setHour() throws Exception {
        timeIsValid.setHour(20);
        assertEquals(20, timeIsValid.getHour());
    }

    @Test
    public void setMinutes() throws Exception {
        timeIsValid.setMinutes(25);
        assertEquals(25, timeIsValid.getMinutes());
    }

    @Test
    public void setSeconds() throws Exception {
        timeIsValid.setSeconds(35);
        assertEquals(35, timeIsValid.getSeconds());
    }

    @Test
    public void validateHour() throws Exception {
        assertEquals(0, tooManyHour.getHour());
        assertEquals(0, tooFewHour.getHour());
    }

    @Test
    public void validateMinOrSec() throws Exception {
        assertEquals(0, tooManyMin.getMinutes());
        assertEquals(0, tooFewSec.getSeconds());
    }
}