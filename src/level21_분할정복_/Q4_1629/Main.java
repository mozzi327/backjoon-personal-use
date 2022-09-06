package level21_분할정복_.Q4_1629;

/*
문제) 곱셈
    자연수 A를 B번 곱한 수를 알고 싶다.
    단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성하시오.

입력)
    첫째 줄에 A, B, C가 빈 칸을 사이에 두고 순서대로 주어진다.
    A, B, C는 모두 2,147,483,647 이하의 자연수이다.

출력)
    첫째 줄에 A를 B번 곱한 수를 C로 나눈 나머지를 출력한다.
    시간 제한 : 0.5초
    메모리 제한 : 128MB
*/

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        int A = readInt();
        int B = readInt();
        int C = readInt();
        long result = power(A,B,C);
        System.out.println(result);
    }

    private static long power(int base, int exponent, int P) {

        if (exponent == 0) return 1;
        int half =  exponent / 2;
        long powerToValue = power(base, half, P);
        long totalValue = (powerToValue * powerToValue) % P;

        if (exponent % 2 == 1) return (base * totalValue) % P;
        else return totalValue;
    }


    private static int readInt() throws IOException {
        boolean isNegative = false;
        int value = 0;
        while (true) {
            int input = System.in.read();
            if (input == ' ' || input == '\n') {
                return (isNegative) ? -1 * value :
                        value;
            } else value = value * 10 + (input - 48);
        }
    }
}
