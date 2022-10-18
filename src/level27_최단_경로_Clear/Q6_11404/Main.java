package level27_최단_경로_Clear.Q6_11404;

/*
문제) 플로이드
    n(2 ≤ n ≤ 100)개의 도시가 있다.
    그리고 한 도시에서 출발하여 다른 도시에 도착하는 m(1 ≤ m ≤ 100,000)개의 버스가 있다.
    각 버스는 한 번 사용할 때 필요한 비용이 있다.

    모든 도시의 쌍 (A, B)에 대해서 도시 A에서 B로 가는데 필요한 비용의 최솟값을 구하는 프로그램을 작성하시오.

입력)
    첫째 줄에 도시의 개수 n이 주어지고 둘째 줄에는 버스의 개수 m이 주어진다.
    그리고 셋째 줄부터 m+2줄까지 다음과 같은 버스의 정보가 주어진다.
    먼저 처음에는 그 버스의 출발 도시의 번호가 주어진다.
    버스의 정보는 버스의 시작 도시 a, 도착 도시 b, 한 번 타는데 필요한 비용 c로 이루어져 있다.
    시작 도시와 도착 도시가 같은 경우는 없다.
    비용은 100,000보다 작거나 같은 자연수이다.

    시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있다.

출력)
    n개의 줄을 출력해야 한다.
    i번째 줄에 출력하는 j번째 숫자는 도시 i에서 j로 가는데 필요한 최소 비용이다.
    만약, i에서 j로 갈 수 없는 경우에는 그 자리에 0을 출력한다.
    시간 제한 : 1초
    메모리 제한 : 256 MB

*/

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int INF = Integer.MAX_VALUE;
        int N = readInt(); // 도시의 갯수
        int M = readInt(); // 버스의 갯수

        int a; // 출발 노드 인덱스
        int b; // 도착 노드 인덱스
        int c; // 비용

        long[][] dist = new long[N][N];

        // 자기 노드에서 자기 노드로 가는 경우 -> cost 0, 나머지 INF로 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                    continue;
                }
                dist[i][j] = INF;
            }
        }

        for (int i = 0; i < M; i++) {
            a = readInt() - 1;
            b = readInt() - 1;
            c = readInt();

            // 시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있다.
            // 따라서 가장 작은 값을 계속 최신화
            dist[a][b] = Math.min(dist[a][b], c);
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        StringBuilder result = new StringBuilder();

        // 출력 부분
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dist[i][j] >= INF) result.append(0).append(' ');
                else result.append(dist[i][j]).append(' ');
            }
            result.append('\n');
        }

        System.out.println(result);
    }

    private static int readInt() throws IOException {
        boolean isNegative = false;
        int value = 0;
        int input;
        while (true) {
            input = System.in.read();
            if (input == '\n' || input == ' ')
                return (isNegative) ? -1 * value : value;
            else if (input == '-') isNegative = true;
            else value = value * 10 + (input - 48);
        }
    }
}
