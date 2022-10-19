package level21_분할정복_Clear.Q5_11401_이항계수3;

/*
문제) 이항 계수 3
    자연수 N과 정수 K가 주어졌을 때 이항 계수
    binom{N}{K}를 1,000,000,007로 나눈 나머지를 구하는 프로그램을 작성하시오.

입력)
    첫째 줄에 N과 K가 주어진다.
    (1 ≤ N ≤ 4,000,000, 0 ≤ K ≤ N)

출력)
    binom{N}{K}를 1,000,000,007로 나눈 나머지를 출력한다.
    시간 제한 : 1초
    메모리 제한 : 256 MB

*/

import java.io.IOException;

public class Main {
    private static long P = 1_000_000_007;

    public static void main(String[] args) throws IOException {

        // 식 : N!/(K!*(N-K)!) mod P
        int N = readInt();
        int K = readInt();

        // 분자 N! mod P
        long frontValue = modularFactorial(N);

        // 분모 (K! * (N - K)!) mod P
        long fermatValue = modularFactorial(K) * modularFactorial(N - K) % P;
        System.out.println(frontValue * binomial(fermatValue, P - 2) % P);

    }

    private static long modularFactorial(int N) {
        long factorialValue = 1L;

        while (N > 1) {
            factorialValue = (factorialValue * N) % P;
            N--;
        }

        return factorialValue;
    }


    private static long binomial(long base, long exponent) {
        if (exponent == 0) return 1;
        long powerToValue = binomial(base, exponent / 2);
        long totalValue = (powerToValue * powerToValue) % P;

        if (exponent % 2 == 1) return (base * totalValue) % P;
        else return totalValue;
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
