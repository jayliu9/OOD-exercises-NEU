package problem2;

public class Locker {

  private Integer maxWidth;
  private Integer maxHeight;
  private Integer maxDepth;
  private MailItem mailItem;
  private static final Integer MIN_SIZE = 1;

  public Locker(Integer maxWidth, Integer maxHeight, Integer maxDepth)
      throws InvalidDimensionException {
    this.validateLockerDimensions(maxWidth, maxHeight, maxDepth);
    this.maxWidth = maxWidth;
    this.maxHeight = maxHeight;
    this.maxDepth = maxDepth;
    this.mailItem = null;
  }

  private void validateLockerDimensions(Integer maxWidth, Integer maxHeight, Integer maxDepth)
      throws InvalidDimensionException {
    if (maxWidth < MIN_SIZE) {
      throw new InvalidDimensionException("Invalid maximum width of this locker!");
    } else if (maxHeight < MIN_SIZE) {
      throw new InvalidDimensionException("Invalid maximum height of this locker!");
    } else if (maxDepth < MIN_SIZE) {
      throw new InvalidDimensionException("Invalid maximum depth of this locker!");
    }
  }

  public void addMail(MailItem mailToStore)
      throws OccupiedLockerException, OversizedMailItemException {
    this.validateAvailability();
    this.validateMailSize(mailToStore);
    this.mailItem = mailToStore;
  }

  private boolean isAvailable() {
    return this.mailItem == null;
  }

  private void validateAvailability() throws OccupiedLockerException {
    if (!isAvailable()) {
      throw new OccupiedLockerException();
    }
  }

  private void validateMailSize(MailItem mailItem) throws OversizedMailItemException {
    Integer widthOfMail = mailItem.getWidth();
    Integer heightOfMail = mailItem.getHeight();
    Integer depthOfMail = mailItem.getDepth();

    boolean isOversize = widthOfMail > this.maxWidth || heightOfMail > this.maxHeight
        || depthOfMail > this.maxDepth;
    if (isOversize) {
      throw new OversizedMailItemException();
    }
  }

  public MailItem pickupMail(Recipient person)
      throws NoMailItemException, MismatchedRecipientException {
    this.validateStorage();
    this.validateRecipientMatch(person);
    MailItem mailItemToPickup = this.mailItem;
    this.mailItem = null;
    return mailItemToPickup;
  }

  private void validateStorage() throws NoMailItemException {
    if (isAvailable()) {
      throw new NoMailItemException();
    }
  }

  private void validateRecipientMatch(Recipient person) throws MismatchedRecipientException {
    if (!person.equals(this.mailItem.getRecipient())) {
      throw new MismatchedRecipientException();
    }
  }

  public Integer getMaxWidth() {
    return this.maxWidth;
  }

  public Integer getMaxHeight() {
    return this.maxHeight;
  }

  public Integer getMaxDepth() {
    return this.maxDepth;
  }

  public MailItem getMailItem() {
    return this.mailItem;
  }
}
