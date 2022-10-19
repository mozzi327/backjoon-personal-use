package level7_기본수학1_.Q3_1193_분수찾기;

/*
문제) 분수 찾기
    무한히 큰 배열에 다음과 같이 분수들이 적혀있다.

    1/1	1/2	1/3	1/4	1/5	…
    2/1	2/2	2/3	2/4	…	…
    3/1	3/2	3/3	…	…	…
    4/1	4/2	…	…	…	…
    5/1	…	…	…	…	…
    …	…	…	…	…	…
    이와 같이 나열된 분수들을 1/1 → 1/2 → 2/1 → 3/1 → 2/2 → … 과 같은 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.

    X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.

입력)
    첫째 줄에 X(1 ≤ X ≤ 10,000,000)가 주어진다.

출력)
    첫째 줄에 분수를 출력한다.
    시간 제한	    메모리 제한	제출	    정답	    맞힌 사람	    정답 비율
    0.5초(x)	    256 MB	    81260	40153	34879	    50.973%


*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputX = sc.nextInt();
        if (inputX == 1) {
            System.out.println("1/1");
        } else {
            int plusNum = 1;
            int i = 2;
            while (true) {
                if (inputX <= plusNum + i) {
                    int up = plusNum - inputX + i + 1;
                    int bottom = i+1 - up;

                    if (i % 2 == 0) {
                        System.out.println(bottom + "/" + up);
                    } else {
                        System.out.println(up + "/" + bottom);
                    }

                    break;
                } else {
                    plusNum += i;
                    i++;
                }
            }
        }
    }
}
