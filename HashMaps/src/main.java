import java.util.Random;

public class main {

  public static void main(String[] args) {

    Random rand = new Random();
    HashTable table = new HashTable(1000);

    for(int i = 0; i < 10000; i++){
      int n = rand.nextInt(9999) + 1;
      table.put(n);
    }

    System.out.println("Collisions: " + table.getCollisions());
    System.out.println("Longest List: " + table.getLongestList());



  }
}
