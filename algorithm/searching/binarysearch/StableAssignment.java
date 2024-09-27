package algorithm.searching.binarysearch;

import java.util.Arrays;

/**
 * 마구간 정하기
 * 문제 링크: X
 *
 * 문제
 * N개의 마구간이 수직선상에 있습니다. 각 마구간은 x1, x2, x3, ......, xN의 좌표를 가지며, 마굿간의 좌 표가 중복되는 일은 없습니다.
 * 현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않습니다. 각 마굿간 에는 한 마리의 말만 넣을 수 있고,
 * 가장 가까운 두 말의 거리가 최대가 되게 말을 마굿간에 배치하고 싶습니다.
 * 매개변수 nums에 N개의 마굿간 좌표가 주어지고, 매개변수 c에 C가 주어지면 C마리의 말을 N개의 마 구간에 배치했을 때
 * 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 반환하는 프로그램을 작성하 세요.
 *
 * 입력
 * [1, 2, 8, 4, 9], 3
 * [9, 12, 14, 6, 7], 4
 * [5, 12, 34, 16, 18, 23, 29, 15], 7
 * [1, 3, 6, 11, 18, 27, 38, 41, 56, 73, 92, 113], 8
 *
 * 출력
 * 3
 * 2
 * 3
 * 10
 *
 * 제한사항
 * • nums의 길이는 3이상 10,000 이하입니다.
 * • nums의 원소값은 0이상 1,000,000,000 이하입니다. • C(2 <= C <= N)
 *
 * 시간 제한: 10초
 * 메모리 제한: 128MB
 *
 * 접근 방법
 * - 마구간 위치 오름차순 정렬.
 * - 배치 가능한 말의 수가 주어진 말의 수(C) 이상이면 거리를 늘리고, 그렇지 않으면 줄여 이진탐색.
 *
 * 알고리즘 복잡도: O(N lon N)
 * - 정렬: O(N log N)
 * - 이진 탐색: O(log M)
 */
public class StableAssignment {
    private static int findMaxMinStableDistance(int[] arr, int c) {
        int answer = 0;
        int left = 1;
        int right = arr.length - 1;
        int[] sortedArr = arr;

        Arrays.sort(sortedArr);

        while (left <= right) {
            int mid = (left + right) / 2;

            if (countEnableStable(sortedArr, mid) >= c) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private static int countEnableStable(int[] arr, int dist) {
        int prev = arr[0];
        int cnt = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - prev >= dist) {
                prev = arr[i];
                cnt++;
            }
        }
        return cnt;
    }

    public static void main() {
        StableAssignment T = new StableAssignment();
        System.out.println(T.findMaxMinStableDistance(new int[]{1, 2, 8, 4, 9}, 3));
        System.out.println(T.findMaxMinStableDistance(new int[]{9, 12, 14, 6, 7}, 4));
        System.out.println(T.findMaxMinStableDistance(new int[]{5, 12, 34, 16, 18, 23, 29, 15}, 7));
        System.out.println(T.findMaxMinStableDistance(new int[]{1, 3, 6, 11, 18, 27, 38, 41, 56, 73, 92, 113}, 8));
    }
}
