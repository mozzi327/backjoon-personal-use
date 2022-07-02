package level3_반복문_Clear.Q13_10951;

/*
문제) A+B - 4
    두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

입력)
    입력은 여러 개의 테스트 케이스로 이루어져 있다.
    각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다.
    (0 < A, B < 10)

출력)
    각 테스트 케이스마다 A+B를 출력한다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String n = "";

        while ((n = br.readLine()) != null) {
            st = new StringTokenizer(n);
            if(st.hasMoreTokens()) {
                sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append("\n");
            } else {
                break;
            }
        }
        br.close();
        System.out.println(sb);
    }
}
