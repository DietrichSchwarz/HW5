package edu.hillel;

/**
 * sorting methods.
 */
public class Sorter {

  /**
   * quick sort method.
   */
  public static int[] quickSort(int[] arr) {
    int start = 0;
    int end = arr.length - 1;
    quickSorter(arr, start, end);
    return arr;
  }

  private static void quickSorter(int[] arr, int start, int end) {
    if (start < end) {
      int pivotIndex = partition(arr, start, end); //pivot element
      quickSorter(arr, start, pivotIndex - 1); // recursively sort the left side
      quickSorter(arr, pivotIndex + 1, end); // recursively sort the right side
    }
  }

  private static int partition(int[] arr, int start, int end) {
    int pivot = arr[end];
    int i = start - 1;
    for (int j = start; j < end; j++) {
      if (arr[j] <= pivot) {
        i++;
        swap(arr, i, j);
      }
    }
    swap(arr, i + 1, end);
    return i + 1;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }


  /**
   * method implements cocktail sort.
   */
  public static int[] cocktailSort(int[] arr) {
    boolean swapped = true;
    int start = 0;
    int end = arr.length - 1;

    while (swapped) {
      swapped = false;

      // move items to the right
      for (int i = start; i < end; i++) {
        if (arr[i] > arr[i + 1]) {
          int temp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = temp;
          swapped = true;
        }
      }

      if (!swapped) {
        break;
      }

      swapped = false;

      // move items to the left
      end--;

      for (int i = end - 1; i >= start; i--) {
        if (arr[i] > arr[i + 1]) {
          int temp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = temp;
          swapped = true;
        }
      }

      start++;
    }
    return arr;
  }
}