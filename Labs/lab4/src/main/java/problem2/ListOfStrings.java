package problem2;

import java.util.Objects;

/**
 * Represents a list of strings ADT, which is implemented by a linked list.
 */
public class ListOfStrings implements IListOfStrings {

  private int nodeNum;
  private Node head;

  /**
   * Constructor for the ListOfStrings class.
   */
  public ListOfStrings() {
    this.nodeNum = 0;
    this.head = null;
  }

  /**
   * Checks whether or not the list is empty
   * @return true if the list is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    return this.nodeNum == 0;
  }

  /**
   * Gets the total number of elements in the list
   * @return The total number of elements in the list
   */
  @Override
  public int size() {
    return this.nodeNum;
  }

  /**
   * Checks if the string is in the list or not
   * @param data The string to check
   * @return true if the string is in the list, false otherwise
   */
  @Override
  public boolean contains(String data) {
    Node currNode = this.head;
    while(currNode != null) {
      if(data.equals(currNode.getData())) {
        return true;
      }
      currNode = currNode.getNextNode();
    }
    return false;
  }

  /**
   * Checks that all elements of this list are in the list passed as argument
   * @param list The list passed as argument
   * @return true if all elements of this list are in the list passed as argument, false otherwise
   */
  @Override
  public boolean containsAll(IListOfStrings list) {
    Node currNode = this.head;
    while(currNode != null) {
      if(!list.contains(currNode.getData())) {
        return false;
      }
      currNode = currNode.getNextNode();
    }
    return true;
  }

  /**
   * Returns a list with all elements whose length is greater than the maximum length removed.
   * @param maxLength The maximum string length
   * @return A list with all elements whose length is greater than the maximum length removed
   */
  @Override
  public IListOfStrings filterLargerThan(int maxLength) {
    ListOfStrings newList = createEmpty();
    Node currNode = this.head;
    while(currNode != null) {
      if(currNode.getData().length() <= maxLength) {
        newList.add(currNode.getData());
      }
      currNode = currNode.getNextNode();
    }
    return newList;
  }

  /**
   * Check if the list has at least one duplicate element.
   * @return true if the list has at least one duplicate element, false otherwise
   */
  @Override
  public boolean hasDuplicates() {
    Node nodeToCheck = this.head;
    while(nodeToCheck != null) {
      Node nextNode = nodeToCheck.getNextNode();
      while(nextNode != null) {
        if (nodeToCheck.getData().equals(nextNode.getData())) {
          return true;
        }
        nextNode = nextNode.getNextNode();
      }
      nodeToCheck = nodeToCheck.getNextNode();
    }
    return false;
  }

  /**
   * Returns the list with all duplicates removed
   * @return The list with all duplicates removed
   */
  @Override
  public IListOfStrings removeDuplicates() {
    IListOfStrings newList = createEmpty();
    Node currNode = this.head;
    while(currNode != null) {
      if (!newList.contains(currNode.getData())) {
        newList.add(currNode.getData());
      }
      currNode = currNode.getNextNode();
    }
    return newList;
  }

  /**
   * Creates an empty list.
   * @return An empty list.
   */
  public static ListOfStrings createEmpty() {
    return new ListOfStrings();
  }

  /**
   * Add an item to the list.
   * @param data The item to add.
   */
  @Override
  public void add(String data) {
    Node newNode = new Node(data, null);
    if (this.head == null)
      this.head = newNode;
    else {
      Node currNode = this.head;
      while (currNode.getNextNode() != null) {
        currNode = currNode.getNextNode();
      }
      currNode.setNextNode(newNode);
    }
    this.nodeNum++;
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
    ListOfStrings that = (ListOfStrings) o;
    return this.nodeNum == that.nodeNum && Objects.equals(this.head, that.head);
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.nodeNum, this.head);
  }

  /**
   * Creates a string representation of the ListOfStrings.
   * @return a string representation of the ListOfStrings.
   */
  @Override
  public String toString() {
    return "ListOfStrings{" +
        "nodeNum=" + this.nodeNum +
        ", head=" + this.head +
        '}';
  }
}
