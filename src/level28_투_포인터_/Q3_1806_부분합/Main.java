package level28_투_포인터_.Q3_1806_부분합;

/*
문제) 부분합
    10,000 이하의 자연수로 이루어진 길이 N짜리 수열이 주어진다.
    이 수열에서 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중,
    가장 짧은 것의 길이를 구하는 프로그램을 작성하시오.

입력)
    첫째 줄에 N (10 ≤ N < 100,000)과 S (0 < S ≤ 100,000,000)가 주어진다.
    둘째 줄에는 수열이 주어진다.
    수열의 각 원소는 공백으로 구분되어져 있으며, 10,000이하의 자연수이다.

출력)
    첫째 줄에 구하고자 하는 최소의 길이를 출력한다.
    만일 그러한 합을 만드는 것이 불가능하다면 0을 출력하면 된다.
    시간 제한 : 0.5초
    메모리 제한 : 128 MB

*/

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int N = readInt();
        int answer = readInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = readInt();
        }

        int minCount = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int sum = 0;

        while (true) {
            if (sum >= answer) {
                sum -= arr[left];
                minCount = Math.min(minCount, (right - left));
                left++;
            }
            else if (right == N) break;
            else {
                sum += arr[right++];
            }
        }
        if (minCount == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(minCount);
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
