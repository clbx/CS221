import java.util.HashMap;

public class Node {

  Node[] children = new Node[26];

  // hash map better though, much faster
  // HashMap<Character, Node> children;

  boolean isCompleteWord;


  Node(){
    isCompleteWord = false;
    for(int i = 0; i < 26; i++)
      children[i] = null;
  }

}
