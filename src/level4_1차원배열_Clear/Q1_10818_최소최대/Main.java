package level4_1차원배열_Clear.Q1_10818_최소최대;

/*
문제) 최소, 최대
    N개의 정수가 주어진다.
    이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.

입력)
    첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다.
    둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다.
    모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.

출력)
    첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.

*/

/*

1차 시도)
    max = -1000000
    min = 1000000
    으로 두어 if 문으로 비교함 -> 통과는 됐는데 메모리를 100000kb나 사용함;

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {


        ArrayList<Integer> asList = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] st = br.readLine().split(" ");

        int max = -1000000;
        int min = 1000000;

        for (int i = 0; i < st.length; i++) {
            if(max <= Integer.parseInt(st[i])) {
                max = Integer.parseInt(st[i]);
            }

            if(min >= Integer.parseInt(st[i])) {
                min = Integer.parseInt(st[i]);
            }
        }
        System.out.print(min+" "+max);
    }
}
