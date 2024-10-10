package algorithm.dq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 쿼드트리
 * 문제 링크: https://www.acmicpc.net/problem/1992
 *
 * 문제
 * 흑백 영상을 압축하여 쿼드 트리로 표현하는 문제입니다.
 * 0은 흰 점, 1은 검은 점을 나타냅니다.
 *
 * 입력
 * 첫째 줄: 영상의 크기 N (2^k, k는 1 이상 7 이하의 자연수)
 * 둘째 줄부터 N개의 줄: 길이 N의 문자열 (0 또는 1)
 *
 * 출력
 * 영상을 압축한 결과
 *
 * 제한사항
 * - 1 ≤ N ≤ 64
 *
 * 시간 제한: 2초
 *
 * 접근 방법
 * - 한 변의 길이를 반으로 줄이면서 분할 정복을 사용한다.
 * - 범위 안의 점들이 모두 동일한 색의 점을 갖는 경우
 * -- 한 점의 값을 결과 값에 추가한다.
 * - 범위 안의 면적이 모두 동일한 색의 점을 갖는 않을 경우
 * -- 범위를 한 변의 반으로 좁힌다.
 *
 * 알고리즘 복잡도: n^2
 */
public class bj_S1_1992_quad_tree {
    private static StringBuilder result = new StringBuilder();

    private static void solution(char[][] v, int n) {
        divide(v, 0, 0, n);
    }

    private static void divide(char[][] arr, int x, int y, int size) {
        if (size == 1) {
            result.append(arr[x][y]);
            return;
        }

        int mid = size / 2;

        if (!isSamePoint(arr, x, y, size)) {
            result.append('(');
            divide(arr, x, y, mid);
            divide(arr, x, y + mid, mid);
            divide(arr, x + mid, y, mid);
            divide(arr, x + mid, y + mid, mid);
            result.append(')');
        } else {
            result.append(arr[x][y]);
        }
    }

    // 해당 범위가 같은 점인지 확인하는 함수
    private static boolean isSamePoint(char[][] arr, int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != arr[x][y]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] V = new char[N][N];

        for (int i = 0; i < N; i++) {
            V[i] = br.readLine().toCharArray();
        }

        solution(V,N);

        System.out.println(result);
    }
}
