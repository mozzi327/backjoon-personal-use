package level21_분할정복_Clear.Q7_10830_행렬제곱;

/*
문제) 행렬 제곱
    크기가 N*N인 행렬 A가 주어진다.
    이때, A의 B제곱을 구하는 프로그램을 작성하시오.
    수가 매우 커질 수 있으니, A^B의 각 원소를 1,000으로 나눈 나머지를 출력한다.

입력)
    첫째 줄에 행렬의 크기 N과 B가 주어진다.
    (2 ≤ N ≤  5, 1 ≤ B ≤ 100,000,000,000)

    둘째 줄부터 N개의 줄에 행렬의 각 원소가 주어진다.
    행렬의 각 원소는 1,000보다 작거나 같은 자연수 또는 0이다.

출력)
    첫째 줄부터 N개의 줄에 걸쳐 행렬 A를 B제곱한 결과를 출력한다.
    시간 제한 : 1초
    메모리 제한 : 256 MB
*/


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        int N = readInt();
        long B = readLong();
        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // B가 1이고 원소의 값이 1000이라면 모듈러 연산을 실행 안할 수도 있음, 그에 대한 엣지 코드
                matrix[i][j] = readInt() % 1000;
            }
        }

        int[][] result = divideAndConquer(N, B, matrix);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int[][] divideAndConquer(int N, long exponent, int[][] origin) {
        if (exponent == 1L) return origin;
        long half = exponent / 2;
        int[][] conquerMatrix = divideAndConquer(N, half, origin);
        conquerMatrix = powerMatrix(N, conquerMatrix, conquerMatrix);

        if (exponent % 2 == 1) conquerMatrix = powerMatrix(N, conquerMatrix, origin);
        return conquerMatrix;
    }


    private static int[][] powerMatrix(int N, int[][] A1, int[][] A2) {

        int[][] powerOfValueMatrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    powerOfValueMatrix[i][j] += A1[i][k] * A2[k][j];
                    powerOfValueMatrix[i][j] %= 1000;
                }
            }
        }
        return powerOfValueMatrix;
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

    private static long readLong() throws IOException {
        boolean isNegative = false;
        long value = 0;
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
