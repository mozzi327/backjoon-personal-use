package level21_분할정복_Clear.Q8_11444;


/*
문제) 피보나치 수 6
    피보나치 수는 0과 1로 시작한다.
    0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다.
    그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.

    이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
    n=17일때 까지 피보나치 수를 써보면 다음과 같다.

    0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597

    n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.

입력)
    첫째 줄에 n이 주어진다.
    n은 1,000,000,000,000,000,000보다 작거나 같은 자연수이다.

출력)
    첫째 줄에 n번째 피보나치 수를 1,000,000,007으로 나눈 나머지를 출력한다.
    시간 제한 : 1초
    메모리 제한 : 256MB
*/

import java.io.IOException;

public class Main {
    private static long divValue = 1_000_000_007;

    public static void main(String[] args) throws IOException{
        long N = readLong();
        /*
         [[1 1] N
          [0 1]]
        */
        long[][] result = divideAndConquer(new long[][]{{1, 1}, {1, 0}}, N);
//        for (int i = 0; i < result.length; i++) {
//            System.out.println(Arrays.toString(result[i]));
//        }

        System.out.println(result[0][1]);
    }

    private static long[][] divideAndConquer(long[][] fivValues, long exp) {
        if (exp == 1) return fivValues;

        long half = exp / 2;
        long[][] nextFivMatrix = divideAndConquer(fivValues, half);
        nextFivMatrix = powMatrix(nextFivMatrix, nextFivMatrix);

        if (exp % 2 == 1) nextFivMatrix = powMatrix(nextFivMatrix, fivValues);
        return nextFivMatrix;
    }


    private static long[][] powMatrix(long[][] fivValues1, long[][] fivValues2) {
        long[][] powMatrix = new long[2][2];
//        for (int i = 0; i < fivValues1.length; i++) {
//            System.out.println(Arrays.toString(fivValues1[i]));
//        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    powMatrix[i][j] += fivValues1[i][k] * fivValues2[k][j];
                    powMatrix[i][j] %= divValue;
                }
            }
        }
        return powMatrix;
    }


    private static long readLong() throws IOException {
        boolean isNegative = false;
        long value = 0L;
        while (true) {
            int input = System.in.read();
            if (input == ' ' || input == '\n')
                return (isNegative) ? -1 * value : value;
            else if (input == '-') isNegative = true;
            else value = value * 10 + (input - 48);
        }

    }
}
