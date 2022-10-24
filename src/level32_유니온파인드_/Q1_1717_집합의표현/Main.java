package level32_유니온파인드_.Q1_1717_집합의표현;

/*
문제) 집합의 표현
    초기에 {0}, {1}, {2}, ... {n} 이 각각 n+1개의 집합을 이루고 있다.
    여기에 합집합 연산과, 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산을 수행하려고 한다.

    집합을 표현하는 프로그램을 작성하시오.

입력)
    첫째 줄에 n(1 ≤ n ≤ 1,000,000), m(1 ≤ m ≤ 100,000)이 주어진다.
    m은 입력으로 주어지는 연산의 개수이다.
    다음 m개의 줄에는 각각의 연산이 주어진다.
    합집합은 0 a b의 형태로 입력이 주어진다.
    이는 a가 포함되어 있는 집합과, b가 포함되어 있는 집합을 합친다는 의미이다.
    두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은 1 a b의 형태로 입력이 주어진다.
    이는 a와 b가 같은 집합에 포함되어 있는지를 확인하는 연산이다.
    a와 b는 n 이하의 자연수 또는 0이며 같을 수도 있다.

출력)
    1로 시작하는 입력에 대해서 한 줄에 하나씩 YES/NO로 결과를 출력한다.
    (yes/no 를 출력해도 된다)
    시간 제한 : 2초
    메모리 제한 : 128 MB

*/

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