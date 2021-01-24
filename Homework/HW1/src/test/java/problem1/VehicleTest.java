package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleTest {
    Vehicle car;

    @Before
    public void setUp() throws Exception {
        car = new Vehicle(22446688, "CD2468", new Owner("Harry", "Potter", "9876543210"));
    }

    @Test
    public void getVIN() throws Exception {
        assertEquals((Integer) 22446688, car.getVIN());
    }

    @Test
    public void getLicensePlate() throws Exception {
        assertEquals("CD2468", car.getLicensePlate());
    }

    @Test
    public void getVehicleOwner() throws Exception {
        assertEquals("9876543210", car.getVehicleOwner().getPhoneNumber());
        assertEquals("Harry", car.getVehicleOwner().getFirstName());
        assertEquals("Potter", car.getVehicleOwner().getLastName());
    }

    @Test
    public void setVIN() throws Exception {
        car.setVIN(88664422);
        assertEquals((Integer) 88664422, car.getVIN());
    }

    @Test
    public void setLicensePlate() throws Exception {
        car.setLicensePlate("GH8642");
        assertEquals("GH8642", car.getLicensePlate());
    }
}