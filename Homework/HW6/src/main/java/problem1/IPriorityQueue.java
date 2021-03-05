package problem1;


public interface IPriorityQueue {
  static IPriorityQueue createEmpty() {
    return new PriorityQueue();
  }

  /**
   * Checks if PQ is empty.
   * @return true if the PQ contains no items, false otherwise.
   */
  Boolean isEmpty();

  /**
   * Adds the given element (the priority and its associated value) to the PQ.
   * @param priority The priority of the added element, represented as an Integer
   * @param value The value of the added element associated with the priority, represented as a String.
   * @return The new PriorityQueue object with the new added element.
   */
  IPriorityQueue add(Integer priority, String value);

  /**
   * Gets the value in the PQ that has the highest priority. In this method, when multiple elements
   * in the PQ have the same priority, the element that enters the queue first will be got first.
   * @return The value in the PQ that has the highest priority.
   */
  String peek() throws EmptyPriorityQueueException;

  /**
   * Gets a copy of the PQ without the element with the highest priority
   * @return A copy of the PQ without the element with the highest priority
   */
  PriorityQueue pop() throws EmptyPriorityQueueException;
}
