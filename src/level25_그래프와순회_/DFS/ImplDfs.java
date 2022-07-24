package level25_그래프와순회_.DFS;

/*
    DFS
    재귀호출을 통한 DFS 구현
    스택 선언을 통한 DFS 구현

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class ImplDfs {
    static int n, answer = 0;
    static int[][] maze;
    static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1}; // direction

    public static void DFS(int x, int y) {
        if (x==n && y==n) answer++; // 도착점
        else {
            for (int i=0; i<4; i++) {
                int nx = x+dx[i]; // next x
                int ny = y+dy[i]; // next y
                if (nx>=1 && nx<=n && ny>=1 && ny<=n && maze[nx][ny]==0) {
                    maze[x][y] = 1; // 왔던 길로 되돌아가지 않음
                    DFS(nx,ny); // 이동
                    maze[x][y] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = 7;
        maze = new int[n+1][n+1]; // 7*7 미로
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                maze[i][j] = scanner.nextInt();
            }
        }
        maze[1][1] = 1;
        DFS(1, 1);
        System.out.println(answer);
    }
}
