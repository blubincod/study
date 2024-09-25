package algorithm.sorting.merge;

import java.util.Arrays;

// 선택 정렬
public class _MergeSort {
    public static void mergeSort(int[] arr, int[] tmp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, tmp, left, mid);
            mergeSort(arr, tmp, mid + 1, right);
            merge(arr, tmp, left, right, mid);
        }
    }

    private static void merge(int[] arr, int[] tmp, int left, int right, int mid) {
        int p = left;
        int q = mid + 1;
        int idx = p;

        while (p <= mid || q <= right) { // 유효범위 체크
            if (p <= mid && q <= right) {
                if (arr[p] <= arr[q]) {
                    tmp[idx++] = arr[p++];
                } else {
                    tmp[idx++] = arr[q++];
                }
            } else if (p <= mid && q > right) { // 왼편이 더 많은 경우
                tmp[idx++] = arr[p++];
            } else { // 오른편이 많은 경우
                tmp[idx++] = arr[q++];
            }
        }

        // 정렬된 임시 배열로 기존 배열을 정렬
        for (int i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 9, 1, 5, 10, 2, 8, 6, 4};
        int[] tmp = new int[arr.length];

        System.out.println(STR."정렬 전: \{Arrays.toString(arr)}");
        mergeSort(arr, tmp, 0, arr.length - 1);
        System.out.println(STR."정렬 전: \{Arrays.toString(arr)}");
    }
}