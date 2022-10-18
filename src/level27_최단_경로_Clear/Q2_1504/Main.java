package level27_최단_경로_Clear.Q2_1504;
/*
문제) 특정한 최단 경로
    방향성이 없는 그래프가 주어진다.
    세준이는 1번 정점에서 N번 정점으로 최단 거리로 이동하려고 한다.
    또한 세준이는 두 가지 조건을 만족하면서 이동하는 특정한 최단 경로를 구하고 싶은데,
    그것은 바로 임의로 주어진 두 정점은 반드시 통과해야 한다는 것이다.

    세준이는 한번 이동했던 정점은 물론, 한번 이동했던 간선도 다시 이동할 수 있다.
    하지만 반드시 최단 경로로 이동해야 한다는 사실에 주의하라. 1번 정점에서 N번 정점으로 이동할 때,
    주어진 두 정점을 반드시 거치면서 최단 경로로 이동하는 프로그램을 작성하시오.

입력)
    첫째 줄에 정점의 개수 N과 간선의 개수 E가 주어진다.
    (2 ≤ N ≤ 800, 0 ≤ E ≤ 200,000)
    둘째 줄부터 E개의 줄에 걸쳐서 세 개의 정수 a, b, c가 주어지는데,
    a번 정점에서 b번 정점까지 양방향 길이 존재하며, 그 거리가 c라는 뜻이다.
    (1 ≤ c ≤ 1,000)
    다음 줄에는 반드시 거쳐야 하는 두 개의 서로 다른 정점 번호 v1과 v2가 주어진다.
    (v1 ≠ v2, v1 ≠ N, v2 ≠ 1)
    임의의 두 정점 u와 v사이에는 간선이 최대 1개 존재한다.

출력)
    첫째 줄에 두 개의 정점을 지나는 최단 경로의 길이를 출력한다.
    그러한 경로가 없을 때에는 -1을 출력한다.
    시간 제한 : 1초
    메모리 제한 : 256MB
*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    private static int[] dist;
    private static final int INF = Integer.MAX_VALUE;
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>(); // 인근 노드를 담는 ArrayList
    
    // 노드 구현
    public static class Node implements Comparable<Node>{
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
    
    public static void main(String[] args) throws IOException{
        
        int N = readInt(); // 정점의 갯수
        int E = readInt(); // 간선의 갯수

        int start = 1;
        int end = N;

        // 정점의 갯수 + 1 만큼 그래프를 초기화
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 
        for (int i = 0; i < E; i++) {
            int a = readInt(); // 시작 정점
            int b = readInt(); // 도착 정점
            int c = readInt(); // 거리
            graph.get(a).add(new Node(b, c)); // 인근 노드 정보를 그래프에 입력
            graph.get(b).add(new Node(a, c)); // 왕복 가능하므로 반대도 입력해준다.
        }

        // start -> .... -> target1 -> .... -> target2 -> .... -> end
        // start -> .... -> target2 -> .... -> target1 -> .... -> end
        /*
            잘라서 생각해보자
            1) taget1 -> target2으로 가는 경우
            1-1) start ~ target1까지의 최단 경로 +
            1-2) target1 ~ target2까지의 최단 경로 +
            1-3) target2 ~ end까지의 최단 경로

            2) taget2 -> target1으로 가는 경우
            2-1) start ~ target2까지의 최단 경로 +
            2-2) target2 ~ target1까지의 최단 경로 +
            2-3) target1 ~ end까지의 최단 경로

            1번과 2번을 비교해서 작은 값이 특정 경로를 지나는 최단 경로가 된다.
            최단 경로를 많이 구해야하므로 메서드화해서 구해보자.
        */
        int target1 = readInt();  // 특정 노드 1
        int target2 = readInt();  // 특정 노드 2
        
        // 최소비용을 담을 배열 추가
        dist = new int[N + 1];

        long result1 = dijkstra(start, target1);
             result1 += dijkstra(target1, target2);
             result1 += dijkstra(target2, end);


        long result2 = dijkstra(start, target2);
             result2 += dijkstra(target2, target1);
             result2 += dijkstra(target1, end);

        // 둘 다 값이 없을 경우 INF 값이 됨 : -1 , 아닐 경우 둘 중 작은 값
        long ans = Math.min(result1, result2);
        if (ans >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }


    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> priorQueue = new PriorityQueue<>();
        priorQueue.offer(new Node(start, 0));
        Arrays.fill(dist, INF);
        dist[start] = 0;

        while (!priorQueue.isEmpty()) {
            Node curNode = priorQueue.poll();

            if (curNode.vertex == end) {
                return dist[end];
            }

            if (dist[curNode.vertex] < curNode.distance) continue;
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
        return dist[end];
    }


    private static int readInt() throws IOException {
        boolean isNegative = false;
        int value = 0;
        while (true) {
            int input = System.in.read();
            if (input == '\n' || input == ' ')
                return (isNegative) ? -1 * value : value;
            else if (input == '-') isNegative = true;
            else value = value * 10 + (input - 48);
        }
    }
}
