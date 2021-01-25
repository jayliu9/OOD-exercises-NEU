package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TripTest {
    Trip tripOfHarry;
    Trip invalidStartHourTrip;
    Trip invalidStartMinTrip;
    Trip invalidStartSecTrip;
    Trip invalidEndHourTrip;
    Trip invalidEndMinTrip;
    Trip invalidEndSecTrip;
    Trip invalidDifferenceTrip;

    @Before
    public void setUp() throws Exception {
        tripOfHarry = new Trip("Spain","Portugal", new Time(9,35,49), new Time(22, 20,34));
        invalidStartHourTrip = new Trip("Spain", "Portugal", new Time(40, 33, 22), new Time(19, 32,4));
        invalidStartMinTrip = new Trip("Spain", "Portugal", new Time(11, -5, 22), new Time(19, 32,4));
        invalidStartSecTrip = new Trip("Spain", "Portugal", new Time(11, 40, 82), new Time(19, 32,4));
        invalidEndHourTrip = new Trip("Spain", "Portugal", new Time(7,22,19), new Time(-2,59,30));
        invalidEndMinTrip = new Trip("Spain", "Portugal", new Time(7,22,19), new Time(23,78,21));
        invalidEndSecTrip = new Trip("Spain", "Portugal", new Time(7,22,19), new Time(2,59,-30));
        invalidDifferenceTrip = new Trip("France", "Italy", new Time(20,53,9), new Time(20,24,55));
    }

    @Test
    public void getStartingLocation() throws Exception {
        assertEquals("Spain", tripOfHarry.getStartingLocation());
    }

    @Test
    public void getEndLocation() throws Exception {
        assertEquals("Portugal", tripOfHarry.getEndLocation());
    }

    @Test
    public void getStartTime() throws Exception {
        assertEquals(9, tripOfHarry.getStartTime().getHour());
        assertEquals(35, tripOfHarry.getStartTime().getMinutes());
        assertEquals(49, tripOfHarry.getStartTime().getSeconds());
    }

    @Test
    public void getEndTime() throws Exception {
        assertEquals(22, tripOfHarry.getEndTime().getHour());
        assertEquals(20, tripOfHarry.getEndTime().getMinutes());
        assertEquals(34,tripOfHarry.getEndTime().getSeconds());
    }

    @Test
    public void getDuration() throws Exception {
        assertEquals(12, tripOfHarry.getDuration().getHour());
        assertEquals(44, tripOfHarry.getDuration().getMinutes());
        assertEquals(45, tripOfHarry.getDuration().getSeconds());

        assertEquals(-1, invalidStartHourTrip.getDuration().getHour());
        assertEquals(-1, invalidStartHourTrip.getDuration().getMinutes());
        assertEquals(-1, invalidStartHourTrip.getDuration().getSeconds());

        assertEquals(-1, invalidStartMinTrip.getDuration().getHour());
        assertEquals(-1, invalidStartMinTrip.getDuration().getMinutes());
        assertEquals(-1, invalidStartMinTrip.getDuration().getSeconds());

        assertEquals(-1, invalidStartSecTrip.getDuration().getHour());
        assertEquals(-1, invalidStartSecTrip.getDuration().getMinutes());
        assertEquals(-1, invalidStartSecTrip.getDuration().getSeconds());

        assertEquals(-1, invalidEndHourTrip.getDuration().getHour());
        assertEquals(-1, invalidEndHourTrip.getDuration().getMinutes());
        assertEquals(-1, invalidEndHourTrip.getDuration().getSeconds());

        assertEquals(-1, invalidEndMinTrip.getDuration().getHour());
        assertEquals(-1, invalidEndMinTrip.getDuration().getMinutes());
        assertEquals(-1, invalidEndMinTrip.getDuration().getSeconds());

        assertEquals(-1, invalidEndSecTrip.getDuration().getHour());
        assertEquals(-1, invalidEndSecTrip.getDuration().getMinutes());
        assertEquals(-1, invalidEndSecTrip.getDuration().getSeconds());

        assertEquals(-1, invalidDifferenceTrip.getDuration().getHour());
        assertEquals(-1, invalidDifferenceTrip.getDuration().getMinutes());
        assertEquals(-1, invalidDifferenceTrip.getDuration().getSeconds());
    }

    @Test
    public void setStartingLocation() throws Exception {
        tripOfHarry.setStartingLocation("Sweden");
        assertEquals("Sweden", tripOfHarry.getStartingLocation());
    }

    @Test
    public void setEndLocation() throws Exception {
        tripOfHarry.setEndLocation("Greece");
        assertEquals("Greece", tripOfHarry.getEndLocation());
    }

    @Test
    public void setStartTime() throws Exception {
        tripOfHarry.setStartTime(new Time(7,10,18));

        assertEquals(7, tripOfHarry.getStartTime().getHour());
        assertEquals(10, tripOfHarry.getStartTime().getMinutes());
        assertEquals(18, tripOfHarry.getStartTime().getSeconds());

    }

    @Test
    public void setEndTime() throws Exception {
        tripOfHarry.setEndTime(new Time(21,46,1));

        assertEquals(21, tripOfHarry.getEndTime().getHour());
        assertEquals(46, tripOfHarry.getEndTime().getMinutes());
        assertEquals(1,tripOfHarry.getEndTime().getSeconds());
    }

}