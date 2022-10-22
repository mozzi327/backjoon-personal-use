package level15_백트래킹_.Q2_15650_N과Mver2;

/*
문제) N과 M (2)
    자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

    1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
    고른 수열은 오름차순이어야 한다.

입력)
    첫째 줄에 자연수 N과 M이 주어진다.
    (1 ≤ M ≤ N ≤ 8)

출력)
    한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다.
    중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

    수열은 사전 순으로 증가하는 순서로 출력해야 한다.
    시간 제한 : 1초
    메모리 제한 : 512 MB

*/


import java.io.IOException;

public class Main {
    private static int[] tracking;
    private static final StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int N = readInt();
        int M = readInt();

        tracking = new int[M];
        recur(1,0, N, M);
        System.out.println(result);
    }

    private static void recur(int at, int depth, int N, int M) {
        if (depth == M) {
            for (int val : tracking) {
                result.append(val).append(' ');
            }
            result.append('\n');
            return;
        }

        for (int i = at; i <= N; i++) {
            tracking[depth] = i;
            recur(i + 1, depth + 1, N, M);
        }
    }

    private static int readInt() throws IOException {
        boolean isNegative = false;
        int value = 0;
        int input;
        while (true) {
            input = System.in.read();
            if (input == ' ' || input == '\n') {
                return (isNegative) ? -1 * value : value;
            } else if (input == '-') {
                isNegative = true;
            } else value = value * 10 + (input - 48);
        }
    }
}
