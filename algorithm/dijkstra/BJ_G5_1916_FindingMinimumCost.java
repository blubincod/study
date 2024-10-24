package algorithm.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: 최소비용 구하기
 * 문제 링크: https://www.acmicpc.net/problem/1916
 *
 * 문제 설명:
 * 여러 도시와 그 도시들을 연결하는 버스가 주어졌을 때,
 * 한 도시에서 다른 도시로 가는 최소 비용을 구하는 문제입니다.
 *
 * 입력:
 * - 첫 번째 줄: 두 정수 V (도시의 개수)와 E (버스 노선의 개수)
 * - 두 번째 줄: 정수 K (출발 도시의 번호)
 * - 다음 E개의 줄: 각 버스 노선에 대한 세 개의 정수
 * - u (출발 도시), v (도착 도시), w (버스 비용)
 *
 * 출력:
 * - 출발 도시 K에서 모든 도시로 가는 최소 비용.
 * 도달할 수 없는 도시의 경우 "INF" 출력
 *
 * 접근 방법:
 * - 다익스트라 알고리즘을 구현하여 출발 도시에서 모든 도시로의 최소 비용을 계산합니다.
 *
 * 시간 복잡도:
 */
public class BJ_G5_1916_FindingMinimumCost {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


    }
}
