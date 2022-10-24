package level28_투_포인터_Clear.Q1_3273_두수의합;

/*
문제) 두 수의 합
    n개의 서로 다른 양의 정수 a1, a2, ..., an으로 이루어진 수열이 있다.
    ai의 값은 1보다 크거나 같고, 1000000보다 작거나 같은 자연수이다.
    자연수 x가 주어졌을 때, ai + aj = x (1 ≤ i < j ≤ n)을 만족하는 (ai, aj)쌍의 수를 구하는 프로그램을 작성하시오.

입력)
    첫째 줄에 수열의 크기 n이 주어진다. 다음 줄에는 수열에 포함되는 수가 주어진다.
    셋째 줄에는 x가 주어진다. (1 ≤ n ≤ 100000, 1 ≤ x ≤ 2000000)

출력)
    문제의 조건을 만족하는 쌍의 개수를 출력한다.
    시간 제한 : 1초
    메모리 제한 128 MB

*/

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = readInt();
        }
        Arrays.sort(arr);
        int answer = readInt();

        int start = 0, end = N - 1, count = 0;
        while (start < end) {
            int twoSum = arr[start] + arr[end];
            if (twoSum == answer) count++;
            if (twoSum <= answer) start++;
            else end--;
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
