package algorithm.backtracking;

import java.util.Scanner;
/**
 * 암호 만들기
 * 문제 링크: https://www.acmicpc.net/problem/1759
 *
 * 문제
 * 암호는 L개의 알파벳 소문자로 구성되며, 최소 한 개의 모음(a, e, i, o, u)과
 * 최소 두 개의 자음으로 구성되어야 합니다. 또한, 암호를 이루는 알파벳이
 * 암호에서 증가하는 순서로 배열되어야 합니다.
 *
 * 입력
 * 첫째 줄에 두 정수 L, C가 주어집니다. (3 ≤ L ≤ C ≤ 15)
 * 다음 줄에는 C개의 문자들이 공백으로 구분되어 주어집니다.
 *
 * 출력
 * 각 줄에 하나씩, 사전식으로 가능성 있는 암호를 모두 출력합니다.
 *
 * 제한사항
 * - 3 ≤ L ≤ C ≤ 15
 * - 주어지는 문자들은 알파벳 소문자이며 중복되지 않습니다.
 *
 * 시간 제한: 2초
 *
 * 접근 방법
 * - 주어진 문자들을 정렬합니다.
 * - 재귀적으로 L개의 문자를 선택합니다.
 * - 선택된 문자들이 조건(최소 한 개의 모음, 최소 두 개의 자음)을 만족하는지 확인합니다.
 * - 조건을 만족하면 암호를 출력합니다.
 * - 백트래킹을 통해 모든 가능한 조합을 탐색합니다.
 *
 * 알고리즘 복잡도
 */
public class BJ_G5_1759_CreatePassword {
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
