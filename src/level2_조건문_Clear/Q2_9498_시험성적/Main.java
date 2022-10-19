package level2_조건문_Clear.Q2_9498_시험성적;

// 시험 성적 나타내기
// A : 100 ~ 90
// B : 89 ~ 80
// C : 79 ~ 70
// D : 69 ~ 60
// F : 나머지

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int grade = sc.nextInt();

        if (grade > 89) {
            System.out.println("A");
        } else if(grade > 79) {
            System.out.println("B");
        } else if(grade > 69) {
            System.out.println("C");
        } else if(grade > 59) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}
