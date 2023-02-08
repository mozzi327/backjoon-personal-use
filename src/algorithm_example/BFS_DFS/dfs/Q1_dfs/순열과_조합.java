package algorithm_example.BFS_DFS.dfs.Q1_dfs;

public class 순열과_조합 {

    public static void dfsRun(int max) {
        boolean[] select = new boolean[max];
        int[] arr = new int[max];
        for (int i = 0; i < arr.length; i++) arr[i] = i + 1;
        DFS(0, 0, max, arr, select);
    }

    public static void print(int[] arr, boolean[] select, int max) {
        for (int i = 0; i < max; i++) if (select[i]) System.out.print(" " + arr[i]);
        System.out.println();
    }


    public static void DFS(int idx, int cnt, int max, int[] arr, boolean[] select){
        if (cnt == 3) {
            print(arr, select, max);
            return;
        }

        for (int i = idx; i < max; i++) {
            if (select[i]) continue;
            select[i] = true;
            DFS(i, cnt + 1, max, arr, select);
            select[i] = false;
        }
    }

    public static void main(String[] args) {
        dfsRun(5);
    }
}
