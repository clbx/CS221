public class Trie {

  private Node root = new Node();

  public void insert(String word){
    Node crawler = root;
    int index;

    for(int i = 0; i < word.length(); i++){
      index = word.charAt(i) - 'a' ; //Drops to a valid index for the array from higher ASCII value
      if(crawler.children[index] == null)
        crawler.children[index] = new Node();

      crawler = crawler.children[index];
    }

    crawler.isCompleteWord = true;
  }

  boolean search(String word){
    int index;
    Node crawler = root;

    for(int i = 0; i < word.length(); i++){
      index = word.charAt(i) - 'a';
      if(crawler.children[index] == null)
        return false;

      crawler = crawler.children[index];
    }

    return true;

  }

}
