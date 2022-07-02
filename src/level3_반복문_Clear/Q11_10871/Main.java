package level3_반복문_Clear.Q11_10871;

/*
문제) X보다 작은 수
    정수 N개로 이루어진 수열 A와 정수 X가 주어진다.
    이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.

입력)
    첫째 줄에 N과 X가 주어진다.
    (1 ≤ N, X ≤ 10,000)
    둘째 줄에 수열 A를 이루는 정수 N개가 주어진다.
    주어지는 정수는 모두 1보다 크거나 같고, 10,000보다 작거나 같은 정수이다.

출력)
    X보다 작은 수를 입력받은 순서대로 공백으로 구분해 출력한다.
    X보다 작은 수는 적어도 하나 존재한다.

*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());


        // StringTokenizer 는 사용이 편리하지만 속도가 느림
        // split 이나 indexOf가 더 빠르다.
        // String st = br.readLine();
        // List<String> list = new ArrayList<String>();
        // int pos = 0, end;
        // while ((end = st.indexOf(' ', pos)) >= 0) {
        //      list.add(st.substring(pos, end));
        //      pos = end + 1;
        // }
        StringTokenizer stList = new StringTokenizer(br.readLine());
        List<Integer> intList = new ArrayList<Integer>();
        while (stList.hasMoreTokens()) {
            intList.add(Integer.parseInt(stList.nextToken()));
        }

        for (int i = 0; i < N; i++) {
            if (intList.get(i) < X) {
                System.out.print(intList.get(i)+" ");
            }
        }
        br.close();
        bw.close();
    }
}
