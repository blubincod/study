package algorithm.greedy;

/**
 * 큰 수 만들기
 * 문제 링크: https://programmers.co.kr/learn/courses/30/lessons/42883
 *
 * 문제
 * 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
 * 예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다.
 * 이 중 가장 큰 숫자는 94 입니다.
 *
 * 입력
 * number = "1924", k = 2
 * number = "1231234", k = 3
 * number = "4177252841", k = 4
 *
 * 출력
 * "94"
 * "3234"
 * "775841"
 *
 * 제한사항
 * - number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
 * - k는 1 이상 number의 자릿수 미만인 자연수입니다.
 *
 * 시간 제한: 정확성 테스트 : 10초
 *
 * 접근 방법
 * - 문자열 순서대로 최대값을 찾는다.
 *
 * 알고리즘 복잡도: n^2
 */
public class pg_L2_42883_making_big_number {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int idx = 0;
        int max;

        for (int i = 0; i < number.length() - k; i++) {
            max = 0;
            for (int j = idx; j <= k + i; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    idx = j + 1;
                }
            }
            answer.append(max);
        }

        return answer.toString();
    }

    public static void main() {
        pg_L2_42883_making_big_number T = new pg_L2_42883_making_big_number();

        System.out.println(T.solution("1924", 2));
        System.out.println(T.solution("1231234", 3));
        System.out.println(T.solution("4177252841", 4));
    }
}
