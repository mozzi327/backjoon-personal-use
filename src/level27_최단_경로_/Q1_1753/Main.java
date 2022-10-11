package level27_최단_경로_.Q1_1753;

import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

/*
문제) 최단경로
    방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오.
    단, 모든 간선의 가중치는 10 이하의 자연수이다.

입력)
    첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다.
    (1 ≤ V ≤ 20,000, 1 ≤ E ≤ 300,000)
    모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정한다.
    둘째 줄에는 시작 정점의 번호 K(1 ≤ K ≤ V)가 주어진다.
    셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다.
    이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다.
    u와 v는 서로 다르며 w는 10 이하의 자연수이다.
    서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.

출력)
    첫째 줄부터 V개의 줄에 걸쳐, i번째 줄에 i번 정점으로의 최단 경로의 경로값을 출력한다.
    시작점 자신은 0으로 출력하고, 경로가 존재하지 않는 경우에는 INF를 출력하면 된다.
    시간 제한 : 1초
    메모리 제한 : 256MB

*/

public class Main {

    // 비용에 대한 정렬을 위해 Comparable을 구현
    public static class Node implements Comparable<Node> {
        public int vertex; // index
        public int distance; // 비용

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override // 비용을 기준으로 오름차순 정렬
        public int compareTo(Node node) {
            return this.distance - node.distance;
        }
    }

    public static void main(String[] args) throws IOException{
        int V, E, K;
        ArrayList<ArrayList<Node>> graph;

        V = readInt(); // 정점의 갯수
        E = readInt(); // 간선의 갯수
        K = readInt(); // 시작 정점의 번호
        graph = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = readInt(); // 출발지 u
            int v = readInt(); // 도착지 v
            int w = readInt(); // u에서 v로 가는 가중치

            // 출발지 u에서 v로 가는 가중치 w가 담긴 노드를 graph ArrayList에 담는다.
            graph.get(u).add(new Node(v, w));
        }

        int[] dist = new int[V + 1]; // 최소 비용을 갱신할 배열을 선언
        for (int i = 0; i < V + 1; i++) {
            // 최소비용 배열의 처음은 모두 INF 값으로 초기화해준다.
            dist[i] = Integer.MAX_VALUE;
        }

        // 알고리즘의 최소비용을 기준으로 추출하기 위한 priorityQueue를 선언. 노드의 comparing 메서드를 통해 최소비용 기준 정렬된 상태
        PriorityQueue<Node> priorQueue = new PriorityQueue<>();

        // 시작점 위치 K와 시작점 -> 시작점으로 가는 거리(0)을 초기값으로 priorQueue에 담아준다.
        priorQueue.offer(new Node(K, 0));

        // 시작점의 최소 거리는 0, 그에 해당하는 배열을 0으로 초기화해준다.
        dist[K] = 0;

        while (!priorQueue.isEmpty()) {
            // 정렬된 최소비용에 해당하는 노드를 하나 추출
            Node curNode = priorQueue.poll();

            // 꺼낸 엣지는 priorQueue에서 정렬되어 추출된 최소비용 노드이다.
            // 만약 꺼낸 노드가 해당 위치의 최소비용 배열에 기록된 값보다 크다면 고려할 필요가 없으므로 스킵
            // 큐는 다른 노드의 탐색을 진행한다.
            if (dist[curNode.vertex] < curNode.distance) {
                continue;
            }

            // 추출한 최소비용이 기록된 최소비용 배열의 값보다 작으므로 해당 vertax 지점의 인접 노드를 모두 고려한다.
            for (int i = 0; i < graph.get(curNode.vertex).size(); i++) {
                // 다음 노드 하나를 추출해서,
                Node nextNode =  graph.get(curNode.vertex).get(i);

                // 다음 노드의 값 + 현재 노드의 값 < 기록됙 최소비용 배열 값이므로 dist[nextNode.vertex] 값을 갱신한다.
                if (curNode.distance + nextNode.distance < dist[nextNode.vertex]) {
                    dist[nextNode.vertex] = curNode.distance + nextNode.distance;

                    // 갱신이 완료됐다면 priorQueue에 다음 노드의 위치와 갱신된 값을 queue에 담아준다.
                    // 담긴 큐는 다시 Node에 정의된 comparing 메서드에 의해 최소비용으로 정렬된다.
                    priorQueue.offer(new Node(nextNode.vertex, dist[nextNode.vertex]));
                }
            }
        }

        // 출력
        // dist가 갱신되지 않았다면(MAX_VALUE) INF 출력,
        // 아닐 경우 해당 값을 출력
        for (int i = 1; i < V + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    private static int readInt() throws IOException {
        boolean isNegative = false;
        int value = 0;
        while (true) {
            int input = System.in.read();
            if (input == ' ' || input == '\n')
                return (isNegative) ? -1 * value : value;
            else if (input == '-') isNegative = true;
            else value = value * 10 + (input - 48);
        }
    }
}
