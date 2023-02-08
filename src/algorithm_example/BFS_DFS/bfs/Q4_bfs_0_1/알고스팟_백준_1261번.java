package algorithm_example.BFS_DFS.bfs.Q4_bfs_0_1;

import java.util.LinkedList;

/**
 * 문제) <br>
 * 알고스팟 운영진이 모두 미로에 갇혔다. <br>
 * 미로는 N*M 크기이며, 총 1*1크기의 방으로 이루어져 있다. <br>
 * 미로는 빈 방 또는 벽으로 이루어져 있고, 빈 방은 자유롭게 다닐 수 있지만, 벽은 부수지 않으면 이동할 수 없다. <br>
 * <br>
 * 알고스팟 운영진은 여러명이지만, 항상 모두 같은 방에 있어야 한다. <br>
 * 즉, 여러 명이 다른 방에 있을 수는 없다.  <br>
 * 어떤 방에서 이동할 수 있는 방은 상하좌우로 인접한 빈 방이다. <br>
 * 즉, 현재 운영진이 (x, y)에 있을 때, 이동할 수 있는 방은 (x+1, y), (x, y+1), (x-1, y), (x, y-1) 이다. <br>
 * 단, 미로의 밖으로 이동 할 수는 없다. <br>
 * <br>
 * 벽은 평소에는 이동할 수 없지만, 알고스팟의 무기 AOJ를 이용해 벽을 부수어 버릴 수 있다. <br>
 * 벽을 부수면, 빈 방과 동일한 방으로 변한다. <br>
 * <br>
 * 만약 이 문제가 알고스팟에 있다면, 운영진들은 궁극의 무기 sudo를 이용해 벽을 한 번에 다 없애버릴 수 있지만, <br>
 * 안타깝게도 이 문제는 Baekjoon Online Judge에 수록되어 있기 때문에, sudo를 사용할 수 없다. <br>
 * <br>
 * 현재 (1, 1)에 있는 알고스팟 운영진이 (N, M)으로 이동하려면 벽을 최소 몇 개 부수어야 하는지 구하는 프로그램을 작성하시오. <br>
 * <br>
 * 입력) <br>
 * 첫째 줄에 미로의 크기를 나타내는 가로 크기 M, 세로 크기 N (1 ≤ N, M ≤ 100)이 주어진다. <br>
 * 다음 N개의 줄에는 미로의 상태를 나타내는 숫자 0과 1이 주어진다.  <br>
 * 0은 빈 방을 의미하고, 1은 벽을 의미한다. <br>
 * <br>
 * (1, 1)과 (N, M)은 항상 뚫려있다. <br>
 * <br>
 * 출력) <br>
 * 첫째 줄에 알고스팟 운영진이 (N, M)으로 이동하기 위해 벽을 최소 몇 개 부수어야 하는지 출력한다. <br>
 */
public class 알고스팟_백준_1261번 {

    private static void bfsRun(int[][] arr) {
        int N = arr[0].length;
        int M = arr.length;
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {-1, 0, 1, -1};
        bfs(N, M, arr, dx, dy);
    }

    private static void bfs(int N, int M, int[][] arr,
                            int[] dx, int[] dy) {
        LinkedList<int[]> deque = new LinkedList<>();
        deque.offer(new int[]{0, 0, 0});
        arr[0][0] = -1;

        int x, y, nx, ny, c;
        int[] poll;
        while (!deque.isEmpty()) {
            poll = deque.poll();;
            x = poll[0];
            y = poll[1];
            c = poll[2];

            if (x == N - 1 && y == M - 1) {
                System.out.println(c);
                return;
            }

            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (checked(nx, ny, N, M)) continue;
                if (arr[ny][nx] == 0) deque.addFirst(new int[]{nx, ny, c});
                else deque.offer(new int[]{nx, ny, c + 1});
                arr[ny][nx] = -1;
            }
        }
    }

    private static boolean checked(int nx, int ny, int N, int M) {
        return (nx < 0 || ny < 0 || nx >= N || ny >= M);
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {0, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 1},
                {1, 1, 0, 0, 0, 1},
                {0, 1, 1, 0, 1, 0},
                {1, 0, 0, 0, 1, 0}
        };
        bfsRun(arr);
    }
}
