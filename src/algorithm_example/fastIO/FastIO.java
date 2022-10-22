package algorithm_example.fastIO;

import java.io.IOException;
import java.util.Arrays;

public class FastIO {
    public static void main(String[] args) throws IOException{
        int N = readInt();
        int[] testArr = new int[N];
        for (int i = 0; i < N; i++) {
            testArr[i] = readInt();
        }
        System.out.println("arr = " + Arrays.toString(testArr));
    }

    private static int readInt() throws IOException {
        boolean isNegative = false; // 음수니?
        int value = 0;
        while (true) {
            // 입력 문자의 ASCII코드 값.
            // 가령 '0'이 들어왔으면 숫자 0이 아니라 '0'의 ASCII 코드값인 48이다.
            int input = System.in.read();
            if (input == ' ' || input == '\n') { // 개행문자거나 공백이면 연산을 끊음
                return (isNegative)
                        ? -1 * value // 음수면 - 붙여서 반환
                        : value; // 양수면 그냥 반환
            } else if (input == '-') { // 문자를 읽었는데 -가 붙어있으면 이 값은 음수임
                isNegative = true;
            } else {
                value = value * 10 + (input - 48); // 기존 값을 10배하고 입력된 추가값을 파싱하여 더함
            }
        }
    }
}
