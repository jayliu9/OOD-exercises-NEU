package problem1;

import java.util.Objects;

/**
 * Represents a priority queue (PQ) of strings.
 */
public class PriorityQueue implements IPriorityQueue {

  private ILinkedList front;

  /**
   * Constructor for the PriorityQueue class. This creates a new empty priority queue.
   */
  public PriorityQueue() {
    this.front = new EmptyNode();
  }

  /**
   * Private constructor for an PriorityQueue that contains elements.
   * @param elements The elements in the new priority queue.
   */
  private PriorityQueue(ILinkedList elements) {
    this.front = elements;
  }

  /**
   * Checks if PQ is empty.
   * @return true if the PQ contains no items, false otherwise.
   */
  @Override
  public Boolean isEmpty() {
    return this.front.count().equals(0);
  }

  /**
   * Adds the given element (the priority and its associated value) to the PQ.
   * @param priority The priority of the added element, represented as an Integer
   * @param value The value of the added element associated with the priority, represented as a
   * String.
   * @return The new PriorityQueue object with the new added element.
   */
  @Override
  public IPriorityQueue add(Integer priority, String value) {
    ILinkedList elements = this.front.insertAt(value, priority);
    return new PriorityQueue(elements);
  }

  /**
   * Gets the value in the PQ that has the highest priority. In this method, when multiple elements
   * in the PQ have the same priority, the element that enters the queue first will be got first.
   * @return The value in the PQ that has the highest priority.
   * @throws EmptyPriorityQueueException if the PQ is empty.
   */
  @Override
  public String peek() throws EmptyPriorityQueueException {
    if (this.isEmpty()) {
      throw new EmptyPriorityQueueException("Called peek() on empty priority queue!");
    }
    return this.front.getItem();
  }

  /**
   * Gets a copy of the PQ without the element with the highest priority. In this method, when
   * multiple elements in the PQ have the same priority, the element that enters the queue first
   * will be removed first.
   * @return A copy of the PQ without the element with the highest priority
   * @throws EmptyPriorityQueueException if the PQ is empty
   */
  @Override
  public IPriorityQueue pop() throws EmptyPriorityQueueException {
    if (this.isEmpty()) {
      throw new EmptyPriorityQueueException("Called pop() on empty priority queue!");
    }
    return new PriorityQueue(this.front.getRest());
  }

  /**
   * Checks if two objects are equal
   * @param o the object to compare this to
   * @return true if these two objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PriorityQueue that = (PriorityQueue) o;
    return Objects.equals(this.front, that.front);
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.front);
  }

  /**
   * Creates a string representation of the PriorityQueue.
   * @return a string representation of the PriorityQueue.
   */
  @Override
  public String toString() {
    return "PriorityQueue{" +
        "front=" + this.front +
        '}';
  }
}
