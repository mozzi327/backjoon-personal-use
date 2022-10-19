package level1_사칙연산_Clear.Q12_10430_나머지;

import java.util.Scanner;

// 세 수를 입력받아 다음 값을 계산하여 출력하기
// 1.(A+B)%C
// 2.((A%C) + (B%C))%C
// 3.(A*B)%C
// 4.((A%C) * (B%C))%C

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        System.out.println((A+B)%C);
        System.out.println(((A%C) + (B%C))%C);
        System.out.println((A*B)%C);
        System.out.println(((A%C) * (B%C))%C);
    }
}
