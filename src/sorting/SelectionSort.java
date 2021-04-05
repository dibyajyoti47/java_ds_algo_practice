package sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int [] array = { 20, 35, -15, 7, 55, 1, -24 };
        selectionSort(array);
        Arrays.stream(array).forEach(System.out::println);
    }

    private static void selectionSort(int[] array) {
        for (int luci=array.length-1; luci>=0; luci--) {
           int largest=0;
           for (int i=0; i<=luci; i++) {
               if (array[largest] < array[i]) {
                  largest=i;
               }
           }
           int temp = array[luci];
           array[luci] = array[largest];
           array[largest]=temp;
        }
    }
}
