package sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int [] array = { 20, 35, -15, 7, 55, 1, -23 };
        insertionSort(array);
        Arrays.stream(array).forEach(System.out::println);
    }

    private static void insertionSort(int[] array) {
        for (int luci=1; luci<array.length; luci++) {
            for (int i=luci-1;i >= 0; i--) {
                if (array[i] > array[i+1]) {
                    int temp=array[i];
                    array[i]=array[i+1];
                    array[i+1] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
