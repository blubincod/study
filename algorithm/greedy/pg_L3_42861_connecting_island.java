package algorithm.greedy;

import java.util.Arrays;

/**
 * 섬 연결하기
 * 문제 링크: https://programmers.co.kr/learn/courses/30/lessons/42861
 *
 * 문제
 * n개의 섬 사이에 다리를 건설하는 비용(costs)이 주어질 때, 최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용을 return 하도록 solution을 완성하세요.
 *
 * 입력
 * n = 4, costs = [[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]
 *
 * 출력
 * 4
 *
 * 제한사항
 * - 섬의 개수 n은 1 이상 100 이하입니다.
 * - costs의 길이는 ((n-1) * n) / 2이하입니다.
 * - 임의의 i에 대해, costs[i][0] 와 costs[i][1]에는 다리가 연결되는 두 섬의 번호가 들어있고, costs[i][2]에는 이 두 섬을 연결하는 다리를 건설할 때 드는 비용입니다.
 * - 같은 연결은 두 번 주어지지 않습니다. 또한 순서가 바뀌더라도 같은 연결로 봅니다.
 * - 모든 섬 사이의 다리 건설 비용이 주어지지 않습니다. 이 경우, 두 섬 사이의 건설이 불가능한 것으로 봅니다.
 *
 * 시간 제한: 정확성 테스트 : 10초
 *
 * 접근 방법
 * - 그래프에서 최소 신장 트리를 찾는 '크루스칼' 알고리즘 사용한다.
 * - 서로 중복되지 않는 부분 집합들로 나눠진 원소들에 대한 정보를 저장하고 조작하는 자료구조인 Union-Find (또는 Disjoint Set) 구조를 사용한다.
 * -- 두 섬이 서로 다른 집합에 속하면 두 집합을 합친다(Union) 해당 다리의 비용을 총 비용에 더한다.
 *
 * 알고리즘 복잡도: O(NlogN)
 */
public class pg_L3_42861_connecting_island {

    private int[] parent;

    private int solution(int n, int[][] costs) {
        // 간선들을 비용 기준으로 오름차순 정렬
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        // UnionFind 초기화 - 집합의 대표 원소 초기화
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int totalCost = 0;
        int edgeCount = 0;

        // 크루스칼 알고리즘 적용
        for (int[] edge : costs) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];

            if (find(from) != find(to)) {
                union(from, to);
                totalCost += cost;
                edgeCount++;
                // 모든 섬이 연결되면 종료 - 간선이 노드 보다 1 작으면 전부 연결
                if (edgeCount == n - 1) break;
            }
        }


        return totalCost;
    }

    // Find 연산 - 두 섬이 연결되었는지 확인
    private int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    // Union 연산 - 두 섬을 연결
    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) parent[y] = x;
    }

    public static void main() {
        pg_L3_42861_connecting_island T = new pg_L3_42861_connecting_island();

        System.out.println(T.solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
    }
}