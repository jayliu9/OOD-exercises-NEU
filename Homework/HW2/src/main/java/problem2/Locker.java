package problem2;

/**
 * Name: Shijie Liu
 * NUID: 001561546
 * Course: CS 5004
 * Course Number: 38097
 * Semester: Spring 2021
 *
 * This class represents Locker with the maximum width, maximum height, maximum depth and
 * the item stored in the locker.
 */
public class Locker {

  private Integer maxWidth;
  private Integer maxHeight;
  private Integer maxDepth;
  private MailItem mailItem;
  private static final Integer MIN_SIZE = 1;

  /**
   * Constructor for the Locker class. Assume that when a locker is first created, it is empty and
   * the field is set to null by default.
   * @param maxWidth The maximum width of the locker in inches, an integer greater than or equal to 1
   * @param maxHeight The maximum height of the locker in inches, an integer greater than or equal to 1
   * @param maxDepth The maximum depth of the locker in inches, an integer greater than or equal to 1
   * @throws InvalidDimensionException if any single dimension of the Locker is invalid.
   */
  public Locker(Integer maxWidth, Integer maxHeight, Integer maxDepth)
      throws InvalidDimensionException {
    this.validateLockerDimensions(maxWidth, maxHeight, maxDepth);
    this.maxWidth = maxWidth;
    this.maxHeight = maxHeight;
    this.maxDepth = maxDepth;
    this.mailItem = null;
  }

  /**
   * Checks that all the dimensions of the locker are valid.
   * @param maxWidth The maximum width
   * @param maxHeight The maximum height
   * @param maxDepth The maximum depth
   * @throws InvalidDimensionException if any single dimension of the Locker is invalid.
   */
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

  /**
   * Stores a mail item in this locker.
   * @param mailToStore the mail item to store
   * @throws OccupiedLockerException if the locker is already contains a mail item.
   * @throws OversizedMailItemException if the size of the mail item exceeds the dimensions of the
   * locker.
   */
  public void addMail(MailItem mailToStore)
      throws OccupiedLockerException, OversizedMailItemException {
    this.validateAvailability();
    this.validateMailSize(mailToStore);
    this.mailItem = mailToStore;
  }

  /**
   * Checks if this locker is available.
   * @return true if the locker is available, false otherwise.
   */
  private boolean isAvailable() {
    return this.mailItem == null;
  }

  /**
   * Checks that the locker contains no mail item.
   * @throws OccupiedLockerException if the locker is already occupied.
   */
  private void validateAvailability() throws OccupiedLockerException {
    if (!isAvailable()) {
      throw new OccupiedLockerException();
    }
  }

  /**
   * Checks that any dimension of the mail item is not bigger than the locker.
   * @param mailItem The mail item to check.
   * @throws OversizedMailItemException if any single dimension of the mail item is bigger
   * than the locker.
   */
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

  /**
   * Picks up the mail item stored in the locker.
   * @param person The person who is going to pick up the mail item.
   * @return The mail item in the locker.
   * @throws NoMailItemException if no mail item in the locker.
   * @throws MismatchedRecipientException if the person to pick up the mail does not match
   * the recipient of the mail item.
   */
  public MailItem pickupMail(Recipient person)
      throws NoMailItemException, MismatchedRecipientException {
    this.validateStorage();
    this.validateRecipientMatch(person);
    MailItem mailItemToPickup = this.mailItem;
    this.mailItem = null;
    return mailItemToPickup;
  }

  /**
   * Checks that there is a mail item in the locker.
   * @throws NoMailItemException if there is no mail item in the locker.
   */
  private void validateStorage() throws NoMailItemException {
    if (isAvailable()) {
      throw new NoMailItemException();
    }
  }

  /**
   * Checks that the person to pick up the mail in the locker matches the recipient of the mail item
   * @param person The person to check
   * @throws MismatchedRecipientException if the person to pick up the mail does not match
   * the recipient of the mail item.
   */
  private void validateRecipientMatch(Recipient person) throws MismatchedRecipientException {
    if (!person.equals(this.mailItem.getRecipient())) {
      throw new MismatchedRecipientException();
    }
  }

  /**
   * Gets the maximum width of the locker
   * @return The maximum width of the locker
   */
  public Integer getMaxWidth() {
    return this.maxWidth;
  }

  /**
   * Gets the maximum height of the locker
   * @return The maximum height of the locker
   */
  public Integer getMaxHeight() {
    return this.maxHeight;
  }

  /**
   * Gets the maximum depth of the locker
   * @return The maximum depth of the locker
   */
  public Integer getMaxDepth() {
    return this.maxDepth;
  }

  /**
   * Gets the mail item stored in the locker.
   * @return The mail item stored in the locker.
   */
  public MailItem getMailItem() {
    return this.mailItem;
  }
}
