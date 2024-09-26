package algorithm.searching.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 13702번: 이상한 술집
 * 문제 링크: https://www.acmicpc.net/problem/13702
 *
 * 문제
 * 막걸리를 시키면 주전자의 용량은 똑같았으나 안에 들어 있는 막걸리 용량은 랜덤이다.
 * N 주전자를 주문하고, 자신을 포함한 친구들 K명에게 막걸리를 똑같은 양으로 나눠주려고 한다.
 * 분배 후 주전자에 막걸리가 조금 남아 있다면 그냥 막걸리를 버리기로 한다.
 * K명에게 최대한의 많은 양의 막걸리를 분배할 수 있는 용량 ml는 무엇인지 출력해주세요.
 *
 * 입력
 * - 첫 줄: 주전자의 개수 N (1 ≤ N ≤ 10,000)과 사람의 수 K (1 ≤ K ≤ 1,000,000,000)
 * - 다음 N개의 줄: 각 주전자에 들어있는 술의 양 (0 ≤ 용량 ≤ 2^31 - 1)
 * - 단, 항상 N ≤ K 이다. 즉, 주전자의 개수가 사람 수보다 많을 수는 없다.
 *
 * 출력
 * - 모든 사람이 같은 양을 마실 수 있는 최대 용량을 출력 (마실 수 없다면 0을 출력)
 *
 * 시간 제한: 1초
 * 메모리 제한: 128MB
 *
 * 접근 방법
 * - 배열이 정렬되어 있는지 확인한다.
 * - 분배한 술의 개수로 left, right의 크기를 결정한다.
 *
 * 알고리즘 복잡도: O(N log M)
 */
public class bj_S3_13702_StrangeBar {
    private static int distributeDrink(int n, int k, int[] arr) {
        int left = 1;
        int right = Arrays.stream(arr).max().getAsInt();
        int cnt = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            cnt = 0;

            // 분배한 술의 개수 저장
            for (int i = 0; i < n; i++) {
                cnt += arr[i] / mid;
            }
            if (cnt >= k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] drinkArr = new int[N];

        for (int i = 0; i < N; i++) {
            drinkArr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(distributeDrink(N, K, drinkArr));
    }

}
