package level16_동적계획법1_Clear.Q16_12865_평범한배낭;


/*
문제) 평범한 배낭
    이 문제는 아주 평범한 배낭에 관한 문제이다.

    한 달 후면 국가의 부름을 받게 되는 준서는 여행을 가려고 한다.
    세상과의 단절을 슬퍼하며 최대한 즐기기 위한 여행이기 때문에, 가지고 다닐 배낭 또한 최대한 가치 있게 싸려고 한다.

    준서가 여행에 필요하다고 생각하는 N개의 물건이 있다.
    각 물건은 무게 W와 가치 V를 가지는데, 해당 물건을 배낭에 넣어서 가면 준서가 V만큼 즐길 수 있다.
    아직 행군을 해본 적이 없는 준서는 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다.
    준서가 최대한 즐거운 여행을 하기 위해 배낭에 넣을 수 있는 물건들의 가치의 최댓값을 알려주자.

입력)
    첫 줄에 물품의 수 N(1 ≤ N ≤ 100)과 준서가 버틸 수 있는 무게 K(1 ≤ K ≤ 100,000)가 주어진다.
    두 번째 줄부터 N개의 줄에 거쳐 각 물건의 무게 W(1 ≤ W ≤ 100,000)와 해당 물건의 가치 V(0 ≤ V ≤ 1,000)가 주어진다.

    입력으로 주어지는 모든 수는 정수이다.

출력)
    한 줄에 배낭에 넣을 수 있는 물건들의 가치합의 최댓값을 출력한다.
    시간 제한 : 2초
    메모리 제한 : 512MB

*/
import java.io.IOException;

public class Main {
    private static Integer[][] dp;
    private static int[][] wv;

    public static void main(String[] args) throws IOException {
        int N = readInt(); // 물품 갯수
        int K = readInt(); // 즌사기 버틸 수 있는 무게

        dp = new Integer[N][K + 1]; // Value의 최대 값을 dp 배열에 저장
        wv = new int[2][N]; // Weight와 Value가 담긴 2차원 배열

        for (int i = 0; i < N; i++) {
            wv[0][i] = readInt(); // 물건의 무게
            wv[1][i] = readInt(); // 물건의 가치
        }

        System.out.println(recur(N - 1, K));
    }


    private static int recur(int i, int K) {

        if (i < 0)
            return 0;

        if (dp[i][K] == null) {
            if(wv[0][i] > K) {
                dp[i][K] = recur(i - 1, K);
            } else {
                dp[i][K] = Math.max(recur(i - 1, K - wv[0][i]) + wv[1][i], recur(i - 1, K));
            }
        }
        return dp[i][K];
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

class Main2 {
    private static int N, K;
    private static int dp[];

    private static void solve(int n, int W, int V) {
        for (int i = K; i >= W; i--) {
            if (dp[i] < dp[i - W] + V) dp[i] = dp[i - W] + V;
        }
    }

    public static void main(String[] args) throws IOException{
        N = readInt();
        K = readInt();
        dp = new int[K + 1];
        for (int i = 1; i <= N; i++) {
            int w = readInt();
            int v = readInt();
            solve(i, w, v);
        }

        System.out.println(dp[K]);
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