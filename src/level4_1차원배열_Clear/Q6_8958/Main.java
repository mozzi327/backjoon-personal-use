package level4_1차원배열_Clear.Q6_8958;

/*
문제) OX퀴즈
    "OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다.
    O는 문제를 맞은 것이고, X는 문제를 틀린 것이다.
    문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다.
    예를 들어, 10번 문제의 점수는 3이 된다.
    "OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
    OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.

입력)
    첫째 줄에 테스트 케이스의 개수가 주어진다.
    각 테스트 케이스는 한 줄로 이루어져 있고, 길이가 0보다 크고 80보다 작은 문자열이 주어진다.
    문자열은 O와 X만으로 이루어져 있다.

출력)
    각 테스트 케이스마다 점수를 출력한다.

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
           Sudo Code)
           1. BufferedReader 를 통해 입력 값을 받는다.
           2. 첫째줄을 OX의 입력 횟수를 나타내므로 Integer형의 N을 선언해 첫째줄의 입력 값을 받는다.
           3. 결과값을 담기위한 Integer 형의 ArrayList를 선언한다.
           4. for문 안에 br.readline()을 Split 메서드를 사용하여 String 형의 배열에 담는다.
           5. 또 for문을 돌려 O의 갯수를 카운트한다.
           6. 출력
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String [] arr = br.readLine().split("");
            int cnt = 0;
            int ans = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].equals("O")) {
                    cnt += 1;
                } else {
                    cnt = 0;
                }
                ans += cnt;
            }
            answer.add(ans);
        }
        br.close();
        for (int a : answer
             ) {
            System.out.println(a);
        }
    }
}
