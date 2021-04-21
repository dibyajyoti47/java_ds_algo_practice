package searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {-22, -15, 1, 7, 20, 35, 55};
        System.out.println(binarySearchIterative(array, 167));
        System.out.println(binarySearchRecursive(array, 176));
    }

    private static int binarySearchRecursive(int[] array, int value) {
        return binarySearchRecursive(array, 0, array.length, value);
    }

    private static int binarySearchRecursive (int[] array, int start, int end, int value) {
        if (start >= end) return -1;
        int mid = (end+start)/2;
        if (array[mid] == value) return mid;
        else if (array[mid] < value) return binarySearchRecursive(array, mid+1, end, value);
        else return binarySearchRecursive(array, start, mid, value);
    }

    private static int binarySearchIterative(int[] array, int value) {
        int start = 0;
        int end = array.length;
        while (start < end) {
            int mid = (end+start) / 2 ;
            if (array[mid] == value) return mid;
            else if (value > array[mid]) start= mid+1;
            else end=mid;
        }
        return -1;
    }
}
