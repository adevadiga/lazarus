package com.anoop.learning;

public class QuickSortMine {

    public void sort(int[] arr, int low, int high) {
        if (low < high) {
            int q = partition(arr, low, high);
            sort(arr, low, q-1);
            sort(arr, q+1, high);
        }
    }
    
    int partition(int[] arr, int low, int high) {
      int pivot = a[high];
      
      int i = low-1;
      
      for(int j = low; j <= high-1; j++) {
          if (a[j] < pivot) {
                i++;
                swap(arr, i, j);
          }
      }
      
      swap(arr, i+1, high);
      return i+1;
    
    }

}
