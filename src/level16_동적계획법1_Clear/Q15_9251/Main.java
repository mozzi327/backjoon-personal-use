package level16_동적계획법1_Clear.Q15_9251;


/*
문제) LCS
    LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때,
    모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.
    예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.

입력
    첫째 줄과 둘째 줄에 두 문자열이 주어진다. 문자열은 알파벳 대문자로만 이루어져 있으며,
    최대 1000글자로 이루어져 있다.

출력
    첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를 출력한다.
    시간 제한 : 0.1초(아래 참고)
        Java 8: 0.4 초
        Python 3: 2 초
        PyPy3: 2 초
        Java 8 (OpenJDK): 0.4 초
        Java 11: 0.4 초
        Kotlin (JVM): 0.4 초
        Java 15: 0.4 초
    메모리 제한 : 256MB
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    private static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] first = ("0" + br.readLine()).toCharArray();
        char[] second = ("0" + br.readLine()).toCharArray();
        dp = new int[first.length][second.length];

        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (first[i] == second[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[first.length - 1][second.length - 1]);
    }
}
