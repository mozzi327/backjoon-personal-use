package level3_반복문_Clear.Q3_8393;

import java.io.*;

/*
문제) 합
    n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.

입력)
    첫째 줄에 n (1 ≤ n ≤ 10,000)이 주어진다.

출력)
    1부터 n까지 합을 출력한다.
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        for (int i = 1; i < N+1; i++) {
            ans += i;
        }
        System.out.println(ans);

        br.close();
        bw.close();
    }
}
