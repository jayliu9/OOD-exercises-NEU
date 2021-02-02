package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MailItemTest {
  MailItem mailItem;

  @Before
  public void setUp() throws Exception {
    Recipient harry = new Recipient("Harry", "Potter", "harry@example.com");
    mailItem = new MailItem(2, 3, 2, harry);
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
}