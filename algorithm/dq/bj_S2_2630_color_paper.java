package algorithm.dq;

import java.util.Arrays;

/**
 * 색종이 만들기
 * 문제 링크: https://www.acmicpc.net/problem/2630
 *
 * 문제
 * 주어진 N x N 크기의 종이를 같은 색으로 이루어진 가장 큰 정사각형 색종이로 자르는 문제입니다.
 * 하얀색으로 칠해진 칸은 0, 파란색으로 칠해진 칸은 1로 주어집니다.
 *
 * 입력
 * 첫째 줄: 전체 종이의 한 변의 길이 N (2^k, k는 1 이상 7 이하의 자연수)
 * 둘째 줄부터 N개의 줄: 각 가로줄의 정사각형 색 (0 또는 1)
 *
 * 출력
 * 첫째 줄: 잘라진 하얀색 색종이의 개수
 * 둘째 줄: 잘라진 파란색 색종이의 개수
 *
 * 제한사항
 * - 2 ≤ N ≤ 128
 *
 * 시간 제한: 1초
 *
 * 접근 방법
 * - 전체 종이가 같은 색 아닌지 확인한다.
 * - 색깔이 다르다면 한 변의 절반으로 분할 정복을 시작한다.
 * - 색깔이 같은 정사각형을 찾으면 카운트를 한다.
 *
 * 알고리즘 복잡도: n^2
 */
public class bj_S2_2630_color_paper {
    private int white = 0;
    private int blue = 0;

    private void solution(int N, int[][] P) {
        Arrays.stream(P).forEach(x -> System.out.println(Arrays.toString(x)));

        findPaperAmount(P, 0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    private void findPaperAmount(int[][] paper, int x, int y, int size) {
        int mid = size / 2;

        if (size == 1) {
            if (paper[x][y] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        // 같은 색인지 확인
        if (!isSameColor(paper, x, y, size)) {
            findPaperAmount(paper, x, y, mid);
            findPaperAmount(paper, x + mid, y, mid);
            findPaperAmount(paper, x + mid, y + mid, mid);
            findPaperAmount(paper, x, y + mid, mid);
        } else {
            if (paper[x][y] == 0) {
                white++;
            } else {
                blue++;
            }
        }
    }

    // 정사각형의 색깔이 같은지 검사하는 함수
    private boolean isSameColor(int[][] paper, int x, int y, int size) {
        int color = paper[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main() {
        int N = 8;
        int[][] P = {
                {1, 1, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1}
        };

        bj_S2_2630_color_paper T = new bj_S2_2630_color_paper();

        T.solution(N, P);
    }
}
