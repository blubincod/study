package algorithm.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 문제: 적록색약
 * 문제 링크: https://www.acmicpc.net/problem/10026
 *
 * 문제 설명
 * 크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다. 그림은 몇 개의 구역으로 나뉘어져 있는데,
 * 구역은 같은 색으로 이루어져 있다. 또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다.
 * (색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 한다)
 *
 * 입력
 * - 첫째 줄: 그리드의 크기 N
 * - 다음 N개의 줄: N개의 문자 (R, G, B 중 하나)
 *
 * 출력
 * - 적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의 구역의 개수
 *
 * 제한사항
 * - 1 ≤ N ≤ 100
 *
 * 접근 방법
 *
 *
 * 시간 복잡도: N x N 모두 탐색하므로 O(N^2)
 */
public class BJ_G5_10026_적록색약 {
    static int N;
    static char[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void bfs(int x, int y, boolean isColorBlind) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        char color = grid[x][y];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    if (isSameColor(color, grid[nx][ny], isColorBlind)) {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    static boolean isSameColor(char c1, char c2, boolean isColorBlind) {
        if (isColorBlind) {
            if (c1 == 'R' || c1 == 'G') {
                return c2 == 'R' || c2 == 'G';
            } else {
                return c1 == c2;
            }
        }
        return c1 == c2;
    }

    static int countRegions(boolean isColorBlind) {
        visited = new boolean[N][N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, isColorBlind);
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];

        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        int normalCount = countRegions(false);
        int colorBlindCount = countRegions(true);

        System.out.println(normalCount + " " + colorBlindCount);
    }
}
