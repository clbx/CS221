public class Node <Type>{

  public Node<Type> next;
  public Node<Type> prev;
  Type data;

  public Node(Type data){
    this.data = data;
  }
}
