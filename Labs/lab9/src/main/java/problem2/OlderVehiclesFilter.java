package problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents the filter of older vehicles
 */
public class OlderVehiclesFilter {

  private List<Vehicle> vehicles = new ArrayList<>();

  /**
   * Constructor for the OlderVehiclesFilter class
   *
   * @param vehicles The list of vehicles
   */
  public OlderVehiclesFilter(List<Vehicle> vehicles) {
    this.vehicles = vehicles;
  }

  /**
   * Constructor for the OlderVehiclesFilter class
   *
   * @param vehicle1 A vehicle
   * @param vehicle2 A vehicle
   * @param vehicle3 A vehicle
   */
  public OlderVehiclesFilter(Vehicle vehicle1, Vehicle
      vehicle2, Vehicle vehicle3) {
    this.vehicles.add(vehicle1);
    this.vehicles.add(vehicle2);
    this.vehicles.add(vehicle2);
  }

  /**
   * Prints out make, model and year of all the vehicles manufactured after 1999.
   *
   * @return The list of String representing vehicles manufactured after 1999 with make, model and
   * year
   */
  public List<String> filterOlderVehicles() {
    List<String> printOut = this.vehicles.stream()
        .filter(vehicle -> vehicle.getYear() > 1999)
        .map(vehicle -> vehicle.toString())
        .collect(Collectors.toList());
    printOut.forEach(System.out::println);
    return printOut;
  }

  /**
   * Prints out make, model and year of all the vehicles whose makes are not Volkswagen
   *
   * @return The list of String representing vehicles whose makes are not Volkswagen with make,
   * model and year
   */
  public List<String> filterVWVehicles() {
    List<String> printOut = this.vehicles.stream()
        .filter(vehicle -> !vehicle.getMake().equals("Volkswagen"))
        .map(vehicle -> vehicle.toString())
        .collect(Collectors.toList());
    printOut.forEach(System.out::println);
    return printOut;
  }
}
