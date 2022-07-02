package level4_1차원배열_Clear.Q4_3052;

/*
문제) 나머지
    두 자연수 A와 B가 있을 때, A%B는 A를 B로 나눈 나머지이다.
    예를 들어, 7, 14, 27, 38을 3으로 나눈 나머지는 1, 2, 0, 2이다.
    수 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구한다.
    그 다음 서로 다른 값이 몇 개 있는지 출력하는 프로그램을 작성하시오.

입력)
    첫째 줄부터 열번째 줄 까지 숫자가 한 줄에 하나씩 주어진다.
    이 숫자는 1,000보다 작거나 같고, 음이 아닌 정수이다.

출력)
    첫째 줄에, 42로 나누었을 때, 서로 다른 나머지가 몇 개 있는지 출력한다.

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        Sudo Code)
        hashMap을 통해 풀어볼 수 있을 것 같다.
        1. hashMap<Integer, Integer> 형을 선언한다.
        2. for문(10번)을 돌려서 br.readLine() % 42 한 값의 밸류를 키값으로 받고 hashMap 밸류엔 카운트 값을 넣어준다.
        4. hashMap.getOrDefault 메서드를 사용해 해당하는 키 값에 값이 없으면 0을 넣어준다.
        5. key : num % 42, value : hashMap.getOrDefault(num % 42, 0) + 1
        6. hashMap.size() 를 출력

        알게된 것
        hashMap.getOrDefault 를 사용하면 별도의 for문을 통한 초기화가 필요없다.

        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> hsMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            hsMap.put(num % 42, hsMap.getOrDefault(num % 42,0) + 1);
        }

        System.out.println(hsMap.size());
    }
}
