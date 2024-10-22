package algorithm.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 다익스트라 - 우선순위 큐 사용
public class BJ_G4_1753_ShortestPath {
    static class Node {
        int to;
        int weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + this.to + ", " + this.weight + ")";
        }
    }

    public static void dijkstra(int v, int[][] data, int start) {
        // 그래프 구현
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < data.length; i++) {
            graph.get(data[i][0]).add(new Node(data[i][1], data[i][2]));
        }

        System.out.println("그래프 확인");
        System.out.println("+++++++++++++++++++");
        for (int i = 1; i < graph.size(); i++) {
            System.out.println("Node" + i + " " + graph.get(i));
        }
        System.out.println("+++++++++++++++++++");

        int[] dist = new int[v + 1];

        for (int i = 1; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;

        // 우선 순위 큐 (가중치 오름차순)
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);

        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (dist[curNode.to] < curNode.weight) {
                continue;
            }

            for (Node adjNode : graph.get(curNode.to)) {
                if (dist[curNode.to] + adjNode.weight < dist[adjNode.to]) {
                    dist[adjNode.to] = dist[curNode.to] + adjNode.weight;
                    pq.offer(new Node(adjNode.to, dist[adjNode.to]));
                }
            }
        }
        for(int i= 1; i<dist.length; i++){
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(dist[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수

        int start = Integer.parseInt(br.readLine()); // 시작 정점

        int[][] data = new int[E][3];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
            data[i][2] = Integer.parseInt(st.nextToken());
        }

        dijkstra(V, data, start);
    }
}

/*
static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + to + ", " + weight + ")";
        }
    }

    public static void dijkstra(int v, int[][] data, int start) {
        // 그래프 구성
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < data.length; i++) {
            graph.get(data[i][0]).add(new Node(data[i][1], data[i][2]));
        }

        // 그래프 확인
        for (int i = 1; i < graph.size(); i++) {
            System.out.println("Node " + i + ": " + graph.get(i));
        }

        int[] dist = new int[v + 1];

        for (int i = 1; i < v + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // 자기 자신 위치 초기화
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (dist[curNode.to] < curNode.weight) {
                continue;
            }

            for (Node adjNode : graph.get(curNode.to)) {
                if (dist[curNode.to] + adjNode.weight < dist[adjNode.to]) {
                    dist[adjNode.to] = dist[curNode.to] + adjNode.weight;
                    pq.offer(new Node(adjNode.to, dist[adjNode.to]));
                }
            }
        }

        // 결과 출력
        for (int i = 1; i < v + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i] + " ");
            }
        }
    }
 */