public class AVLTree {

  public Node root;

  public AVLTree(){

  }


   Node insert(int data, Node n){
    if(n == null){
      n = new Node(data);
      return n;
    }

    if(data < n.data)
      n.left = insert(data, n.left); //Goes to left
    else if(data > n.data)
      n.right = insert(data, n.right); // Goes to right
    else
       ;

    n.height = max(getHeight(n.left),getHeight(n.right)) + 1;
    int balance = getBalance(n);
    //Right case
    if(balance < -1 && data > n.right.data)
      return rotateLeft(n);
    //Right left case
    if(balance < -1 && data < n.right.data) {
      n.right = rotateRight(n.right);
      return rotateLeft(n);
    }
    //Left case
    if(balance > 1 && data < n.left.data)
      return rotateRight(n);
    //Left right case
    if(balance > 1 && data > n.left.data){
      n.left = rotateLeft(n.left);
      return rotateRight(n);
    }

    return n;
  }


  private Node rotateLeft(Node root){
    Node right = root.right;
    Node temp = right.left;
    right.left = root;
    root.right = temp;

    root.height = max(getHeight(root.left),getHeight(root.right)) + 1;
    right.height = max(getHeight(right.left),getHeight(right.right)) + 1;

    return right;
  }

  private Node rotateRight(Node root){
    Node left = root.left;
    Node temp = left.right;

    left.right = root;
    root.left = temp;

    root.height = max(getHeight(root.left), getHeight(root.right)) + 1;
    left.height = max(getHeight(left.left), getHeight(left.right)) + 1;

    return left;
  }

  int getHeight(Node node){
    if(node == null)
      return 0;
    return node.height;
  }

  int getBalance(Node node){
    if( node == null)
      return 0;
    return getHeight(node.left) - getHeight(node.right);
  }


  private int max(int a, int b) {
    if (a > b)
      return a;
    else
      return b;
  }


  public void traverse(Node root){
    if(root != null){
      traverse(root.left);
      System.out.println(root.data);
      traverse(root.right);
    }
  }



}



