package algorithm.bfsdfs;

/**
 * 중복 순열 구하기
 *
 * 문제: 1부터 N까지 중복을 허락하여 M번 뽑아 오름차순으로 나열하라.
 *
 * 알고리즘 복잡도: O(N^M)
 */
public class DFS_중복순열 {
    static int n, m;
    static int[] pm;

    public static void DFS(int L) {
        if (L == m) {
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        else {
            for (int i = 1; i <= n; i++) {
                pm[L] = i;
                DFS(L + 1);
            }
        }
    }

    public static void main() {
        n = 3;
        m = 2;
        pm = new int[m];

        DFS(0);
    }
}
