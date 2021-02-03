package problem2;

import java.util.Objects;

/**
 * Name: Shijie Liu
 * NUID: 001561546
 * Course: CS 5004
 * Course Number: 38097
 * Semester: Spring 2021
 *
 * This class represents a mail item with the width, height, depth and the recipient.
 */
public class MailItem {

  private Integer width;
  private Integer height;
  private Integer depth;
  private Recipient recipient;
  private static final Integer MIN_SIZE = 1;

  /**
   * Constructor for the MailItem class.
   * @param width The width of the mail item in inches, an integer greater than or equal to 1
   * @param height The height of the mail item in inches, an integer greater than or equal to 1
   * @param depth The depth of the mail item in inches, an integer greater than or equal to 1.
   * @param recipient The recipient of the mail item.
   * @throws InvalidDimensionException if any single dimension of the mail item is invalid.
   */
  public MailItem(Integer width, Integer height, Integer depth, Recipient recipient)
      throws InvalidDimensionException {
    this.validateItemDimensions(width, height, depth);
    this.width = width;
    this.height = height;
    this.depth = depth;
    this.recipient = recipient;
  }

  /**
   * Checks that all dimensions of the mail item are valid.
   * @param width The width of the mail item
   * @param height The height of the mail item
   * @param depth The depth of the mail item
   * @throws InvalidDimensionException if any single dimension of the mail item is invalid
   */
  private void validateItemDimensions(Integer width, Integer height, Integer depth)
      throws InvalidDimensionException {
    if (width < MIN_SIZE) {
      throw new InvalidDimensionException("Invalid width of the mail item!");
    } else if (height < MIN_SIZE) {
      throw new InvalidDimensionException("Invalid height of the mail item!");
    } else if (depth < MIN_SIZE) {
      throw new InvalidDimensionException("Invalid depth of the mail item!");
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MailItem mailItem = (MailItem) o;
    return this.width.equals(mailItem.width) && this.height.equals(mailItem.height) && this.depth
        .equals(mailItem.depth) && Objects.equals(this.recipient, mailItem.recipient);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(width, height, depth, recipient);
  }

  /**
   * Gets the width of the mail item
   * @return The width of the mail item
   */
  public Integer getWidth() {
    return this.width;
  }

  /**
   * Gets the height of the mail item
   * @return The height of the mail item
   */
  public Integer getHeight() {
    return this.height;
  }

  /**
   * Gets the depth of the mail item
   * @return The depth of the mail item
   */
  public Integer getDepth() {
    return this.depth;
  }

  /**
   * Gets the recipient of the mail item
   * @return The recipient of the mail item
   */
  public Recipient getRecipient() {
    return this.recipient;
  }
}
