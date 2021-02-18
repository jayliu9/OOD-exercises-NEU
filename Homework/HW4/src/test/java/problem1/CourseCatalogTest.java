package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CourseCatalogTest {
  Course math;
  Course chemistry;
  Course physics;
  Course art;
  Course biology;
  Course geography;
  ICourseCatalog empty;
  ICourseCatalog aCatalog;
  ICourseCatalog sameCatalog;
  ICourseCatalog nullCatalog;
  String differentType;
  Course sameMath;

  @Before
  public void setUp() throws Exception {
    math = new Course("Math", "A", 5);
    chemistry = new Course("Chemistry", "A", 7);
    physics = new Course("Physics", "A", 2);
    art = new Course("Art", "A", 9);
    biology = new Course("Biology", "A", 4);
    geography = new Course("Geography", "A", 6);
    sameMath = new Course("Math", "A", 5);
    empty = new CourseCatalog();
    aCatalog = new CourseCatalog();
    sameCatalog = new CourseCatalog();
    nullCatalog = null;
    differentType = "a catalog";
    aCatalog.append(math);
    aCatalog.append(chemistry);
    aCatalog.append(art);
    sameCatalog.append(math);
    sameCatalog.append(chemistry);
    sameCatalog.append(art);

  }

  @Test
  public void append() {
    aCatalog.append(physics);
    aCatalog.append(geography);
    aCatalog.append(biology);
    ICourseCatalog test = new CourseCatalog();
    test.append(math);
    test.append(chemistry);
    test.append(art);
    test.append(physics);
    test.append(geography);
    test.append(biology);
    assertEquals(test, aCatalog);
  }

  @Test
  public void remove() throws CourseNotFoundException, InvalidIndexException {
    aCatalog.remove(sameMath);
    Course sameChemistry = new Course("Chemistry", "A", 7);
    Course sameArt = new Course("Art", "A", 9);
    assertEquals(sameChemistry, aCatalog.get(0));
    assertEquals(sameArt, aCatalog.get(1));
    assertEquals(2, aCatalog.count());
  }

  @Test
  public void contains() {
    assertTrue(aCatalog.contains(sameMath));
    assertFalse(empty.contains(sameMath));
  }

  @Test
  public void indexOf() {
    assertEquals(0, aCatalog.indexOf(sameMath));
    assertEquals(-1, empty.indexOf(sameMath));
    empty.append(math);
    assertEquals(-1, empty.indexOf(physics));
  }

  @Test
  public void count() {
    assertEquals(3, aCatalog.count());
    assertEquals(0, empty.count());
  }

  @Test
  public void get() throws InvalidIndexException {
    assertEquals(sameMath, aCatalog.get(0));
  }

  @Test
  public void isEmpty() {
    assertTrue(empty.isEmpty());
    assertFalse(aCatalog.isEmpty());
  }

  @Test
  public void testEquals() throws CourseNotFoundException {
    assertTrue(aCatalog.equals(aCatalog));
    assertTrue(aCatalog.equals(sameCatalog));
    assertFalse(aCatalog.equals(empty));
    assertFalse(aCatalog.equals(nullCatalog));
    assertFalse(aCatalog.equals(differentType));
    ICourseCatalog rev = new CourseCatalog();
    rev.append(art);
    rev.append(chemistry);
    rev.append(math);
    assertFalse(aCatalog.equals(rev));
    ICourseCatalog removed = new CourseCatalog();
    removed.append(physics);
    removed.remove(physics);
    assertTrue(empty.equals(removed));
  }

  @Test
  public void testHashCode() {
    assertTrue(aCatalog.hashCode() == sameCatalog.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("CourseCatalog: numOfCourses = 3" +
        ", courses = {A5: Math, A7: Chemistry, A9: Art}", aCatalog.toString());
    assertEquals("CourseCatalog: numOfCourses = 0, courses = {}",
        empty.toString());
  }

  @Test(expected = CourseNotFoundException.class)
  public void courseNotFound() throws CourseNotFoundException {
    Course philosophy = new Course("Philosophy", "A", 8);
    aCatalog.remove(philosophy);
  }

  @Test(expected = InvalidIndexException.class)
  public void negativeIndex() throws InvalidIndexException {
    aCatalog.get(-1);
  }

  @Test(expected = InvalidIndexException.class)
  public void beyondRange() throws InvalidIndexException {
    aCatalog.get(3);
  }
}