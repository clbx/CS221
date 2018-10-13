import java.lang.reflect.Array;

public class QuickSort {

  public static void main(String[] args) {
    int total = 0;

    for(int i = 0; i < 5; i++) {
      int arr[] = new int[10000000];
      genArray(arr);
      double startTime = System.nanoTime();
      sort(arr);
      double endTime = System.nanoTime();
      double duration = (endTime - startTime);
      System.out.printf("Array [n = %d] Sorted - Time: %.3fs\n", arr.length,duration / 1000000000);
    }

  }

  static int part(int arr[], int low, int high){

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

  static void sort(int arr[]){
    sort(arr, 0, arr.length-1);
  }

  static void sort(int arr[], int low, int high){
    if(low < high){
      int index = part(arr, low, high);


      sort(arr, low, index-1);
      sort(arr, index+1, high);
    }
  }

  static void printArray(int arr[]){
    for(int i : arr)
      System.out.print(i + " ");
  }


  static void genArray(int arr[]){
    for(int i = 0; i < arr.length-1; i++)
      arr[i] = (int)(Math.random() * (99999));
  }




}