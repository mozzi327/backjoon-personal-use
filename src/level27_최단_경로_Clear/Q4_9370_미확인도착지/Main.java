package level27_최단_경로_Clear.Q4_9370_미확인도착지;

/*
문제) 미확인 도착지
    (취익)B100 요원,
    요란한 옷차림을 한 서커스 예술가 한 쌍이 한 도시의 거리들을 이동하고 있다.
    너의 임무는 그들이 어디로 가고 있는지 알아내는 것이다.
    우리가 알아낸 것은 그들이 s지점에서 출발했다는 것, 그리고 목적지 후보들 중 하나가 그들의 목적지라는 것이다.
    그들이 급한 상황이기 때문에 목적지까지 우회하지 않고 최단거리로 갈 것이라 확신한다. 이상이다. (취익)

    어휴! (요란한 옷차림을 했을지도 모를) 듀오가 어디에도 보이지 않는다.
    다행히도 당신은 후각이 개만큼 뛰어나다.
    이 후각으로 그들이 g와 h 교차로 사이에 있는 도로를 지나갔다는 것을 알아냈다.

    이 듀오는 대체 어디로 가고 있는 것일까?
    예제 입력의 두 번째 케이스를 시각화한 것이다.
    이 듀오는 회색 원에서 두 검은 원 중 하나로 가고 있고 점선으로 표시된 도로에서 냄새를 맡았다.
    따라서 그들은 6으로 향하고 있다.

입력)
    첫 번째 줄에는 테스트 케이스의 T(1 ≤ T ≤ 100)가 주어진다.
    각 테스트 케이스마다
    첫 번째 줄에 3개의 정수 n, m, t (2 ≤ n ≤ 2 000, 1 ≤ m ≤ 50 000 and 1 ≤ t ≤ 100)가 주어진다.
    각각 교차로, 도로, 목적지 후보의 개수이다.
    두 번째 줄에 3개의 정수 s, g, h (1 ≤ s, g, h ≤ n)가 주어진다.
    s는 예술가들의 출발지이고, g, h는 문제 설명에 나와 있다. (g ≠ h)
    그 다음 m개의 각 줄마다 3개의 정수 a, b, d (1 ≤ a < b ≤ n and 1 ≤ d ≤ 1 000)가 주어진다.
    a와 b 사이에 길이 d의 양방향 도로가 있다는 뜻이다.
    그 다음 t개의 각 줄마다 정수 x가 주어지는데, t개의 목적지 후보들을 의미한다.
    이 t개의 지점들은 서로 다른 위치이며 모두 s와 같지 않다.
    교차로 사이에는 도로가 많아봐야 1개이다.
    m개의 줄 중에서 g와 h 사이의 도로를 나타낸 것이 존재한다.
    또한 이 도로는 목적지 후보들 중 적어도 1개로 향하는 최단 경로의 일부이다.

출력)
    테스트 케이스마다 입력에서 주어진 목적지 후보들 중
    불가능한 경우들을 제외한 목적지들을 공백으로 분리시킨 오름차순의 정수들로 출력한다.
    시간 제한 : 3초
    메모리 제한 : 256 MB

*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    /*
        2 -> 테스트 케이스 갯수
        n : 교차로 갯수, m : 도로 갯수, t : 목적지 후보 갯수
        5 4 2(n, m, t)
        s : 예술가들의 출발지점, g : Target1, h : Target2
        1 2 3(s, g, h)

        ---- m개의 양방향 도로
        a : 출발 노드 인덱스, b : 도착 노드 인덱스, d : 구간의 거리
        1 2 6 (a, b, d)
        2 3 2
        3 4 4
        3 5 3
        ---- m개의 양방향 도로

        ---- t개의 목적지 후보
        5
        4
        ---- t개의 목적지 후보

        ---- Test Case 2 start...
        6 9 2
        2 3 1
        1 2 1
        1 3 3
        2 4 4
        2 5 5
        3 4 3
        3 6 2
        4 5 4
        4 6 3
        5 6 7
        5
        6

    */

    // 노드 선언

    static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }


    private static int[] dist;
    private static final int INF = Integer.MAX_VALUE;
    private static ArrayList<ArrayList<Node>> graph; // 인근 노드를 저장할 graph
    private static PriorityQueue<Node> priorQueue; // Node 타입의 PriorityQueue 선언


    public static void main(String[] args) throws IOException {
        int testCase = readInt();
        StringBuilder result = new StringBuilder(); // 결과 값을 저장해 출력한 StringBuilder 선언

        int N; // 교차로 갯수
        int M; // 도로 갯수
        int T; // 목적지 후보 갯수

        int s; // 예술가 출발 노드

        // g ~ h 사이의 도로
        // 이 도로는 목적지 후보들 중 적어도 1개로 향하는 최단 경로의 일부
        // ex 4 ~ 6 : 4, 5, 6 -> 4, 5, 6 을 모두 거쳐야한다는 뜻인가
        int g;
        int h;

        int a; // 출발 노드
        int b; // 도착 노드
        int c; // a와 b의 거리

        int candidate; // 목적지 후보 변수
        for (int i = 0; i < testCase; i++) {
            N = readInt();
            M = readInt();
            T = readInt();

            dist = new int[N + 1]; // dist 초기화
            graph = new ArrayList<>(); // graph 초기화

            // 예술가 출발 노드
            s = readInt();

            // 필수 교차로 범위 g ~ h
            g = readInt();
            h = readInt();

            // graph 초기화
            for (int j = 0; j < N + 1; j++) {
                graph.add(new ArrayList<>());
            }

            // 노드 입력
            for (int j = 0; j < M; j++) {
                a = readInt();
                b = readInt();
                c = readInt();

                graph.get(a).add(new Node(b, c));
                graph.get(b).add(new Node(a, c)); // 양방향이므로 둘 다 넣어준다.
            }

            PriorityQueue<Integer> sortQue = new PriorityQueue<>();

            // 목적지 후보 입력받기
            for (int j = 0; j < T; j++) {
                candidate = readInt();
                int result1 = dijkstra(s, g) + dijkstra(g, h) + dijkstra(h, candidate); // g -> h를 거치는 경우
                int result2 = dijkstra(s, h) + dijkstra(h, g) + dijkstra(g, candidate); // h -> g를 거치는 경우
                int result3 = dijkstra(s, candidate); // 최종 목적지 최소비용과 위의 값과 비교

                int minValue = Math.min(result1, result2);
                if (minValue == result3) {
                    sortQue.offer(candidate);
                }
            }
            while (!sortQue.isEmpty()) {
                result.append(sortQue.poll()).append(' ');
            }

            result.append('\n');
        }

        System.out.println(result);
    }


    private static int dijkstra(int start, int end) {
        priorQueue = new PriorityQueue<>(); // PriorityQueue 초기화
        priorQueue.offer(new Node(start, 0)); // 시작 노드 입력
        Arrays.fill(dist, INF);
        dist[start] = 0;
        while (!priorQueue.isEmpty()) {
            Node curNode = priorQueue.poll();
            int curVertex = curNode.vertex;
            int curDist = curNode.distance;

            if (curVertex == end) {
                return dist[end];
            }

            if (dist[curVertex] < curDist) continue;

            ArrayList<Node> nodes = graph.get(curVertex);

            for (int i = 0; i < nodes.size(); i++) {
                Node purlNode = nodes.get(i);
                if (purlNode.distance + curDist < dist[purlNode.vertex]) {
                    dist[purlNode.vertex] = purlNode.distance + curDist;

                    priorQueue.offer(new Node(purlNode.vertex, dist[purlNode.vertex]));
                }
            }
        }
        return dist[end];
    }


    private static int readInt() throws IOException {
        boolean isNegative = false;
        int value = 0;
        int input;
        while (true) {
            input = System.in.read();
            if (input == '\n' || input == ' ') {
                return (isNegative) ? -1 * value : value;
            } else if (input == '-') {
                isNegative = true;
            } else value = value * 10 + (input - 48);
        }
    }
}
