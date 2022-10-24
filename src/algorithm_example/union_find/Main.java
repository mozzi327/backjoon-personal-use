package algorithm_example.union_find;

import java.io.IOException;

public class Main {
    private static void union(int y, int x, int[] parent) {
        y = find(y, parent);
        x = find(x, parent);

        if (y != x) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }

    private static int find(int x, int[] parent) {
        if (x == parent[x]) return x;
        else return parent[x] = find(parent[x], parent);
    }

    private static boolean isSameParent(int y, int x, int[] parent) {
        y = find(y, parent);
        x = find(x, parent);

        return x == y;
    }

    private static int readInt() throws IOException {
        boolean isNegative = false;
        int value = 0, input;
        while (true) {
            input = System.in.read();
            if (input == ' ' || input == '\n') {
                return (isNegative) ? -1 * value : value;
            } else if (input == '-') isNegative = true;
            else value = value * 10 + (input - 48);
        }
    }

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int M = readInt();

        int[] parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int oper = readInt();
            int a = readInt();
            int b = readInt();

            if (oper == 0) {
                union(b, a, parent);
            } else if (oper == 1) {
                result.append((isSameParent(b, a, parent) ? "YES" : "NO")).append('\n');
            }
        }

        System.out.println(result);
    }
}
