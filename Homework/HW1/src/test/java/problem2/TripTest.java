package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TripTest {
    Trip tripOfHarry;
    Trip invalidDurationTrip;

    @Before
    public void setUp() throws Exception {
        Time validStartingTime = new Time(9,35,49);
        Time validEndTime = new Time(22, 20,34);
        tripOfHarry = new Trip("Spain","Portugal", validStartingTime, validEndTime);
        Time laterStartingTime =  new Time(20,53,9);
        Time earlierEndTime =  new Time(20,24,55);
        invalidDurationTrip = new Trip("France", "Italy", laterStartingTime, earlierEndTime);
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

        assertEquals(0, invalidDurationTrip.getDuration().getHour());
        assertEquals(0, invalidDurationTrip.getDuration().getMinutes());
        assertEquals(0, invalidDurationTrip.getDuration().getSeconds());
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