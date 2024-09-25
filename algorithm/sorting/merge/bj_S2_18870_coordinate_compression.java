package algorithm.sorting.merge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 백준 18870: 좌표 압축
 * 문제 링크: https://www.acmicpc.net/problem/18870
 *
 * 문제
 * 수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.
 * Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표 Xj의 개수와 같아야 한다.
 * X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.
 *
 * 입력
 * - 첫째 줄에 N이 주어진다. (1 ≤ N ≤ 1,000,000)
 * - 둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.
 * - 모든 Xi는 -10^9 보다 크거나 같고, 10^9보다 작거나 같은 정수이다.
 *
 * 출력
 * - 첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.
 *
 * 시간 제한: 2초
 * 메모리 제한: 512MB
 *
 * 접근 방법
 * - 시간 제한 2초로 최대값이 1,000,000 이므로 정렬에는 복잡도가 O(n^2)이 아닌 병합정렬, 퀵정렬, 힙정렬 중 사용한다.
 * - 정렬된 배열을 HashMap에 넣어 인덱스를 부여한다.
 *
 * 알고리즘 복잡도: O(n log n)
 */
public class bj_S2_18870_coordinate_compression {
    private static void compressCoordinate(int [] arr, int[] sortedArr){
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[arr.length];
        int idx = 0;

        for (int i=0; i<sortedArr.length; i++) {
            if (!map.containsKey(sortedArr[i])) {
                map.put(sortedArr[i], idx++);
            }
        }

        idx = 0;
        for (int n : arr){
            result[idx++] = map.get(n);
        }

        Arrays.stream(result).forEach(num -> System.out.print(num + " "));
    }

    private static void mergeSort(int[] arr, int[] tmp, int left, int right) {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sortedArr = new int[N];
        int[] tmp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sortedArr[i] = arr[i];
        }

        mergeSort(sortedArr, tmp, 0, sortedArr.length - 1);

        compressCoordinate(arr, sortedArr);
    }
}