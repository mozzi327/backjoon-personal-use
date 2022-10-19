package level21_분할정복_Clear.Q6_2740_행렬곱셈;

/*
문제) 행렬 곱셈
    N*M크기의 행렬 A와 M*K크기의 행렬 B가 주어졌을 때, 두 행렬을 곱하는 프로그램을 작성하시오.

입력)
    첫째 줄에 행렬 A의 크기 N 과 M이 주어진다.
    둘째 줄부터 N개의 줄에 행렬 A의 원소 M개가 순서대로 주어진다.
    그 다음 줄에는 행렬 B의 크기 M과 K가 주어진다.
    이어서 M개의 줄에 행렬 B의 원소 K개가 차례대로 주어진다.
    N과 M, 그리고 K는 100보다 작거나 같고, 행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다.

출력)
    첫째 줄부터 N개의 줄에 행렬 A와 B를 곱한 행렬을 출력한다.
    행렬의 각 원소는 공백으로 구분한다.
    시간 제한 : 1초
    메모리 제한 : 128MB

*/

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        int[][] firstMatrix = input();
        int[][] secondMatrix = input();

        int row = firstMatrix.length;
        int col = firstMatrix[0].length;
        System.out.println(resultMatrix(firstMatrix, secondMatrix));
    }


    private static StringBuilder resultMatrix(int[][] A, int[][] B) {
        StringBuilder sb = new StringBuilder();
        int col = A[0].length;
        for (int i = 0; i < A.length; i++) {
            int tmp = 0;
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < B.length; k++) {
                    tmp += A[i][k] * B[k][j];
                }
                if (j == 0) sb.append(tmp);
                else sb.append(' ').append(tmp);
                tmp = 0;
            }
            sb.append('\n');
        }
        return sb;
    }


    private static int[][] input() throws IOException {
        int[][] makeMatrix;
        int row = readInt();
        int col = readInt();
        makeMatrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                makeMatrix[i][j] = readInt();
            }
        }

        return makeMatrix;
    }

    private static int readInt() throws IOException {
        boolean isNegative = false;
        int value = 0;
        while (true) {
            int input = System.in.read();
            if (input == ' ' || input == '\n') {
                return (isNegative) ? -1 * value :
                        value;
            } else if (input == '-') isNegative = true;
            else value = value * 10 + (input - 48);
        }
    }
}
