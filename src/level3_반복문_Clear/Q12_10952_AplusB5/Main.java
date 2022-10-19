package level3_반복문_Clear.Q12_10952_AplusB5;

/*
문제) A+B - 5
    두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

입력)
    입력은 여러 개의 테스트 케이스로 이루어져 있다.
    각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다.
    (0 < A, B < 10)
    입력의 마지막에는 0 두 개가 들어온다.

출력)
    각 테스트 케이스마다 A+B를 출력한다.
*/

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if (A==0 && B== 0) {
                break;
            }
            sb.append((A+B)).append('\n');
        }

        br.close();
        System.out.println(sb);
    }
}
