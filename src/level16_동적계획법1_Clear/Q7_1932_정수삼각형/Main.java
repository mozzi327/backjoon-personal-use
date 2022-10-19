package level16_동적계획법1_Clear.Q7_1932_정수삼각형;

/*
문제) 정수 삼각형
                7
              3   8
            8   1   0
          2   7   4   4
        4   5   2   6   5
    위 그림은 크기가 5인 정수 삼각형의 한 모습이다.
    맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때,
    이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램을 작성하라.
    아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.
    삼각형의 크기는 1 이상 500 이하이다. 삼각형을 이루고 있는 각 수는 모두 정수이며, 범위는 0 이상 9999 이하이다.

입력)
    첫째 줄에 삼각형의 크기 n(1 ≤ n ≤ 500)이 주어지고, 둘째 줄부터 n+1번째 줄까지 정수 삼각형이 주어진다.

출력)
    첫째 줄에 합이 최대가 되는 경로에 있는 수의 합을 출력한다.
    시간 제한 : 2초
    메모리 제한 : 128MB

*/


import java.io.IOException;

/*class Main2 {
    private static int[][] triangle;

    public static void main(String[] args) throws IOException{
        int N = readInt();
        triangle = new int[N][];
        for (int i = 0; i < N; i++) {
            int[] tmp = new int[i+1];
            for (int j = 0; j < i+1; j++) {
                tmp[j] = readInt();
            }
            triangle[i] = tmp;
        }

//        Arrays.stream(triangle)
//                .forEach(arr -> System.out.println(Arrays.toString(arr)));

        System.out.println(maxPlusDp(N));
    }


    private static int maxPlusDp(int N) {
        if (N == 1) return triangle[0][0];

        int max = 0;

        int[][] dp = new int[N][N];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < N; i++) {
            dp[i][0] = triangle[i][0] + dp[i - 1][0];

            for (int j = 1; j < i + 1; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j - 1], dp[i-1][j]);
            }
        }

        for (int i = 0; i < N - 1; i++) {
            max = Math.max(dp[N - 1][i], max);
        }

        return max;
    }



    private static int readInt() throws IOException {
        boolean isNegative = false;
        int value = 0;
        while (true) {
            int input = System.in.read();
            if (input == ' ' || input == '\n')
                return (isNegative) ? -1 * value :
                        value;
            else if (input == '-') isNegative = true;
            else value = value * 10 + (input - 48);
        }

    }
}*/

public class Main {
    private static int[][] triangle;

    public static void main(String[] args) throws IOException {
        int N = readInt();
        triangle = new int[N][];
        for (int i = 0; i < N; i++) {
            int[] tmp = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                tmp[j] = readInt();
            }
            triangle[i] = tmp;
        }

        System.out.println(dpTriangle(N));
    }

    private static int dpTriangle(int N) {
        if (N == 0) return triangle[0][0];
        int max = 0;
        int[][] dp = new int[N][N];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < N; i++) {
            dp[i][0] = triangle[i][0] + dp[i - 1][0];
            for (int j = 1; j < i + 1; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j], dp[i-1][j-1]);
            }
        }
        for (int i = 0; i < N; i++) {
            max = Math.max(dp[N - 1][i], max);
        }

        return max;
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