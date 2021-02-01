package problem2;

public class MailItem {
  private Integer width;
  private Integer height;
  private Integer depth;
  private Recipient recipient;

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
    Integer MIN_SIZE = 1;
    if (width < MIN_SIZE) {
      throw new InvalidDimensionException("Invalid width of the mail item!");
    } else if (height < MIN_SIZE) {
      throw new InvalidDimensionException("Invalid height of the mail item!");
    } else if (depth < MIN_SIZE) {
      throw new InvalidDimensionException("Invalid depth of the mail item!");
    }
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
