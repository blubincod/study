package algorithm.dp;
/**
 * 1, 2, 3 더하기
 * 문제 링크: https://www.acmicpc.net/problem/9095
 *
 * 문제
 * 정수 n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 문제입니다.
 *
 * 입력
 * 첫째 줄: 테스트 케이스의 개수 T
 * 다음 T개의 줄: 정수 n (1 ≤ n ≤ 11)
 *
 * 출력
 * 각 테스트 케이스마다 n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력
 *
 * 제한사항
 * - 1 ≤ n ≤ 11
 *
 * 시간 제한: 1초
 *
 * 접근 방법
 * - 다이나믹 프로그래밍을 사용합니다.
 * - 각 숫자 n에 대해 가능한 경우의 수를 저장하는 배열을 만듭니다.
 * - 점화식: dp[n] = dp[n-1] + dp[n-2] + dp[n-3]
 * - 1, 2, 3에 대한 초기값을 설정하고, 4부터 n까지 순회하며 경우의 수를 계산합니다.
 *
 * 알고리즘 복잡도: O(n)
 */
public class BJ_S3_9095_SumOf123 {
    private static int solution(int n) {
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        return dp[n];
    }

    public static void main() {
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(7));
        System.out.println(solution(10));
    }
}
