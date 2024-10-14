package algorithm.backtracking;

public class _backTracking {
    private static int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    private static int tab(int n) {
        int[] dp = new int[n < 2 ? 2 : n+1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    static int[] dp = new int[8];
    private static int mem(int n) {
        if (n <= 2) {
            return 1;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = mem(n - 1) + mem(n - 2);
        return dp[n];
    }

    public static void main() {
        System.out.println(fib(7)); // 피보나치
        System.out.println(tab(7)); // 타뷸레이션
        System.out.println(mem(7)); // 메모이제이션

    }
}
