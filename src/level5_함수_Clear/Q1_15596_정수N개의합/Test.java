package level5_함수_Clear.Q1_15596_정수N개의합;

/*
문제) 정수 N개의 합
    정수 n개가 주어졌을 때, n개의 합을 구하는 함수를 작성하시오.

    작성해야 하는 함수는 다음과 같다.

    Java: long sum(int[] a); (클래스 이름: Test)
    a: 합을 구해야 하는 정수 n개가 저장되어 있는 배열 (0 ≤ a[i] ≤ 1,000,000, 1 ≤ n ≤ 3,000,000)
    리턴값: a에 포함되어 있는 정수 n개의 합

입력)
    합을 구해야 하는 정수 n개가 저장되어 있는 배열 (0 ≤ a[i] ≤ 1,000,000, 1 ≤ n ≤ 3,000,000)

출력)
    a에 포함되어 있는 정수 n개의 합

*/

/*
    Sudo Code)
    1. class 이름은 무조건 Test 로 할 것
    2. 함수는 long 타입의 sum 아라는 이름을 사용하며 Integer 형의 배열 a를 받는다.
    3. return 값으로 배열의 합을 구한다.
    4. long 타입 변수를 선언, for문을 통해 합을 구하자.
*/

public class Test {
    long sum(int[] a) {
        long ans = 0;
        for (int i = 0; i < a.length; i++) {
            ans += a[i];
        }
        return ans;
    }
}
