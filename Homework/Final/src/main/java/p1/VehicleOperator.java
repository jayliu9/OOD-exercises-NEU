package p1;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleOperator {

  private String name;
  private String drivingLicenseNumber;
  private LocalDate dateOfBirth;
  private List<Vehicle> operatedVehicles;

  public VehicleOperator(String name, String drivingLicenseNumber,
                         LocalDate dateOfBirth, List<Vehicle> operatedVehicles) {
    this.name = name;
    this.drivingLicenseNumber = drivingLicenseNumber;
    this.dateOfBirth = dateOfBirth;
    this.operatedVehicles = operatedVehicles;
  }

  public String getName() {
    return name;
  }

  public String getDrivingLicenseNumber() {
    return drivingLicenseNumber;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public List<Vehicle> getOperatedVehicles() {
    return operatedVehicles;
  }

  /**
   * Returns a list of this operator's vehicles whose manufacturing year is older than
   * or equal to the specified manufacturing year
   * @param yearManufactured The specified manufacturing year
   * @return A list of this operator's vehicles whose manufacturing year is older than
   * or equal to the specified manufacturing year
   */
  public List<Vehicle> filterByYearManufactured(LocalDate yearManufactured) {
    return this.operatedVehicles.stream()
        .filter(vehicle -> vehicle.getYearManufactured().compareTo(yearManufactured) <= 0)
        .collect(Collectors.toList());
  }
}
