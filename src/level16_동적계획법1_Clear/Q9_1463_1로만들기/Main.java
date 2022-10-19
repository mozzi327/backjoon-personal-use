package level16_동적계획법1_Clear.Q9_1463_1로만들기;

/*
문제) 1로 만들기
    정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

    X가 3으로 나누어 떨어지면, 3으로 나눈다.
    X가 2로 나누어 떨어지면, 2로 나눈다.
    1을 뺀다.
    정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다.
    연산을 사용하는 횟수의 최솟값을 출력하시오.

입력
    첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.

출력
    첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
    시간 제한 : 0.15초
    메모리 제한 : 128MB
*/

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Integer[] dp;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new Integer[N+1];
        dp[0] = dp[1] = 0;

        System.out.println(makeOne(N));
    }

    private static int makeOne(int N) {
        if (dp[N] == null) {
            if (N % 6 == 0) {
                dp[N] = Math.min(makeOne(N - 1), Math.min(makeOne( N / 3), makeOne(N / 2))) + 1;
            } else if (N % 3 == 0) {
                dp[N] = Math.min(makeOne(N / 3), makeOne(N - 1)) + 1;
            } else if (N % 2 == 0) {
                dp[N] = Math.min(makeOne(N / 2), makeOne(N - 1)) + 1;
            } else {
                dp[N] = makeOne(N - 1) + 1;
            }
        }
        return dp[N];
    }
}
