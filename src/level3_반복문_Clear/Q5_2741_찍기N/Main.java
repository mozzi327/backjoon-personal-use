package level3_반복문_Clear.Q5_2741_찍기N;

/*
문제) N 찍기
    자연수 N이 주어졌을 때, 1부터 N까지 한 줄에 하나씩 출력하는 프로그램을 작성하시오.

입력)
    첫째 줄에 100,000보다 작거나 같은 자연수 N이 주어진다.

출력)
    첫째 줄부터 N번째 줄 까지 차례대로 출력한다.

*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = i+1;
            bw.write(num +"\n");
        }

        br.close();
        bw.close();

    }
}
