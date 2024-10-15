package algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 평범한 배낭
 * 문제 링크: https://www.acmicpc.net/problem/12865
 *
 * 문제
 * N개의 물건과 K 무게를 버틸 수 있는 배낭이 있을 때,
 * 가치의 합이 최대가 되도록 물건을 고르는 문제입니다.
 *
 * 입력
 * 첫째 줄: 물품의 수 N(1 ≤ N ≤ 100)과 버틸 수 있는 무게 K(1 ≤ K ≤ 100,000)
 * 다음 N개의 줄: 각 물건의 무게 W(1 ≤ W ≤ 100,000)와 해당 물건의 가치 V(0 ≤ V ≤ 1,000)
 *
 * 출력
 * 한 줄에 배낭에 넣을 수 있는 물건들의 가치합의 최댓값을 출력
 *
 * 제한사항
 * - 1 ≤ N ≤ 100
 * - 1 ≤ K ≤ 100,000
 * - 1 ≤ W ≤ 100,000
 * - 0 ≤ V ≤ 1,000
 *
 * 시간 제한: 2초
 *
 * 접근 방법
 * - 다이나믹 프로그래밍을 사용합니다.
 * - 2차원 DP 배열을 만들어 각 물건과 무게에 대한 최대 가치를 저장합니다.
 * - 타뷸레이션 방식으로 하위 문제부터 올라간다.
 * - 점화식: dp[i][j] = max(dp[i-1][j], dp[i-1][j-W[i]] + V[i])
 * - 기존에 저장된 가치와 비교하여 최대 가치를 저장한다.
 *
 * 알고리즘 복잡도: O(NK)
 */
public class BJ_G5_12865_NormalBackPack {
    private static int solution(int N, int K, int[] W, int[] V) {

        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println("물건 개수: " + N);
        System.out.println("최대 무게: " + K);
        System.out.println("무게 리스트: " + Arrays.toString(W));
        System.out.println("가치 리스트: " + Arrays.toString(V));
        System.out.println("++++++++++++++++++++++++++++++++++");

        int[][] dp = new int[N + 1][K + 1];

        System.out.println(" 0  1  2  3  4  5  6  7");
        for (int n = 1; n <= N; n++) {
            for (int w = 1; w <= K; w++) {
                if (W[n] > w) {
                    dp[n][w] = dp[n-1][w];
                } else {
                    dp[n][w] = Math.max(dp[n-1][w], dp[n-1][w-W[n]] + V[n]);
                }
            }
        }

        Arrays.stream(dp).forEach(item -> System.out.println(Arrays.toString(item)));
        System.out.println();


        return dp[N][K];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 물품의 수
        int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게

        int[] W = new int[N + 1]; // 무게 배열
        int[] V = new int[N + 1]; // 가치 배열

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, K, W, V));

        br.close();
    }
}
