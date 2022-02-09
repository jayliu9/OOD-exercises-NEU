package problem1;

import static org.junit.Assert.*;

import org.junit.Test;

public class PastaTest {

  @Test
  public void createPasta() throws StorageExcessException {
    Pasta pasta = new Pasta("Pasta", 1.6, 150);
  }

}