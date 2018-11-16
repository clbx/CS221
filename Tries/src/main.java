public class main {


  public static void main(String[] args) {
    Trie tree = new Trie();

    String[] words = {"the","quick","brown","dog","ran","to","dark","big","fat","rat"};

    for(String word : words)
      tree.insert(word);


    System.out.println(tree.search("the"));

    System.out.println(tree.search("he"));

    System.out.println(tree.search("brown"));

    System.out.println(tree.search("rown"));

    System.out.println(tree.search("brow"));

  }
}
