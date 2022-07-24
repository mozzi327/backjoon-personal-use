package level9_재귀_.Q10872;

// 문제이름 : 팩토리얼
// 주제    : 재귀
// 문제번호 : 10872번
// 진행여부 : 완료 [@]
// 통과날짜 : 2022-04-15(금)

// input  : N(0 ~ 12 사이의 정수)
// return : N! 출력

import java.util.*;

public class Main {

    public static int factorial (int N) {
        if (N <= 1) return 1;
        return N * factorial(N - 1);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(factorial(N));
    }
}
