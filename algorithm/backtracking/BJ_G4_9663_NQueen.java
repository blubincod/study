package algorithm.backtracking;

import java.util.Scanner;

/**
 * N-Queen
 * 문제 링크: https://www.acmicpc.net/problem/9663
 *
 * 문제
 * N x N 크기의 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제입니다.
 * N이 주어졌을 때, 퀸을 놓는 방법의 수를 구합니다.
 *
 * 입력
 * 첫째 줄에 N이 주어집니다. (1 ≤ N < 15)
 *
 * 출력
 * 첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력합니다.
 *
 * 제한사항
 * - 1 ≤ N < 15
 *
 * 시간 제한: 10초
 *
 * 접근 방법
 * - 백트래킹 알고리즘을 사용합니다.
 * - 1차원 배열을 사용하여 각 행에 퀸의 위치를 저장합니다.
 * - 각 열과 대각선에 대해 퀸을 놓을 수 있는지 검사합니다.
 * - 유망하지 않은 경우 즉시 백트래킹합니다.
 * - 모든 행에 퀸을 놓았을 때 경우의 수를 1 증가시킵니다.
 *
 * 알고리즘 복잡도
 */
public class BJ_G4_9663_NQueen {
    static int n;
    static int[] board;
    static int cnt = 0;

    private static int solution(int row) {
        if (row == n) {
            cnt++;
            return cnt;
        }

        for (int i = 0; i < n; i++) {
            board[row] = i;

            if (isPromising(row)) {
                solution(row + 1);
            }
        }

        return cnt;
    }

    private static boolean isPromising(int row) {
        for (int i = 0; i < row; i++) {
            // 같은 열과 대각선 체크
            if (board[row] == board[i] || row - i == Math.abs(board[row] - board[i])) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        board = new int[n];

        System.out.println(solution(0));

        scanner.close();
    }
}
