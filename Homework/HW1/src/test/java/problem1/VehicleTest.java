package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleTest {
    Vehicle aCar;

    @Before
    public void setUp() throws Exception {
        aCar = new Vehicle(22446688, "CD2468");
    }

    @Test
    public void getVIN() throws Exception {
        assertEquals((Integer) 22446688, aCar.getVIN());
    }

    @Test
    public void getLicensePlate() throws Exception {
        assertEquals("CD2468", aCar.getLicensePlate());
    }

    @Test
    public void setVIN() throws Exception {
        aCar.setVIN(88664422);
        assertEquals((Integer) 88664422, aCar.getVIN());
    }

    @Test
    public void setLicensePlate() throws Exception {
        aCar.setLicensePlate("GH8642");
        assertEquals("GH8642", aCar.getLicensePlate());
    }
}