package level6_문자열_Clear.Q2_11720_숫자의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/*
문제) 숫자의 합
    N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.

입력)
    첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.

출력)
    입력으로 주어진 숫자 N개의 합을 출력한다.

*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split("");

        System.out.println(
                Arrays.stream(tmp)
                        .mapToInt(Integer::parseInt)
                        .sum()
        );
    }
}
