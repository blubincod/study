package algorithm.sorting.insertion;

import java.util.Arrays;

public class _InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;

        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 9, 1, 5, 10, 2, 8, 6, 4};

        System.out.println(STR."정렬 전: \{Arrays.toString(arr)}");
        insertionSort(arr);
        System.out.println(STR."정렬 전: \{Arrays.toString(arr)}");
    }
}