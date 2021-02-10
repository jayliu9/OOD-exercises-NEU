package problem1;

/**
 * An interface specifying required behaviors for a property service.
 */
public interface PropertyService {

  /**
   * Calculates the total price of the service based on specified rules
   * @return The total price of the service
   */
  double calculatePrice();

  /**
   * Calculates the base price of the service based on specified rules
   * @return The base price of the service
   */
  int calculateBasePrice();
}
