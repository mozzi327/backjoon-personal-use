package level1_사칙연산_Clear.Q13_2588;

// 세 자리 수인 두 자연수가 주어질 때 사칙연산의 위치에 들어갈 값들을 출력하기

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        String B = sc.next();

        for (int i = B.length() - 1; i > -1; i--) {
            char numB = B.charAt(i);
            int changeB = Integer.parseInt(String.valueOf(numB));
            System.out.println(A * changeB);
        }

        int answer = Integer.valueOf(B);
        System.out.println(A * answer);


    }
}
