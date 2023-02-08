package level16_동적계획법1_Clear.Q17_plus_1053;

/*
문제) 펠린드롬 공장
    팰린드롬이란, 앞에서부터 읽었을 때와, 뒤에서부터 읽었을 때가 같은 문자열이다.
    모든 문자열이 팰린드롬이 아니기 때문에 다음과 같은 4가지 연산으로 보통 문자열을 팰린드롬으로 만든다.
    문자열의 어떤 위치에 어떤 문자를 삽입 (시작과 끝도 가능)
    어떤 위치에 있는 문자를 삭제
    어떤 위치에 있는 문자를 교환
    서로 다른 문자를 교환
    1, 2, 3번 연산은 마음껏 사용할 수 있지만, 마지막 연산은 많아야 한 번 사용할 수 있다.
    문자열이 주어졌을 때, 팰린드롬으로 만들기 위해 필요한 연산의 최솟값을 출력하는 프로그램을 작성하시오.

입력)
    첫째 줄에 문자열이 주어진다. 영어 소문자로만 이루어져 있고, 길이는 최대 50이다.

출력)
    첫째 줄에 문제의 정답을 출력한다.

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static HashMap<String, Integer> palindrome = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String stringPalinedrome = br.readLine();

        System.out.println(palindromeMethod(stringPalinedrome));
    }


    public static String palindromeMethod(String str) {

        // babac
        // abbav

        // 삽입

        // 삭제

        // 문자를 교환




        return "";

    }

    // 서로 다른 문자끼리 위치 교환, 한번만 사용 가능
    static void endSwap(int firstIdx, int secondIdx, char[] palindromeCharArray) {
        char temp = palindromeCharArray[firstIdx];
        palindromeCharArray[firstIdx] = palindromeCharArray[secondIdx];
        palindromeCharArray[secondIdx] = palindromeCharArray[firstIdx];
    }
}
