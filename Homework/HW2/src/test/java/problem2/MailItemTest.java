package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MailItemTest {

  MailItem mailItem;
  MailItem equalMailItem;
  MailItem nullMailItem;
  MailItem wrongWidth;
  MailItem wrongHeight;
  MailItem wrongDepth;
  MailItem nullRecipient;
  MailItem equalNullRecipient;
  Recipient harry;

  @Before
  public void setUp() throws Exception {
    harry = new Recipient("Harry", "Potter", "harry@example.com");
    mailItem = new MailItem(2, 3, 2, harry);
    equalMailItem = new MailItem(2, 3, 2, harry);
    nullMailItem = null;
    wrongWidth = new MailItem(4, 3, 2, harry);
    wrongHeight = new MailItem(2, 4, 2, harry);
    wrongDepth = new MailItem(2, 3, 4, harry);
    nullRecipient = new MailItem(2, 3, 2, null);
    equalNullRecipient = new MailItem(2, 3, 2, null);
  }

  @Test
  public void getWidth() {
    assertEquals(Integer.valueOf(2), mailItem.getWidth());
  }

  @Test
  public void getHeight() {
    assertEquals(Integer.valueOf(3), mailItem.getHeight());
  }

  @Test
  public void getDepth() {
    assertEquals(Integer.valueOf(2), mailItem.getDepth());
  }

  @Test
  public void getRecipient() {
    Recipient test = new Recipient("Harry", "Potter", "harry@example.com");
    assertEquals(test, mailItem.getRecipient());
  }

  @Test
  public void testEquals() {
    assertTrue(mailItem.equals(mailItem));
    assertFalse(mailItem.equals("A mail item"));
    assertFalse(mailItem.equals(nullMailItem));
    assertTrue(mailItem.equals(equalMailItem));
    assertFalse(mailItem.equals(wrongWidth));
    assertFalse(mailItem.equals(wrongHeight));
    assertFalse(mailItem.equals(wrongDepth));
    assertFalse(mailItem.equals(nullRecipient));
    assertTrue(nullRecipient.equals(equalNullRecipient));
  }

  @Test
  public void testHashCode() {
    assertTrue(mailItem.hashCode() == equalMailItem.hashCode());
    assertTrue(mailItem.hashCode() != nullRecipient.hashCode());
  }

  @Test(expected = InvalidDimensionException.class)
  public void invalidWidth() throws InvalidDimensionException {
    MailItem invalidWidth = new MailItem(0, 3, 3, harry);
  }

  @Test(expected = InvalidDimensionException.class)
  public void invalidHeight() throws InvalidDimensionException {
    MailItem invalidHeight = new MailItem(3, 0, 3, harry);
  }

  @Test(expected = InvalidDimensionException.class)
  public void invalidDepth() throws InvalidDimensionException {
    MailItem invalidDepth = new MailItem(3, 3, -3, harry);
  }
}