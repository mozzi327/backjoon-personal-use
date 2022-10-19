package level26_그래프와순회_.Q9_2178;


/*
문제) 미로 탐색
    N×M 크기의 배열로 표현되는 미로가 있다.

    1	0	1	1	1	1
    2	0	1	0	1	0
    3	0	1	0	1	1
    4	5	6	0	1	1
    미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다.
    이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
    한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
    위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

입력)
    첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다.
    다음 N개의 줄에는 M개의 정수로 미로가 주어진다.
    각각의 수들은 붙어서 입력으로 주어진다.

출력)
    첫째 줄에 지나야 하는 최소의 칸 수를 출력한다.
    항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean [][] visitMaze;
    static int [][] maze;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int height;
    static int width;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        maze = new int[height][width];
        visitMaze = new boolean[height][width];

        String oneLine;

        for (int i = 0; i < height; i++) {
            oneLine = br.readLine();
            for (int j = 0; j < width; j++) {
                maze[i][j] = oneLine.charAt(j) - '0';
            }
        }

        visitMaze[0][0] = true;
        maze_running(0, 0);
        System.out.println(maze[height - 1][width - 1]);


    }

    static void maze_running(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{y, x});

        int cnt = 0;
        while (!que.isEmpty()) {
            int [] cur = que.poll();
            int cy = cur[0];
            int cx = cur[1];

            // 상하좌우
            for (int i = 0; i < 4; i++) {
                int curY = cy + dy[i];
                int curX = cx + dx[i];

                if(curX < 0 || width <= curX || curY < 0 || height <= curY ) {
                    continue;
                }
                if (visitMaze[curY][curX]|| maze[curY][curX] == 0) {
                    continue;
                }

                que.add(new int[]{curY, curX});
                maze[curY][curX] = maze[cy][cx] + 1;
                visitMaze[curY][curX] = true;
            }
        }

    }
}
