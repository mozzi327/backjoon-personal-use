package level27_최단_경로_Clear.Q3_13549;

/*
문제) 숨바꼭질 3
    수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고,
    동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다.
    만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
    순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.
    수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

입력)
    첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다.
    N과 K는 정수이다.

출력)
    수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
    시간 제한 : 2초
    메모리 제한 : 512 MB

*/

import java.io.IOException;
import java.util.PriorityQueue;

public class Main {

    /*
        5 17
        10 17 -> 순간이동
        9 17 -> 한칸이동(1초)
        18 17 -> 순간이동
        17 17 -> 한칸이동

    */

    static class Node implements Comparable<Node> {
        int idx;
        int time;

        public Node(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }


    private static int result = 0; // 결과 값
    private static boolean[] isVisited = new boolean[100_001]; // 방문 여부

    public static void main(String[] args) throws IOException {
        int N = readInt(); // 수빈이 위치
        int K = readInt(); // 동생 위치
        bfs(N, K);

        System.out.println(result);
    }


    private static void bfs(int N, int K) {
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.offer(new Node(N, 0)); // 수빈이 출발

        while (!que.isEmpty()) {
            Node curNode = que.poll();

            // 방문 여부 체크
            isVisited[curNode.idx] = true;

            // 동생을 찾았다면 결과 값에 해당 경과 시간을 담아준 뒤 메서드를 종료한다.
            if (curNode.idx == K) {
                result = curNode.time;
                return;
            }

            // 경계조건 1 : N * 2 <= 100000, 그리고 방문여부 체크
            if (curNode.idx * 2 <= 100_000 && !isVisited[curNode.idx * 2]) {
                que.offer(new Node(curNode.idx * 2, curNode.time));
            }

            // 경계조건 2 : N + 1 <= 100000, 그리고 방문여부 체크
            if (curNode.idx + 1 <= 100_000 && !isVisited[curNode.idx + 1]) {
                que.offer(new Node(curNode.idx + 1, curNode.time + 1));
            }

            // 경계조건 3 : N - 1 >= 0, 그리고 방문여부 체크
            if (curNode.idx - 1 >= 0 && !isVisited[curNode.idx - 1]) {
                que.offer(new Node(curNode.idx - 1, curNode.time + 1));
            }
        }
    }


    private static int readInt() throws IOException {
        boolean isNegative = false;
        int value = 0;
        while (true) {
            int input = System.in.read();
            if (input == '\n' || input == ' ') {
                return (isNegative) ? -1 * value : value;
            } else if (input == '-') {
                isNegative = true;
            } else value = value * 10 + (input - 48);
        }

    }
}
