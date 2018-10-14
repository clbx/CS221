/**
 * @author buxtonc
 *
 */

public class QuickSort {

  //Divisor for
  private final static int nanoConv = 1000000000;

  /**
   * main
   */
  public static void main(String[] args) {
    int runs = 100;          //The number of runs to run
    int arrLen = 12500000;   //The number of elements in the arrays
    double runTimes[] = new double[runs];

    System.out.println("[ Quick Sort Runs ]");
    System.out.printf ("[n = %d] [Runs: %d]\n",arrLen,runs);
    System.out.println("-------------------");

    for (int i = 0; i < runs; i++) {
      int arr[] = new int[arrLen];
      genArray(arr);
      double startTime = System.nanoTime();
      sort(arr);
      double endTime = System.nanoTime();
      double duration = (endTime - startTime);
      runTimes[i] = duration;
      System.out.printf("Run [%d] Array Sorted - Time: %.3fs\n",i+1,duration / nanoConv);
    }

    printStatistics(runTimes);
  }


  /**
   * Prints some statistics about the runs
   * @param runTimes the array with run times.
   */
  private static void printStatistics(double[] runTimes){
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

  /**
   * This selects the pivot as high
   *
   * @param arr the array that will be parted
   * @param low the low limit
   * @param high the high limit
   * @return the new position of the pivot
   */
  private static int part(int arr[], int low, int high){

    int pivot = arr[high];

    int i = (low - 1);

    for(int j = low; j < high; j++){
      if(arr[j] <= pivot){
        i++;

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    int temp = arr[i+1];
    arr[i+1] = arr[high];
    arr[high] = temp;


    return i+1;
  }

  /**
   * An overload class for the sort, allowing to just give an array instead of all the parameters.
   * @param arr the array to be sorted
   */
  private static void sort(int arr[]){
    sort(arr, 0, arr.length-1);
  }

  /**
   *
   * @param arr The array to be sorted
   * @param low The low limit
   * @param high The high limit
   */
  private static void sort(int arr[], int low, int high){
    if(low < high){
      int index = part(arr, low, high);

      sort(arr, low, index-1);
      sort(arr, index+1, high);
    }
  }

  /**
   * Prints the array
   * @param arr the array to be printed
   */
  static void printArray(int arr[]){
    for(int i : arr)
      System.out.print(i + " ");
  }

  /**
   * Generates an random array
   * @param arr the array to fill up
   */
  private static void genArray(int arr[]){
    for(int i = 0; i < arr.length-1; i++)
      arr[i] = (int)(Math.random() * (99999));
  }

  /**
   * Runs one of the worst case scenarios for the quicksort.
   * @param arr the array to be filled.
   */
  private static void worstArray(int arr[]){
    for(int i = 0; i < arr.length-1; i++){
      arr[i] = 5;
    }
  }




}