package algorithm.sorting.selection;

import java.util.Arrays;

// 선택 정렬
public class _SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 9, 1, 5, 10, 2, 8, 6, 4};

        System.out.println(STR."정렬 전: \{Arrays.toString(arr)}");
        selectionSort(arr);
        System.out.println(STR."정렬 전: \{Arrays.toString(arr)}");
    }
}