public class main {

  private final static int nanoConv = 1000000000;
  public static void main(String[] args) {


    QuickSort Sort = new QuickSort();
    AVLTree Tree = new AVLTree();


    int runs = 1000;          //The number of runs to run
    int arrLen = 12500000;   //The number of elements in the arrays
    double sortTimes[] = new double[runs];
    double treeTimes[] = new double[runs];

    System.out.println("[ Speed Runs ]");
    System.out.printf("[n = %d] [Runs: %d]\n", arrLen, runs);
    System.out.println("-------------------");

    for (int i = 0; i < runs; i++) {
      int arr[] = new int[arrLen];
      genArray(arr);


      double startTime = System.nanoTime();
      Sort.sort(arr);
      double endTime = System.nanoTime();
      double duration = (endTime - startTime);
      sortTimes[i] = duration;
      System.out.printf("Run [%d] Array Sorted - Time: %.3fs\n", i + 1, duration / nanoConv);

      int arr1[] = new int[arrLen];
      genArray(arr1);

      startTime = System.nanoTime();
      for(int j = 0; j < arr1.length; j++)
        Tree.root = Tree.insert(arr1[i],Tree.root);

      //System.out.print("Tree Traversal: ");
      //Tree.traverse(Tree.root);

      endTime = System.nanoTime();
      duration = (endTime - startTime);
      treeTimes[i] = duration;
      System.out.printf("Run [%d] Tree Inserted - Time: %.3fs\n", i+1, duration / nanoConv);


    }

    System.out.println("AVL Tree Statistics");
    printStatistics(treeTimes);
    System.out.println("Quick Sort Statistice");
    printStatistics(sortTimes);



  }
  /**
   * Generates an random array
   * @param arr the array to fill up
   */
  private static void genArray(int arr[]){
    for (int i = 0; i < arr.length - 1; i++)
      arr[i] = (int) (Math.random() * (99999));
  }

  /**
   * Prints some statistics about the runs
   * @param runTimes the array with run times.
   */
  public static void printStatistics(double[] runTimes){
    //Get Min & Max
    double min = Double.MAX_VALUE;
    double max = 0;
    for(double i : runTimes){
      if(i < min)
        min = i;
      if(i > max)
        max = i;
    }

    //Get Average
    double avg = 0;
    for(double i : runTimes)
      avg += i;
    avg /= runTimes.length;
    System.out.println("-------------------");
    System.out.printf("Max Run: %.3fs ", max/nanoConv);
    System.out.printf("Min Run: %.3fs ", min/nanoConv);
    System.out.printf("Avg Run: %.3fs ", avg/nanoConv);
  }

}



