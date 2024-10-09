package algorithm.dq;

// 분할 정복 구현
public class _DivideAndConquer {
    public static int getMax(int[] arr, int left, int right) {
        int mid = (left + right) / 2;

        if (left == right) return arr[left];

        left = getMax(arr, left, mid);
        right = getMax(arr, mid + 1, right);

        return (left > right) ? left : right;
    }

    public static void main() {
        int[] arr = new int[]{4, 2, 3, 1, 5};

        System.out.println(getMax(arr, 0, arr.length - 1));
    }
}
