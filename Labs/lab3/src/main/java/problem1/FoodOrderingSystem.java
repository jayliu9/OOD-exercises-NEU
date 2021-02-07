package problem1;

/**
 * Represents a food ordering system, including a list of food.
 */
public class FoodOrderingSystem {
  private Food[] foodList;

  /**
   * Constructor for the food ordering system class.
   * @param foodList a list of food.
   */
  public FoodOrderingSystem(Food[] foodList) {
    this.foodList = foodList;
  }

  /**
   * Gets the list of food of the food ordering system.
   * @return The list of food of the food ordering system.
   */
  public Food[] getFoodList() {
    return this.foodList;
  }
}
