package algorithm.dp;

import java.util.Arrays;
/**
 * 1로 만들기
 * 문제 링크: https://www.acmicpc.net/problem/1463
 *
 * 문제
 * 정수 X에 세 가지 연산을 사용하여 1을 만드는 최소 연산 횟수를 구하는 문제입니다.
 * 사용 가능한 연산:
 * 1. X가 3으로 나누어 떨어지면, 3으로 나눕니다.
 * 2. X가 2로 나누어 떨어지면, 2로 나눕니다.
 * 3. 1을 뺍니다.
 *
 * 입력
 * 첫째 줄: 정수 N (1 ≤ N ≤ 10^6)
 *
 * 출력
 * 첫째 줄: 연산을 하는 횟수의 최솟값
 *
 * 제한사항
 * - 1 ≤ N ≤ 10^6
 *
 * 시간 제한: 0.15초
 *
 * 접근 방법
 * - 다이나믹 프로그래밍을 사용합니다.
 * - 각 숫자에 대한 최소 연산 횟수를 저장하는 배열을 만듭니다.
 * - 2부터 N까지 순회하며 각 숫자에 대한 최소 연산 횟수를 계산합니다.
 * - 각 단계에서 세 가지 연산 중 가능한 것들을 시도하고 최소값을 선택합니다.
 *
 * 알고리즘 복잡도: O(N)
 */
public class BJ_S3_1463_MakeOne {
    private static int solution(int n) {
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + 1;

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3]+1);
            }

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            }

            System.out.println(Arrays.toString(dp));
        }

        return dp[n];
    }

    public static void main() {
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(5));
        System.out.println(solution(6));
    }
}
