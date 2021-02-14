package problem2;

import java.util.Objects;

/**
 * Represents a singly-linked node for a linked List.
 */
public class Node {

  private String data;
  private Node nextNode;

  /**
   * Constructor for the Node class
   * @param data The data stored in the node
   * @param nextNode A reference to the next Node, if any.
   */
  public Node(String data, Node nextNode) {
    this.data = data;
    this.nextNode = nextNode;
  }

  /**
   * Gets the data stored in the node
   * @return The data in the node
   */
  public String getData() {
    return this.data;
  }

  /**
   * Gets the next node
   * @return The next node if present, null if this is the end of the list
   */
  public Node getNextNode() {
    return this.nextNode;
  }

  /**
   * Sets the next Node.
   * @param nextNode The next Node in the list. This will be null if the current Node is to be the end of the list.
   */
  public void setNextNode(Node nextNode) {
    this.nextNode = nextNode;
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
    Node node = (Node) o;
    return this.data.equals(node.data) && this.nextNode.equals(node.nextNode);
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.data, this.nextNode);
  }

  /**
   * Creates a string representation of the Node.
   * @return a string representation of the Node.
   */
  @Override
  public String toString() {
    return "Node{" +
        "data='" + this.data + '\'' +
        ", nextNode=" + this.nextNode +
        '}';
  }
}
