package level6_문자열_.Q1_11654;

/*
문제)
    알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때, 주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.

입력)
    알파벳 소문자, 대문자, 숫자 0-9 중 하나가 첫째 줄에 주어진다.

출력)
    입력으로 주어진 글자의 아스키 코드 값을 출력한다.

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
    Sudo Code)
        1. BufferedReader를 통해 String의 입력 값을 받아 charAt 메서드를 사용해 Character 타입으로 변환해준다.
        2. Integer의 num 변수에 (int)st-형변환한 값을 저장하고 출력해준다.
    */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char st = br.readLine().charAt(0);
        int num = (int) st;
        System.out.println(num);
        br.close();
        int n = 4;

    }
}
