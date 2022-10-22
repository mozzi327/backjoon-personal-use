package level28_투_포인터_.Q5_1450_냅색문제;

/*
문제) 냅색문제
    세준이는 N개의 물건을 가지고 있고, 최대 C만큼의 무게를 넣을 수 있는 가방을 하나 가지고 있다.
    N개의 물건을 가방에 넣는 방법의 수를 구하는 프로그램을 작성하시오.

입력)
    첫째 줄에 N과 C가 주어진다. N은 30보다 작거나 같은 자연수,
    C는 109보다 작거나 같은 음이 아닌 정수이다. 둘째 줄에 물건의 무게가 주어진다.
    무게도 109보다 작거나 같은 자연수이다.

출력)
    첫째 줄에 가방에 넣는 방법의 수를 출력한다.
    시간 제한 : 1초
    메모리 제한 : 128 MB

*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static int N, C;
    private static int[] napsack;

    public static void main(String[] args) throws IOException {
        N = readInt();
        C = readInt();
        napsack = new int[N];

        for (int i = 0; i < N; i++) {
            napsack[i] = readInt();
        }

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        dfs(0, N / 2, 0, left);
        dfs(N / 2 + 1, N - 1, 0, right);

        Collections.sort(left);
        Collections.sort(right);

        int ans = 0;
        int e = right.size() - 1;

        for (int i = 0; i < left.size(); i++) {
            while (e >= 0 && left.get(i) + right.get(e) > C) {
                e--;
            }
            ans += e + 1;
        }
        System.out.println(ans);
    }

    private static void dfs(int cur, int end, int sum, ArrayList<Integer> arr) {
        if (sum > C) return;
        if (cur > end) {
            arr.add(sum);
            return;
        }
        dfs(cur + 1, end, sum, arr);
        dfs(cur + 1, end, sum + napsack[cur], arr);
    }


    private static int readInt() throws IOException {
        boolean isNegative = false;
        int value = 0;
        int input;
        while (true) {
            input = System.in.read();
            if (input == ' ' || input == '\n') {
                return (isNegative) ? -1 * value : value;
            } else if (input == '-') isNegative = true;
            else value = value * 10 + (input - 48);
        }
    }
}
