package level16_동적계획법1_Clear.Q5_1912_연속합;

/*
문제) 연속합
    n개의 정수로 이루어진 임의의 수열이 주어진다.
    우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다.
    단, 수는 한 개 이상 선택해야 한다.
    예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자.
    여기서 정답은 12+21인 33이 정답이 된다.

입력)
    첫째 줄에 정수 n(1 ≤ n ≤ 100,000)이 주어지고 둘째 줄에는 n개의 정수로 이루어진 수열이 주어진다.
    수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.

출력)
    첫째 줄에 답을 출력한다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {
    static int[] dp = {};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] caseArr = new int[N];
        dp = new int[N];
        caseArr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dp[0] = caseArr[0];
        int max = caseArr[0];
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i-1] + caseArr[i], caseArr[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
