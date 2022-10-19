package level5_함수_Clear.Q3_1065_한수;

/*
문제) 한수
    어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다.
    등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다.
    N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.

입력)
    첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.

출력)
    첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class Main {
    /*
    Sudo Code)
        1. BufferedReader 를 통해 자연수 N을 받는다. (N : 1000 이하의 자연수)
        2. 한수를 카운트할 함수를 만들어 준다. (findHan)
        -> 자연수를 입력받아 String 배열로 변환 후 길이가 2 이하(100 미만)은 전부 true를 리턴
        -> 3인 경우 str[2] - str[1] == str[1] - str[0] 인지 확인한 후 맞을 경우 true를, 아닐 경우 false를 리턴한다.
        3. main 문에서 for 문을 돌려 findHan(i) true일 경우 cnt++ 해준다.
        4. cnt 를 출력
        ---> 자리 수가 더 커지면 사용 못하므로 코드 개선이 필요

    Sudo Code2) 모든 수에 대한 한수를 구할 수 있게 변경
        1. 99 이하 -> cnt++
        2. 자연수를 입력받아 String 배열로 변환 후 for 문 선언
        -> default or(등차수열 비교) : true
        -> i-2 < 0 이 되면 break;
        -> if (parseInt(str[i])-parseInt(str[i-1]) != parseInt(str[i-1])-parseInt(str[i-2])) 라면 or 은 false 값이 바로 리턴된다.
        -> 아닐경우 default or 값인 true를 리턴해준다.
        3. true 값이 리턴될 경우 cnt++
        4. cnt 를 출력

    */

    public static boolean findHan(int number) {
        String[] str = String.valueOf(number).split("");
        int numLength = str.length;

        boolean or = true;
        for (int i = numLength - 1; i > 0; i--) {
            if (i - 2 < 0) {
                break;
            }
            if (parseInt(str[i])-parseInt(str[i-1]) != parseInt(str[i-1])-parseInt(str[i-2])) {
                return false;

            }
        }
        return or;
//        System.out.println(Arrays.toString(str));
//        switch (numLength) {
//            case 1:
//                return true;
//            case 2:
//                return true;
//            case 3:
//                if (parseInt(str[2]) - parseInt(str[1]) == (parseInt(str[1]) - parseInt(str[0]))){
//                    return true;
//                } else {
//                    return false;
//                }
//        }
//        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine()) + 1;
        int cnt = 0;
        for (int i = 1; i < N; i++) {
            if (i < 100) {
                cnt ++;
            }
            else {
                if(findHan(i)) {cnt ++;}
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
