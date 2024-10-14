package algorithm.dp;

import java.util.Arrays;

/**
 문제 설명:
 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지입니다
 X가 3으로 나누어 떨어지면, 3으로 나눕니다.
 X가 2로 나누어 떨어지면, 2로 나눕니다.
 1을 뺍니다.
 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 합니다. 연산을 사용하는 횟수의 최솟값을 출력하세요.
 */
public class practice {
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
