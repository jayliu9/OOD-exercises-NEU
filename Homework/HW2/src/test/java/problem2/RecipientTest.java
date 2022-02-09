package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecipientTest {

  Recipient recipient;
  Recipient equalRecipient;
  Recipient nullRecipient;
  Recipient nullFirstName;
  Recipient nullLastName;
  Recipient nullEmailAddress;
  Recipient nullAllFields;
  Recipient equalNullAllFields;

  @Before
  public void setUp() throws Exception {
    recipient = new Recipient("Harry", "Potter", "harry@example.com");
    equalRecipient = new Recipient("Harry", "Potter", "harry@example.com");
    nullRecipient = null;
    nullFirstName = new Recipient(null, "Potter", "harry@example.com");
    nullLastName = new Recipient("Harry", null, "harry@example.com");
    nullEmailAddress = new Recipient("Harry", "Potter", null);
    nullAllFields = new Recipient(null, null, null);
    equalNullAllFields = new Recipient(null, null, null);
  }

  @Test
  public void testEquals() {
    assertTrue(recipient.equals(recipient));
    assertFalse(recipient.equals("Harry Potter"));
    assertFalse(recipient.equals(nullRecipient));
    assertTrue(recipient.equals(equalRecipient));
    assertFalse(recipient.equals(nullFirstName));
    assertFalse(recipient.equals(nullLastName));
    assertFalse(recipient.equals(nullEmailAddress));
    assertFalse(nullAllFields.equals(recipient));
    assertTrue(nullAllFields.equals(equalNullAllFields));
  }

  @Test
  public void testHashCode() {
    assertTrue(recipient.hashCode() == equalRecipient.hashCode());
    assertTrue(recipient.hashCode() != nullAllFields.hashCode());
  }

  @Test
  public void getFirstName() {
    assertEquals("Harry", recipient.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals("Potter", recipient.getLastName());
  }

  @Test
  public void getEmailAddress() {
    assertEquals("harry@example.com", recipient.getEmailAddress());
  }
}