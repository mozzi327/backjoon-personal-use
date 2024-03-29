package level27_최단_경로_Clear.Q5_11657_타임머신;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


/*
문제) 타임머신
    N개의 도시가 있다.
    그리고 한 도시에서 출발하여 다른 도시에 도착하는 버스가 M개 있다.
    각 버스는 A, B, C로 나타낼 수 있는데, A는 시작도시, B는 도착도시, C는 버스를 타고 이동하는데 걸리는 시간이다.
    시간 C가 양수가 아닌 경우가 있다.
    C = 0인 경우는 순간 이동을 하는 경우, C < 0인 경우는 타임머신으로 시간을 되돌아가는 경우이다.
    1번 도시에서 출발해서 나머지 도시로 가는 가장 빠른 시간을 구하는 프로그램을 작성하시오.

입력)
    첫째 줄에 도시의 개수 N (1 ≤ N ≤ 500), 버스 노선의 개수 M (1 ≤ M ≤ 6,000)이 주어진다.
    둘째 줄부터 M개의 줄에는 버스 노선의 정보 A, B, C (1 ≤ A, B ≤ N, -10,000 ≤ C ≤ 10,000)가 주어진다.

출력)
    만약 1번 도시에서 출발해 어떤 도시로 가는 과정에서 시간을 무한히 오래 전으로 되돌릴 수 있다면 첫째 줄에 -1을 출력한다.
    그렇지 않다면 N-1개 줄에 걸쳐 각 줄에 1번 도시에서 출발해 2번 도시, 3번 도시, ..., N번 도시로 가는 가장 빠른 시간을 순서대로 출력한다.
    만약 해당 도시로 가는 경로가 없다면 대신 -1을 출력한다.
    시간 제한 : 1초
    메모리 제한 : 256 MB

*/

public class Main {
    private static class Node {
        int curIdx;
        int nextIdx;
        int distance;

        public Node(int curIdx, int nextIdx, int distance) {
            this.curIdx = curIdx;
            this.nextIdx = nextIdx;
            this.distance = distance;
        }
    }

    private static int INF = Integer.MAX_VALUE;
    private static ArrayList<Node> graph = new ArrayList<>();
    private static long[] dist;


    /*
        3 4   // 도시의 갯수 N, 버스 노선의 갯수 M
        1 2 4 // 시작 도시 a, 도착 도시 b, 거리 c
        1 3 3
        2 3 -1
        3 1 -2
    */

    public static void main(String[] args) throws IOException{
        int N = readInt();
        int M = readInt();
        
        dist = new long[N + 1];

        // 노드 입력
        for (int i = 0; i < M; i++) {
            int a = readInt();
            int b = readInt();
            int c = readInt();
            
            graph.add(new Node(a, b, c));
        }

        boolean negative_cycle = bellmanFord(1, N, M);

        if (negative_cycle) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) System.out.println(-1);
                else System.out.println(dist[i]);
            }
        }
    }

    private static boolean bellmanFord(int start, int N, int M) {
        Arrays.fill(dist, INF);
        dist[start] = 0;

        // N * M 만큼 반복
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Node curNode = graph.get(j);
                if (dist[curNode.curIdx] != INF && dist[curNode.curIdx] + curNode.distance < dist[curNode.nextIdx]) {
                    dist[curNode.nextIdx] = dist[curNode.curIdx] + curNode.distance;

                    // 음수 순환이 존재
                    if (i == N - 1) return true;
                }
            }
        }

        return false;
    }


    private static int readInt() throws IOException {
        boolean isNegative = false;
        int value = 0;
        while (true) {
            int input = System.in.read();
            if (input == '\n' || input == ' ') {
                return (isNegative) ? -1 * value : value;
            } else if (input == '-') isNegative = true;
            else value = value * 10 + (input - 48);
        }

    }
}
