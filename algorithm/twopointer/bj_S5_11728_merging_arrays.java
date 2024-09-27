package algorithm.twopointer;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 11728번: 배열 합치기
 * 문제 링크: https://www.acmicpc.net/problem/11728
 *
 * 문제
 * 정렬되어있는 두 배열 A와 B가 주어진다. 두 배열을 합친 다음 정렬해서 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * - 첫째 줄: 배열 A의 크기 N, 배열 B의 크기 M (1 ≤ N, M ≤ 1,000,000)
 * - 둘째 줄: 배열 A의 내용
 * - 셋째 줄: 배열 B의 내용
 * - 배열에 들어있는 수는 절댓값이 10^9보다 작거나 같은 정수
 *
 * 출력
 * - 두 배열을 합친 후 정렬한 결과를 출력
 *
 * 시간 제한: 1.5초
 * 메모리 제한: 256MB
 *
 * 접근 방법
 * - 정렬된 두 개의 배열을 받아서 투 포인터를 사용하여 수를 비교하여 작은 수를 새로운 배열에 추가한다.
 *
 * 알고리즘 복잡도: O(N + M)
 */
public class bj_S5_11728_merging_arrays {
    public static int[] mergeArrays(int[] A, int[] B, int N, int M){
        int[] result = new int[A.length + B.length];

        int p1 = 0, p2 = 0;
        int idx = 0;

        while (p1 < N && p2 < M) {
            if (A[p1] < B[p2]) {
                result[idx++] = A[p1++];
            } else {
                result[idx++] = B[p2++];
            }
        }

        // A 배열의 개수가 더 클 경우
        while (p1 < N) {
            result[idx++] = A[p1++];
        }

        // B 배열의 개수가 더 클 경우
        while (p2 < M) {
            result[idx++] = B[p2++];
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = mergeArrays(A, B, N, M);

        for (int i = 0; i < N + M - 1; i++) {
            bw.write(answer[i] + " ");
        }

        bw.write(answer[N + M - 1] + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
