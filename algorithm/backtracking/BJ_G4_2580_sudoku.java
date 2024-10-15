package algorithm.backtracking;

import java.util.Scanner;
/**
 * 스도쿠
 * 문제 링크: https://www.acmicpc.net/problem/2580
 *
 * 문제
 * 9x9 크기의 스도쿠 퍼즐을 완성하는 문제입니다.
 * 빈 칸은 0으로 표시되며, 나머지 칸은 1부터 9까지의 숫자로 채워져 있습니다.
 *
 * 입력
 * 9개의 줄에 걸쳐 9개의 숫자로 보드의 초기 상태가 주어집니다.
 *
 * 출력
 * 9개의 줄에 걸쳐 완성된 스도쿠 퍼즐을 출력합니다.
 *
 * 제한사항
 * - 빈 칸의 개수는 최대 81개입니다.
 * - 답이 여러 개 있다면 그 중 하나만 출력합니다.
 *
 * 시간 제한: 1초
 *
 * 접근 방법
 * - 백트래킹 알고리즘을 사용합니다.
 * - 빈 칸에 1부터 9까지의 숫자를 차례로 시도합니다.
 * - 행, 열, 3x3 박스에 대해 유효성을 검사합니다.
 * - 유효하지 않은 경우 즉시 백트래킹합니다.
 * - 모든 빈 칸을 채웠을 때 해답을 찾은 것으로 간주합니다.
 *
 * 알고리즘 복잡도
 */
public class BJ_G4_2580_sudoku {
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
