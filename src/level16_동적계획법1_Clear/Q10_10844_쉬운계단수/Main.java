package level16_동적계획법1_Clear.Q10_10844_쉬운계단수;

import java.io.IOException;

/*
문제) 쉬운 계단 수
    45656이란 수를 보자.
    이 수는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다.
    N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구해보자. 0으로 시작하는 수는 계단수가 아니다.

입력)
    첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.

출력)
    첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.
    시간 제한 : 1초
    메모리 제한 : 256MB

*/
public class Main {

    private static Long[][] dp;
    private static int mod = 1000000000;

    public static void main(String[] args) throws IOException{
        long result = 0;

        int N = readInt();
        dp = new Long[N + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        for (int i = 1; i <= 9; i++) {
            result += recur(N, i);
        }

        System.out.println(result % mod);
    }

    private static long recur(int digit, int val) {
        if (digit == 1) {
            return dp[digit][val] % mod;
        }

        if (dp[digit][val] == null) {
            if (val == 0) {
                dp[digit][val] = recur(digit - 1, 1);
            } else if (val == 9) {
                dp[digit][val] = recur(digit -1, 8);
            }
            else {
                dp[digit][val] = recur(digit - 1, val - 1) + recur(digit - 1, val + 1);
            }
        }
        return dp[digit][val] % mod;
    }

    private static int readInt() throws IOException {
        boolean isNegative = false;
        int value = 0;
        while (true) {
            int input = System.in.read();
            if (input == '\n' || input == ' ')
                return (isNegative) ? -1 * value : value;
            else if (input == '-') isNegative = true;
            else value = value * 10 + (input - 48);
        }

    }
}
