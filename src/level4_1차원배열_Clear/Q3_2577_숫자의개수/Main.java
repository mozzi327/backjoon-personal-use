package level4_1차원배열_Clear.Q3_2577_숫자의개수;

/*
문제) 숫자의 개수
    세 개의 자연수 A, B, C가 주어질 때 A × B × C를 계산한 결과에 0부터 9까지 각각의 숫자가
    몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.
    예를 들어 A = 150, B = 266, C = 427 이라면 A × B × C = 150 × 266 × 427 = 17037300 이 되고,
    계산한 결과 17037300 에는 0이 3번, 1이 1번, 3이 2번, 7이 2번 쓰였다.

입력)
    첫째 줄에 A, 둘째 줄에 B, 셋째 줄에 C가 주어진다.
    A, B, C는 모두 100보다 크거나 같고, 1,000보다 작은 자연수이다.

출력)
    첫째 줄에는 A × B × C의 결과에 0 이 몇 번 쓰였는지 출력한다.
    마찬가지로 둘째 줄부터 열 번째 줄까지 A × B × C의 결과에 1부터 9까지의 숫자가 각각 몇 번 쓰였는지
    차례로 한 줄에 하나씩 출력한다.

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        Sudo Code)
        hashMap 을 사용해서 cnt 를 더해보자
        1. hashMap을 선언하고 0~9의 해시맵 키 값과 기본값 cnt=0을 넣는다.
        2. BufferedReader 를 선언하여 A, B, C 값을 받고 곱한 값을 계산하여 변수에 저장한다.
        3. 변수를 char[] 배열로 저장하고 for 문을 돌려 숫자를 키값으로 가지는 공간 별로 cnt ++ 한다.
        4. hashmap 전체 출력

        알게된 것
        value를 카운트할꺼면 hashMap을 사용하자 !
        */

        HashMap<Integer, Integer> hsMap = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            hsMap.put(i, 0);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
        char[] charArr = String.valueOf(ans).toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            int idx = Integer.parseInt(String.valueOf(charArr[i]));
            hsMap.put(idx, hsMap.get(idx) + 1);
        }

        for (int i = 0; i < hsMap.size(); i++) {
            System.out.println(hsMap.get(i));
        }
    }
}
