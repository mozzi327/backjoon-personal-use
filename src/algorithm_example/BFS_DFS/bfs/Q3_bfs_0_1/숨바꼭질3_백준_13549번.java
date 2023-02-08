package algorithm_example.BFS_DFS.bfs.Q3_bfs_0_1;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 문제) <br>
 * 수빈이는 동생과 숨바꼭질을 하고 있다. <br>
 * 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. <br>
 * 수빈이는 걷거나 순간이동을 할 수 있다. <br>
 * 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. <br>
 * 순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다. <br>
 * <br>
 * 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오. <br>
 * <br>
 * 입력) <br>
 * 첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. <br>
 * N과 K는 정수이다. <br>
 * <br>
 * 출력) <br>
 * 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다. <br>
 */
public class 숨바꼭질3_백준_13549번 {
    private static void bfs(int N, int K, int[] checked) {
        LinkedList<Integer> deque = new LinkedList<>();
        deque.offer(N);
        checked[N] = 0;
        int position;
        while (!deque.isEmpty()) {
            position = deque.poll();
            if (position == K) return;

            if (position * 2 <= 100_000 && checked[position * 2] == -1) {
                deque.addFirst(position * 2);
                checked[position * 2] = checked[position];
            }

            if (position > 0 && checked[position - 1] == -1) {
                deque.offer(position - 1);
                checked[position - 1] = checked[position] + 1;
            }

            if (position < 100_000 && checked[position + 1] == -1) {
                deque.offer(position + 1);
                checked[position + 1] = checked[position] + 1;
            }
        }
    };

    public static void main(String[] args) {
        int[] checked = new int[100_001];
        Arrays.fill(checked, -1);
        int N = 5, K = 17;
        bfs(N, K, checked);
        System.out.println(checked[K]);
    }
}
