package p1;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class VehicleOperatorProcessorTest {
  VehicleOperatorProcessor processor;

  List<VehicleOperator> list = new ArrayList<>();

  Vehicle vehicle1;
  Vehicle vehicle2;
  Vehicle vehicle3;
  Vehicle vehicle4;

  VehicleOperator operator1;
  VehicleOperator operator2;
  VehicleOperator operator3;

  @Before
  public void setUp() throws Exception {
    vehicle1 = new Vehicle("11", "a", "b", LocalDate.of(1985, 2, 1), 100.0f);
    vehicle2 = new Vehicle("22", "a", "c", LocalDate.of(1982, 5, 1), 200.0f);
    vehicle3 = new Vehicle("88", "a", "b", LocalDate.of(1987, 8, 5), 155.5f);
    vehicle4 = new Vehicle("99", "c", "d", LocalDate.of(1994, 3, 10), 430.0f);

    List<Vehicle> vehicles1 = new ArrayList<>();
    vehicles1.add(vehicle1);
    vehicles1.add(vehicle2);
    vehicles1.add(vehicle3);

    List<Vehicle> vehicles2 = new ArrayList<>();
    vehicles2.add(vehicle1);
    vehicles2.add(vehicle4);

    List<Vehicle> vehicles3 = new ArrayList<>();
    vehicles3.add(vehicle4);

    operator1 = new VehicleOperator("A", "1", LocalDate.of(1980, 1, 1), vehicles1);
    operator2 = new VehicleOperator("B", "2", LocalDate.of(1988, 10, 15), vehicles2);
    operator3 = new VehicleOperator("C", "3", LocalDate.of(1990, 2, 14), vehicles3);

    List<VehicleOperator> operators = new ArrayList<>();
    operators.add(operator1);
    operators.add(operator2);
    operators.add(operator3);
    processor = new VehicleOperatorProcessor(operators);
  }

  @Test
  public void mysteryMethod() {
    List<Vehicle> expectedVehicles1 = new ArrayList<>();
    expectedVehicles1.add(vehicle1);
    expectedVehicles1.add(vehicle3);

    List<Vehicle> expectedVehicles2 = new ArrayList<>();

    assertEquals(expectedVehicles1, VehicleOperatorProcessor.mysteryMethod(operator1, "a", "b"));
    assertEquals(expectedVehicles2, VehicleOperatorProcessor.mysteryMethod(operator1, "c", "d"));
  }

  @Test
  public void filterByManufacturingYear() {
    List<String> expectedOperatorNames1 = new ArrayList<>();
    expectedOperatorNames1.add("A");
    expectedOperatorNames1.add("B");
    List<VehicleOperator> expectedOperatorNames2 = new ArrayList<>();
    assertEquals(expectedOperatorNames1, processor.filterByManufacturingYear(LocalDate.of(1990, 1, 1)));
    assertEquals(expectedOperatorNames2, processor.filterByManufacturingYear(LocalDate.of(1980, 1, 1)));
  }
}