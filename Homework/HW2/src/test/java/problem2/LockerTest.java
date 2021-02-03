package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.OccupiedRoomException;

public class LockerTest {
  Locker emptyLocker;
  MailItem mailToAdd;
  Recipient recipient;
  Locker fullLocker;


  @Before
  public void setUp() throws Exception {
    emptyLocker = new Locker(5, 5, 5);
    recipient = new Recipient("Harry", "Potter", "harry@example.com");
    mailToAdd = new MailItem(4, 3, 3, recipient);
    fullLocker = new Locker(5, 5, 5);
    fullLocker.addMail(mailToAdd);

  }

  @Test
  public void addMail()
      throws OccupiedLockerException, OversizedMailItemException, InvalidDimensionException {
    emptyLocker.addMail(mailToAdd);
    MailItem testMail = new MailItem(4, 3, 3, recipient);
    assertEquals(testMail, emptyLocker.getMailItem());
  }

  @Test
  public void pickupMail()
      throws InvalidDimensionException, MismatchedRecipientException, NoMailItemException {
    MailItem testMail = new MailItem(4, 3, 3, recipient);
    Recipient testRecipient = new Recipient("Harry", "Potter", "harry@example.com");
    assertEquals(testMail, fullLocker.pickupMail(testRecipient));
    assertEquals(null, fullLocker.getMailItem());
  }

  @Test
  public void getMaxWidth() {
    assertEquals(Integer.valueOf(5), emptyLocker.getMaxWidth());
  }

  @Test
  public void getMaxHeight() {
    assertEquals(Integer.valueOf(5), emptyLocker.getMaxHeight());
  }

  @Test
  public void getMaxDepth() {
    assertEquals(Integer.valueOf(5), emptyLocker.getMaxDepth());
  }

  @Test
  public void getMailItem() throws InvalidDimensionException {
    MailItem testMail = new MailItem(4, 3, 3, recipient);
    assertEquals(testMail, fullLocker.getMailItem());
  }

  @Test(expected = InvalidDimensionException.class)
  public void invalidMaxWidth() throws InvalidDimensionException {
    Locker invalidMaxWidth = new Locker(0, 5, 5);
  }

  @Test(expected = InvalidDimensionException.class)
  public void invalidMaxHeight() throws InvalidDimensionException {
    Locker invalidMaxWidth = new Locker(5, -3, 5);
  }

  @Test(expected = InvalidDimensionException.class)
  public void invalidMaxDepth() throws InvalidDimensionException {
    Locker invalidMaxWidth = new Locker(5, 5, 0);
  }

  @Test(expected = OccupiedLockerException.class)
  public void occupiedLocker() throws OccupiedLockerException, OversizedMailItemException {
    fullLocker.addMail(mailToAdd);
  }

  @Test(expected = OversizedMailItemException.class)
  public void tooWideMailItem()
      throws InvalidDimensionException, OccupiedLockerException, OversizedMailItemException {
    MailItem tooWide = new MailItem(8, 5, 5, recipient);
    emptyLocker.addMail(tooWide);
  }

  @Test(expected = OversizedMailItemException.class)
  public void tooHighMailItem()
      throws InvalidDimensionException, OccupiedLockerException, OversizedMailItemException {
    MailItem tooHigh = new MailItem(5, 9, 5, recipient);
    emptyLocker.addMail(tooHigh);
  }

  @Test(expected = OversizedMailItemException.class)
  public void tooDeepMailItem()
      throws InvalidDimensionException, OccupiedLockerException, OversizedMailItemException {
    MailItem tooDeep = new MailItem(5, 5, 7, recipient);
    emptyLocker.addMail(tooDeep);
  }

  @Test(expected = NoMailItemException.class)
  public void noMailToPickup() throws MismatchedRecipientException, NoMailItemException {
    emptyLocker.pickupMail(recipient);
  }

  @Test(expected = MismatchedRecipientException.class)
  public void mismatchedRecipient() throws MismatchedRecipientException, NoMailItemException {
    Recipient mismatch = new Recipient("James", "Bond", "test@example.com");
    fullLocker.pickupMail(mismatch);
  }
}