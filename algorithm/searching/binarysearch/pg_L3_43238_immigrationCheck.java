package algorithm.searching.binarysearch;

import java.util.Arrays;

/**
 * 입국심사
 * 문제 링크: https://programmers.co.kr/learn/courses/30/lessons/43238
 *
 * 문제
 * n명이 입국심사를 위해 줄을 서서 기다리고 있습니다. 각 입국심사대에 있는 심사관마다 심사하는데 걸리는 시간은 다릅니다.
 * 처음에 모든 심사대는 비어있습니다. 한 심사대에서는 동시에 한 명만 심사를 할 수 있습니다.
 * 가장 앞에 서 있는 사람은 비어 있는 심사대로 가서 심사를 받을 수 있습니다.
 * 하지만 더 빨리 끝나는 심사대가 있으면 기다렸다가 그곳으로 가서 심사를 받을 수도 있습니다.
 * 모든 사람이 심사를 받는데 걸리는 시간을 최소로 하고 싶습니다.
 *
 * 입력
 * n = 6, times = [7, 10]
 * n = 10, times = [6, 8, 10]
 * n = 6, times = [7, 10, 12, 5, 9]
 *
 * 출력
 * 28
 * 30
 * 20
 *
 * 제한사항
 * - 입국심사를 기다리는 사람은 1명 이상 1,000,000,000명 이하입니다.
 * - 각 심사관이 한 명을 심사하는데 걸리는 시간은 1분 이상 1,000,000,000분 이하입니다.
 * - 심사관은 1명 이상 100,000명 이하입니다.
 *
 * 시간 제한: 정확성 테스트 : 10초, 효율성 테스트 : 10초
 *
 * 접근 방법
 * - 탐색 범위는 1부터 (가장 긴 심사 시간 * n)까지로 설정한다.
 * - 각 시간에 모든 사람을 심사할 수 있는지 확인한다.
 * - 가능한 경우 시간을 줄이고, 불가능한 경우 시간을 늘린다.
 *
 * 알고리즘 복잡도:
 */
public class pg_L3_43238_immigrationCheck {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = (long) n * times[times.length - 1];

        while (left < right) {
            long mid = left + (right - left) / 2;
            long sum = 0;

            for (int t : times) {
                sum += mid / t;
            }

            if (sum >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main() {
        pg_L3_43238_immigrationCheck T = new pg_L3_43238_immigrationCheck();

        System.out.println(T.solution(6, new int[]{7, 10}));
        System.out.println(T.solution(6, new int[]{7, 10, 12, 5, 9}));
    }
}
