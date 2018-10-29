/**
 * @author buxtonc
 *
 */

public class QuickSort {

  //Divisor for
  private final static int nanoConv = 1000000000;



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
  public void sort(int arr[]){
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