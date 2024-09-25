package algorithm.sorting.heap;
/**
 * 백준 15688번: 수 정렬하기 5
 * 문제 링크: https://www.acmicpc.net/problem/15688
 *
 * 문제
 * N개의 수가 주어졌을 때, 이를 비내림차순으로 정렬하는 프로그램을 작성하시오.
 *
 * 입력
 * - 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
 * - 둘째 줄부터 N개의 줄에는 숫자가 주어진다.
 * - 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되어 있을 수 있다.
 *
 * 출력
 * - 첫째 줄부터 N개의 줄에 비내림차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 *
 * 시간 제한: 10초
 * 메모리 제한: 128MB
 *
 * 접근 방법
 * - 1초에 약 1억 번의 연산을 수행한다고 가정, 최대 1,000,000개의 수를 정렬하므로<br> 복잡도가 O(n^2)이 아닌 퀵정렬, 힙정렬 중 사용한다.
 * - 퀵정렬은 O(n^2)이므로 힙정렬 사용하여 해결한다.
 *
 * 알고리즘 복잡도: O(n log n)
 */
import java.io.*;

public class bj_G5_15688_number_sort_5 {
public static void heapSort(int[] arr) {
    for (int i = arr.length / 2 - 1; i >= 0; i--) {
        heapify(arr, i, arr.length);
    }

    for (int i = arr.length - 1; i > 0; i--) {
        swap(arr, 0, i);
        heapify(arr, 0, i);
    }
}

private static void heapify(int[] arr, int parentIdx, int size) {
    int leftIdx = 2 * parentIdx + 1;
    int rightIdx = 2 * parentIdx + 2;
    int maxIdx = parentIdx;

    if (leftIdx < size && arr[maxIdx] < arr[leftIdx]) {
        maxIdx = leftIdx;
    }

    if (rightIdx < size && arr[maxIdx] < arr[rightIdx]) {
        maxIdx = rightIdx;
    }

    if (parentIdx != maxIdx) {
        swap(arr, maxIdx, parentIdx);
        heapify(arr, maxIdx, size);
    }
}

private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}


public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
        arr[i] = Integer.parseInt(br.readLine());
    }

    heapSort(arr);

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int num : arr) {
        bw.write(String.valueOf(num));
        bw.newLine();
    }
    bw.flush();
    bw.close();
    br.close();
}
}