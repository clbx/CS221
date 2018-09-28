/**
 * @param <Type> the type of the Doubly Linked List
 * @author buxtonc
 */
public class DoublyLinkedList<Type> {

  private Node<Type> head;
  private Node<Type> tail;

  /**
   * @param item item to push to the list
   */
  public void push(Type item) {

    Node<Type> new_node = new Node<>(item);
    new_node.prev = null;
    new_node.next = head;

    if (head == null) {
      tail = new_node;
    }

    head = new_node;

  }

  /**
   * @return the front of the list
   */
  public Type pop() throws StackException{

    if (head == null) {
      System.out.println("Empty List");
      throw (new StackException("Stack Underflow"));
    }

    Node<Type> temp = head;

    if(head.next == null){
      head = null;
      return temp.data;
    }
    head = head.next;
    head.prev = null;

    return temp.data;
  }

  /**
   * @return the front of the list, but it doesn't take it off too
   */
  public Type peek() throws StackException {
    if(head == null){
      throw(new StackException("Stack Underflow"));
    }
    return head.data;
  }

  /**
   * @return if the list is empty
   */
  public boolean isEmpty() {
    return (head == null);
  }

  /**
   * @param item the item to put at the front of the list
   */
  public void insertFront(Type item) {
    push(item);
  }

  /**
   * @param item the item to put at the back of the list
   */
  public void insertRear(Type item) {
    Node<Type> new_node = new Node<>(item);

    if (head == null) {
      push(item);
      return;
    }

    tail.next = new_node;
    new_node.prev = tail;
    tail = new_node;

  }

  /**
   * @return the same as pop
   */
  public Type removeFront() throws StackException{
    return pop();
  }

  /**
   * @return gets the last item and removes it from the list
   */
  public Type removeRear() {
    Node<Type> temp = tail;

    tail = tail.prev;
    tail.next = null;

    return temp.data;

  }

  public void print() {
    Node<Type> temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");

      temp = temp.next;
    }
    System.out.println(" ");
  }


}
