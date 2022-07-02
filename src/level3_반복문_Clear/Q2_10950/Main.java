package level3_반복문_Clear.Q2_10950;

/*
문제) A+B - 3
    두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

입력)
    첫째 줄에 테스트 케이스의 개수 T가 주어진다.
    각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다.
    (0 < A, B < 10)

출력)
    각 테스트 케이스마다 A+B를 출력한다.
*/

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        // BufferedReader, Writer 사용해보기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            // StringTokenizer 를 사용하면 String을 공백을 기준으로 짜를 수 있다.
            // nextToken 을 통해 Queue에서 값을 꺼내오는 것처럼 사용할 수 있다.
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            bw.write((A + B) + "\n");
        }

        br.close();
        bw.close();
    }
}
