package level4_1차원배열_Clear.Q2_2562;

/*
문제) 최댓값
    9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성하시오.
    예를 들어, 서로 다른 9개의 자연수
    3, 29, 38, 12, 57, 74, 40, 85, 61
    이 주어지면, 이들 중 최댓값은 85이고 이 값은 8번째 수이다.

입력)
    첫째 줄부터 아홉 번째 줄까지 한 줄에 하나의 자연수가 주어진다.
    주어지는 자연수는 100 보다 작다.

출력)
    첫째 줄에 최댓값을 출력하고, 둘째 줄에 최댓값이 몇 번째 수인지를 출력한다.

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args){
        /*
        Sudo Code
        1. 입력 값을 받기 위해 BufferedReader 선언(리드라인을 하나씩 받아야함)
        2. 입력 값을 인트형으로 저장할 수 있는 Integer 타입의 ArrayList를 선언(intList)
        3. br.readLine() != null 일 때까지 while 문을 돌려 intList에 넣어준다.
        4. java.util의 Collections.max 메서드를 사용하여 maxValue를 구해준다.
        5. ArrayList.indexOf 메서드를 사용해 maxValue값에 대한 Index를 구해준다.

        알게된 것
        BufferedReader를 통해 값을 받는 횟수가 정해져있는 경우
        -> main 문에 throws IOException 처리
        BufferedReader를 통해 값을 받는 횟수가 정해져있지 않은 경우
        -> try/catch 를 사용
        */
        ArrayList<Integer> intList = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            intList = new ArrayList<>();
            String str = "";
            while ((str = br.readLine()) != null) {
                intList.add(Integer.parseInt(str));
            }
        } catch (Exception e) {
        }

        int maxVal = Collections.max(intList);
        int maxIdx = intList.indexOf(maxVal) + 1;
        System.out.println(maxVal);
        System.out.println(maxIdx);

    }
}
