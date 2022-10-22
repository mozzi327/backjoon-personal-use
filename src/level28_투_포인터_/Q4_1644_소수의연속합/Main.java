package level28_투_포인터_.Q4_1644_소수의연속합;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
문제) 소수의 연속합
    하나 이상의 연속된 소수의 합으로 나타낼 수 있는 자연수들이 있다.
    몇 가지 자연수의 예를 들어 보면 다음과 같다.

        3 : 3 (한 가지)
        41 : 2+3+5+7+11+13 = 11+13+17 = 41 (세 가지)
        53 : 5+7+11+13+17 = 53 (두 가지)
    하지만 연속된 소수의 합으로 나타낼 수 없는 자연수들도 있는데, 20이 그 예이다.
    7+13을 계산하면 20이 되기는 하나 7과 13이 연속이 아니기에 적합한 표현이 아니다.
    또한 한 소수는 반드시 한 번만 덧셈에 사용될 수 있기 때문에, 3+5+5+7과 같은 표현도 적합하지 않다.

자연수가 주어졌을 때, 이 자연수를 연속된 소수의 합으로 나타낼 수 있는 경우의 수를 구하는 프로그램을 작성하시오.

입력)
    첫째 줄에 자연수 N이 주어진다. (1 ≤ N ≤ 4,000,000)

출력)
    첫째 줄에 자연수 N을 연속된 소수의 합으로 나타낼 수 있는 경우의 수를 출력한다.
    시간 제한 : 2초
    메모리 제한 128 MB

*/
public class Main {
    public static void main(String[] args) throws IOException {
        int N = readInt();

        boolean[] isPrime = new boolean[N + 1];

        isPrime[0] = isPrime[1] = true;

        List<Integer> arr = new ArrayList<>();
        for (int i = 2; i <= (int) Math.sqrt(N); i++) {
            if(!isPrime[i]) {
                for (int j = i * i; j <= N; j+= i) {
                    isPrime[j] = true;
                }
            }
        }

        for (int i = 0; i < isPrime.length; i++) {
            if (!isPrime[i]) arr.add(i);
        }

        int left = 0, right = 0, sum = 0, count = 0;
        while (true) {
            if (sum >= N) {
                sum -= arr.get(left++);
            } else if (right == arr.size()) {
                break;
            } else {
                sum += arr.get(right++);
            }

            if (sum == N) count++;
        }

        System.out.println(count);

    }

    private static int readInt() throws IOException {
        boolean isNegative = false;
        int value = 0;
        int input;
        while (true) {
            input = System.in.read();
            if (input == '\n' || input == ' ') {
                return (isNegative) ? -1 * value : value;
            } else if (input == '-') isNegative = true;
            else value = value * 10 + (input - 48);
        }
    }
}
