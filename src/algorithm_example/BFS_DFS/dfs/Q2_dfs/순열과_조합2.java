package algorithm_example.BFS_DFS.dfs.Q2_dfs;

import java.util.LinkedList;

public class 순열과_조합2 {

    private static void stackDFSRun(int max, int N) {
        boolean[] select = new boolean[max];
        int[] arr = new int[max];
        for (int i = 0; i < max; i++) arr[i] = i + 1;
        LinkedList<Integer> stack = new LinkedList<>();
        dfsStack(max, N, 0, select, arr, stack);

    }

    private static void dfsStack(int max, int N, int cnt, boolean[] select,
                                 int[] arr, LinkedList<Integer> stack) {
        if (cnt == N) {
            print(stack);
            return;
        }

        for (int i = 0; i < max; i++) {
            if (select[i]) continue;
            select[i] = true;
            stack.push(arr[i]);
            dfsStack(max, N, cnt + 1, select, arr, stack);
            stack.poll();
            select[i] = false;
        }
    }

    private static void print(LinkedList<Integer> stack) {
        for (int i = stack.size() - 1; i >= 0; i--) System.out.print(" " + stack.get(i));

        System.out.println();
    }

    public static void main(String[] args) {
        stackDFSRun(5, 3);
    }
}
