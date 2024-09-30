package algorithm.searching.binarysearch;

import java.util.Arrays;

/**
 * 초코볼
 * 문제 링크: X
 *
 * 문제
 * 집에 초코볼 과자 봉지가 N개가 있다.
 * i번째 봉지에는 nums[i]개의 초코볼이 들어 있습니다.
 * 현수는 시간당 K개의 초코볼을 먹기로 계획하고 모든 초코볼 과자를 H시간 안에 다 먹어버리기로 작정 했습니다.
 * 현수가 시간당 몇 K개를 먹으면 H시간 안에 모든 초코볼과자를 다 먹을 수 있을까?
 * 최소개수 K를 구하는 프로그램을 작성하세요.
 *
 * 입력
 * [29, 12, 24, 5, 19], 6
 * [29, 12, 18, 5, 21], 6
 * [29, 12, 24, 5, 19, 12, 25, 23], 12
 * [29, 12, 24, 5, 19, 12, 25, 23, 82, 100], 15
 *
 * 출력
 * 3
 * 2
 * 3
 * 10
 *
 * 제한사항
 * - 각 봉지의 초코볼의 개수는 100,000를 넘지 않습니다. • nums.length<= H <= 100,000,000
 * - 1<=N<=10,000
 *
 * 시간 제한: 10초
 * 메모리 제한: 128MB
 *
 * 접근 방법
 * - 범위 내 최소개수 구하기 때문에 이진탐색을 사용한다.
 * - 이진 탐색 전 배열을 정렬한다.
 * - 각 봉지의 초코볼을 먹을 수 있는 개수로 나누어 시간 내에 H시간 내에 모든 초코볼을 먹을 수 있는지 확인한다.
 *
 * 알고리즘 복잡도: O(N lon N)
 */
public class ChocolateBall {
    private static int solution(int[] arr, int H) {
        int answer = 0;
        int[] sortedArr = arr;
        Arrays.sort(sortedArr);

        int left = sortedArr[0];
        int right = sortedArr[sortedArr.length - 1];

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossibleToEat(sortedArr, H, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private static boolean isPossibleToEat(int[] sortedArr, int H, int K) {
        int cnt = 0;

        for (int i = 0; i < sortedArr.length; i++) {
                cnt += Math.ceil((sortedArr[i] / (double)K));
            if (cnt > H) {
                return false;
            }
        }

        return true;
    }

    public static void main() {
        ChocolateBall T = new ChocolateBall();

        System.out.println(T.solution(new int[]{29, 12, 24, 5, 19}, 6));
        System.out.println(T.solution(new int[]{29, 12, 18, 5, 21}, 6));
        System.out.println(T.solution(new int[]{29, 12, 24, 5, 19, 12, 25, 23}, 12));
        System.out.println(T.solution(new int[]{29, 12, 24, 5, 19, 12, 25, 23, 82, 100}, 15));
    }
}
