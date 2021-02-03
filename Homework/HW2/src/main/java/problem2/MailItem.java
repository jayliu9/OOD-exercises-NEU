package problem2;

import java.util.Objects;

public class MailItem {

  private Integer width;
  private Integer height;
  private Integer depth;
  private Recipient recipient;
  private static final Integer MIN_SIZE = 1;

  public MailItem(Integer width, Integer height, Integer depth, Recipient recipient)
      throws InvalidDimensionException {
    this.validateItemDimensions(width, height, depth);
    this.width = width;
    this.height = height;
    this.depth = depth;
    this.recipient = recipient;
  }

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

  @Override
  public int hashCode() {
    return Objects.hash(width, height, depth, recipient);
  }

  public Integer getWidth() {
    return this.width;
  }

  public Integer getHeight() {
    return this.height;
  }

  public Integer getDepth() {
    return this.depth;
  }

  public Recipient getRecipient() {
    return this.recipient;
  }
}
