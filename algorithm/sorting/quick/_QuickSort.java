package algorithm.sorting.quick;

import java.util.Arrays;

public class _QuickSort {
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(arr, left, right);

        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            /**
             * 오른쪽에서 시작하는 이유
             * - 피벗은 왼쪽 끝에 있기 때문에 피벗보다 작은 값을 찾았을 때 바로 교환 가능.
             * - 왼쪽부터 시작 시 큰 값과 피벗이 교환될 가능성이 큼.
             */
            while (arr[j] > pivot && i < j) {
                j--;
            }

            while (arr[i] <= pivot && i < j) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, left, i);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 9, 1, 5, 10, 2, 8, 6, 4};

        System.out.println(STR."정렬 전: \{Arrays.toString(arr)}");
        quickSort(arr, 0, arr.length - 1);
        System.out.println(STR."정렬 전: \{Arrays.toString(arr)}");
    }
}

