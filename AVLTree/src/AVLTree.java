/**
*@author buxtonc
*
*/

public class AVLTree {

  //Root Node
  public Node root;
  
  public AVLTree(){

  }
	
	
   /**
   *Inserts a node into the tree
   *
   *@param int data: the number to be inserted into the tree
   *@param Node n: The root of the tree
   *@return Node: the root of the adjusted tree
   */
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


  /**
  *Rotates the tree to the left
  *
  *@param Node root: The root of the subtree that needs rotating
  *@return Node: The root of the rotated subtree
  */
  private Node rotateLeft(Node root){
    Node right = root.right;
    Node temp = right.left;
    right.left = root;
    root.right = temp;

    root.height = max(getHeight(root.left),getHeight(root.right)) + 1;
    right.height = max(getHeight(right.left),getHeight(right.right)) + 1;

    return right;
  }

  /**
  *Rotates the tree to the right
  *
  *@param Node root: The root of the node that needs rotating
  *@return Node: The root of the rotated subtree
  */
  private Node rotateRight(Node root){
    Node left = root.left;
    Node temp = left.right;

    left.right = root;
    root.left = temp;

    root.height = max(getHeight(root.left), getHeight(root.right)) + 1;
    left.height = max(getHeight(left.left), getHeight(left.right)) + 1;

    return left;
  }

  /**
  * Getter for the node height
  *
  *@param Node node: node to get height from
  *@return int: the height of the node
  */
  int getHeight(Node node){
    if(node == null)
      return 0;
    return node.height;
  }

  
  /**
  * Gets the balance between the right and left subtrees
  *
  *@param Node node: The node to measure the left and right trees
  *@return int: The difference in balance between left and right
  *
  */
  int getBalance(Node node){
    if( node == null)
      return 0;
    return getHeight(node.left) - getHeight(node.right);
  }


  /**
  * Gets the max between 2 numbers
  *
  *@param int a: the first number
  *@param int b: the second number
  *@return int, the max between a or b.
  */
  private int max(int a, int b) {
    if (a > b)
      return a;
    else
      return b;
  }


  /**
  *
  *Traverses a tree 
  *
  *@param Node root: the root of the tree
  *
  */
  public void traverse(Node root){
    if(root != null){
      traverse(root.left);
      System.out.println(root.data);
      traverse(root.right);
    }
  }



}



