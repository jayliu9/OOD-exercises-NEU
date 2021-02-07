package problem2;

/**
 * An interface specifying required behaviors for a Piece.
 */
public interface Piece {

  /**
   * Performs an increase.
   * @param num The number to increase by
   * @throws InvalidWealthException if the wealth is invalid
   * @throws InvalidStaminaException if the stamina is invalid.
   */
  void increase(Double num) throws InvalidWealthException, InvalidStaminaException;

  /**
   * Performs an decrease.
   * @param num The number to decrease by
   * @throws InvalidWealthException if the wealth is invalid
   * @throws InvalidStaminaException if the stamina is invalid.
   */
  void decrease(Double num) throws InvalidWealthException, InvalidStaminaException;
}
