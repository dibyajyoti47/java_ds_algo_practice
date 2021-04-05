package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int [] array = { 20, 35, -15, 7, 55, 1, -22 };
        bubbleSort(array);
        Arrays.stream(array).forEach(System.out::println);
    }

    private static void bubbleSort(int[] array) {
        for (int luci= array.length-1; luci>=0; luci--) {
            for (int i=0;i<luci;i++) {
                if (array[i] > array[i+1]) {
                    int temp = array[i];
                    array[i]=array[i+1];
                    array[i+1] = temp;
                }
            }
        }
    }


}
