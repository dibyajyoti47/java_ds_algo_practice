package sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int [] array = { 20, 35, -15, 7, 55, 1, -25 };
        quickSort(array, 0, array.length);
        Arrays.stream(array).forEach(System.out::println);
    }

    private static void quickSort(int[] array, int start, int end) {
        if(end-start < 2) return;
        int pivot = getPivot(array, start, end);
        quickSort(array, start, pivot);
        quickSort(array, pivot+1, end);
    }
    private static int getPivot(int[] array, int start, int end) {
        int pivot=array[start];
        int i=start;
        int j=end;
        while (i<j) {
            while (i<j && array[--j] > pivot);
            if (i<j) array[i]=array[j];
            while (i<j && array[++i] < pivot);
            if (i<j) array[j]=array[i];
        }
        array[j]=pivot;
        return j;
    }

}
