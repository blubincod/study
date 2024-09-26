package algorithm.searching.binarysearch;

public class _BinarySearch {
    // 반복문
    private static int iterativeBinarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    // 재귀함수
    private static int recursiveBinarySearch(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (target == arr[mid]) {
            return mid;
        } else if (target < arr[mid]) {
            return recursiveBinarySearch(arr, target, left, mid - 1);
        } else {
            return recursiveBinarySearch(arr, target, mid + 1, right);
        }
    }

    public static void main() {
        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50};

        System.out.println("Index: " + iterativeBinarySearch(arr, 30));
        System.out.println();
        System.out.println("Index: " + recursiveBinarySearch(arr, 30, 0, arr.length - 1));
    }
}
