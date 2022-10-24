package level15_백트래킹_Clear.Q5_9663_NQueen;

/*
문제) N-Queen
    N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
    N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

입력)
    첫째 줄에 N이 주어진다. (1 ≤ N < 15)

출력)
    첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.
    시간 제한 : 10초
    메모리 제한 : 128 MB

*/

import java.io.IOException;

public class Main {
    private static int[] board = new int[15];

    private static int count = 0;

    public static void main(String[] args) throws IOException{
        int N = readInt();
        nQueen(0, N);
        System.out.println(count);
    }

    private static void nQueen(int depth, int N) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            board[depth] = i;
            if (promising(depth)) {
                nQueen(depth + 1, N);
            }
        }
    }

    private static boolean promising(int depth) {
        for (int i = 0; i < depth; i++) {
            if (board[depth] == board[i] || depth - i == Math.abs(board[depth] - board[i]))
                return false;
        }
        return true;
    }




    private static int readInt() throws IOException {
        boolean isNegative = false;
        int value = 0;
        int input;
        while (true) {
            input = System.in.read();
            if (input == '\n' || input == ' ') {
                return (isNegative) ? -1 * value : value;
            } else if (input == '-') isNegative = true;
            else value = value * 10 + (input - 48);
        }
    }
}
