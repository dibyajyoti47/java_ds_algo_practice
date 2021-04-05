package sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int [] array = { 20, 35, -15, 7, 55, 1, -26 };
        mergeSort(array, 0, array.length);
        Arrays.stream(array).forEach(System.out::println);
    }

    private static void mergeSort(int[] array, int start, int end) {
        if (end-start < 2) return;
        int mid = (start+end)/2;
        mergeSort(array, start, mid);
        mergeSort(array, mid, end);
        merge(array, start, mid, end);
    }

    private static void merge(int[] array, int start, int mid, int end) {
        int i = start;
        int j = mid;
        int tempidx=0;
        int[] tempArray= new int[end-start];
        while (i<mid && j<end) {
            tempArray[tempidx++]=array[i]<=array[j] ? array[i++] : array[j++];
        }
        System.arraycopy(array, i, array, start+tempidx, mid-i);
        System.arraycopy(tempArray, 0, array, start, tempidx);
    }
}
