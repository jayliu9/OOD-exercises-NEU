package problem2;

/**
 *
 */
public interface Piece {
  void increase(Double num) throws InvalidWealthException, InvalidStaminaException;
  void decrease(Double num) throws InvalidWealthException, InvalidStaminaException;
}
