package level1_사칙연산_Clear.Q9_10869_사칙연산;

import java.util.Scanner;

// 두 자연수 A와 B를 받아 두 수의 덧셈 뺄셈 곱셈 몫 나머지을 출력

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        System.out.println(A+B);
        System.out.println(A-B);
        System.out.println(A*B);
        System.out.println(A/B);
        System.out.println(A%B);
    }
}