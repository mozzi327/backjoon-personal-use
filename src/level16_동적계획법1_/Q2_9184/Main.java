package level16_동적계획법1_.Q2_9184;

/*
문제) 신나는 함수 실행
    재귀 호출만 생각하면 신이 난다! 아닌가요?
    다음과 같은 재귀함수 w(a, b, c)가 있다.

    if a <= 0 or b <= 0 or c <= 0, then w(a, b, c)
    returns: 1

    if a > 20 or b > 20 or c > 20, then w(a, b, c)
    returns: w(20, 20, 20)

    if a < b and b < c, then w(a, b, c)
    returns: w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)

    otherwise it returns:
        w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
    위의 함수를 구현하는 것은 매우 쉽다.
    하지만, 그대로 구현하면 값을 구하는데 매우 오랜 시간이 걸린다.
    (예를 들면, a=15, b=15, c=15)

    a, b, c가 주어졌을 때, w(a, b, c)를 출력하는 프로그램을 작성하시오.

입력)
    입력은 세 정수 a, b, c로 이루어져 있으며, 한 줄에 하나씩 주어진다.
    입력의 마지막은 -1 -1 -1로 나타내며, 세 정수가 모두 -1인 경우는 입력의 마지막을 제외하면 없다.

출력)
    입력으로 주어진 각각의 a, b, c에 대해서, w(a, b, c)를 출력한다.
    시간 제한 : 1초
    메모리 제한 : 128 MB

제한)
    -50 ≤ a, b, c ≤ 50

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static long[][][] dp = new long[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st;
        while (true) {
            String readLine = br.readLine();


            st = new StringTokenizer(readLine, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) break;

            result.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ");

            result.append(enjoyDp(a, b, c)).append('\n');
        }

        System.out.println(result);
    }

    public static long enjoyDp(int a, int b, int c) {
        if ((0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20) && dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        if (a <= 0 || b <= 0 || c <= 0) return 1;

        if (a > 20 || b > 20 || c > 20) {
            return dp[20][20][20] = enjoyDp(20, 20, 20);
        }

        if (a < b && b < c) {
            return dp[a][b][c] = enjoyDp(a, b, c - 1) + enjoyDp(a, b - 1, c - 1) - enjoyDp(a, b - 1, c);
        }

        return dp[a][b][c] = enjoyDp(a - 1, b, c) + enjoyDp(a - 1, b - 1, c) + enjoyDp(a - 1, b, c - 1) - enjoyDp(a - 1, b - 1, c - 1);
    }
}
