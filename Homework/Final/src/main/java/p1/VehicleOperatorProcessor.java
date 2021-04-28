package p1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleOperatorProcessor {
  private List<VehicleOperator> operators;

  public VehicleOperatorProcessor(List<VehicleOperator> operators) {
    this.operators = operators;
  }

  private VehicleOperatorProcessor(VehicleOperator operator1, VehicleOperator operator2){
    this.operators.add(operator1);
    this.operators.add(operator2);
  }

  /**
   * Creates a list whose the elements are the vehicles with the specified make and model operated
   * by the specified vehicle operator.
   * @param operator The vehicle operator
   * @param make The specified make of a vehicle
   * @param model The specified model of a vehicle
   * @return A list whose the elements are the vehicles with the specified make and model
   * operated by the specified vehicle operator
   */
  public static List<Vehicle> mysteryMethod(VehicleOperator operator, String make, String model){
    return operator.getOperatedVehicles().stream()
        .filter(x -> x.getMake().equals(make) && x.getModel().equals(model))
        .collect(Collectors.toList());
  }

  /**
   * Creates a list of names of all vehicle operators who operate at least one vehicle older than
   * or equal to the specified manufacturing year
   * @param manufacturingYear The specified manufacturing year
   * @return A list of names of all vehicle operators who operate at least one vehicle older than
   * or equal to the specified manufacturing year
   */
  public List<String> filterByManufacturingYear(LocalDate manufacturingYear){
    return this.operators.stream()
        .filter(operator -> operator.filterByYearManufactured(manufacturingYear).size() >= 1)
        .map(operator -> operator.getName())
        .collect(Collectors.toList());
  }

}
