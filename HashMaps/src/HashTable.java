import java.util.ArrayList;

public class HashTable {


  private int collisions = 0;

  private ArrayList<Integer>[] table;

  /**
   *  Constructor
   * @param size size of table to be rounded up to the nearest prime number
   */
  public HashTable(int size){

    while(!isPrime(size))
      size++;

    table = new ArrayList[size];
    System.out.println("Table Size: " + size);
  }


  /**
   *
   * @param key the number to be hashed
   * @return the hash
   */
  private int hash(int key){
    int hashkey;
    hashkey = key%table.length;
    return hashkey;
  }

  /**
   *
   * @param key the number to be instered into the hash table
   */
  public void put(int key){

    int index = hash(key);

    if(table[index] == null)
      table[index] = new ArrayList<>();

    if(table[index].contains(key))
      return;

    if(!table[index].isEmpty())
      collisions++;

    table[index].add(key);
  }

  /**
   *
   * @param key the number to be searched for
   * @return if the number exists
   */
  public boolean find(int key){
    int index = hash(key);

    if(table[index] != null && table[index].contains(key)){
      return true;
    }

    return false;
  }

  /**
   *
   * @param num  Number to check if prime
   * @return if it's prime or not
   */
  private boolean isPrime(int num){

    for(int i = 2; i <= num/2; i++){
      if(num % i == 0){
        return false;
      }
    }
    return true;
  }


  /**
   * GETTER
   * @return number of collisions
   */
  public int getCollisions(){
    return collisions;
  }

  /**
   *
   * @return gets the length of the longest list
   */
  public int getLongestList(){
    int max = 0;
    for(int i = 0; i < table.length; i++){
      if(table[i].size() > max)
        max = table[i].size();
    }

    return max;
  }
  

}
