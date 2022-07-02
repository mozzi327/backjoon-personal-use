package level5_함수_.Q2_4673;

/*
문제) 셀프 넘버
    셀프 넘버는 1949년 인도 수학자 D.R. Kaprekar가 이름 붙였다.
    양의 정수 n에 대해서 d(n)을 n과 n의 각 자리수를 더하는 함수라고 정의하자.
    예를 들어, d(75) = 75+7+5 = 87이다.
    양의 정수 n이 주어졌을 때, 이 수를 시작해서 n, d(n), d(d(n)), d(d(d(n))), ...과 같은 무한 수열을 만들 수 있다.
    예를 들어, 33으로 시작한다면 다음 수는 33 + 3 + 3 = 39이고,
    그 다음 수는 39 + 3 + 9 = 51, 다음 수는 51 + 5 + 1 = 57이다.
    이런식으로 다음과 같은 수열을 만들 수 있다.
    33, 39, 51, 57, 69, 84, 96, 111, 114, 120, 123, 129, 141, ...
    n을 d(n)의 생성자라고 한다.
    위의 수열에서 33은 39의 생성자이고, 39는 51의 생성자, 51은 57의 생성자이다.
    생성자가 한 개보다 많은 경우도 있다.
    예를 들어, 101은 생성자가 2개(91과 100) 있다.
    생성자가 없는 숫자를 셀프 넘버라고 한다.
    100보다 작은 셀프 넘버는 총 13개가 있다.
    1, 3, 5, 7, 9, 20, 31, 42, 53, 64, 75, 86, 97
    10000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 출력하는 프로그램을 작성하시오.

입력)
    입력은 없다.

출력)
    10,000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 증가하는 순서로 출력한다.

*/

import java.util.Arrays;
public class Main {

    /*
    Sudo Code)
    1. 생성자가 없는 숫자가 셀프 넘버(어떻게 구할까?)
    2. 값을 받아 생성자를 구해주는 함수를 만든다. -> 예를 들어 1234를 받으면 만들어지는 생성자는 1234 + 1 + 2 + 3 + 4 가 된다.
    -> Arrays.stream 메서드를 사용해 받은 숫자를 문자열로 만들어주고 그것을 String 배열 -> 각 숫자를 Integer형으로 변환 -> sum() 해준다.
    3. N(10001)개의 boolean 배열을 선언한다. -> default : false
    4. for문을 선언해서 int m = function(i) && m < N(10001)인 경우 해당 숫자의 인덱스 번호의 boolean 배열 칸에 true 값을 넣어준다.
    5. boolean 배열만큼의 for문을 돌려 if(!boolean[i] : 셀프넘버들) 인 값의 i를 출력한다.

    */
    public static int d(int number) {
        int n = number;
        int any = Arrays.stream(String.valueOf(number).split("")).mapToInt(Integer::parseInt).sum();
        return n + any ;
    }

    public static void main(String[] args) {
        int N = 10001;
        boolean[] orList = new boolean[N];
        for (int i = 1; i < N; i++) {
            int m = d(i);
            if (m < N) {
                orList[m] = true;
            }
        }
        for (int i = 1; i < orList.length; i++) {
            if (!orList[i]) {
                System.out.println(i);
            }
        }
    }
}
