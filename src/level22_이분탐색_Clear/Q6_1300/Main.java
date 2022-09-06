package level22_이분탐색_Clear.Q6_1300;


/*
문제) K번째 수
    세준이는 크기가 N×N인 배열 A를 만들었다. 배열에 들어있는 수 A[i][j] = i×j 이다.
    이 수를 일차원 배열 B에 넣으면 B의 크기는 N×N이 된다. B를 오름차순 정렬했을 때, B[k]를 구해보자.

    배열 A와 B의 인덱스는 1부터 시작한다.

입력)
    첫째 줄에 배열의 크기 N이 주어진다. N은 105보다 작거나 같은 자연수이다.
    둘째 줄에 k가 주어진다. k는 min(109, N2)보다 작거나 같은 자연수이다.

출력)
    B[k]를 출력한다.
    시간 제한	    메모리 제한	제출	    정답	    맞힌 사람	    정답 비율
    2 초	        128 MB  	26355	9526	6989        37.565%

    시간복잡도 : N - 100,000 -> 따라서 100,000 * 100,000 = 10,000,000,000 (100억) > 2초
    NlogN으로 풀어야 됨
*/


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        int N = readInt();
        int k = readInt();
        int start = 1;
        int end = k;
        while (start < end) {
            int count = 0;
            int mid = (start + end) / 2;
            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }
            // 이분 탐색의 왼쪽 영역을 탐색한다.
            if (k <= count) {
                end = mid;
            } else { // 이분 탐색의 오른쪽 영역을 탐색한다.
                start  = mid + 1;
            }
        }
        System.out.println(start);
    }

    private static int readInt() throws IOException {
        boolean isNegative = false;
        int value = 0;

        while (true) {
            int input = System.in.read();
            if (input == ' ' || input == '\n') {
                return isNegative ? -1 * value : value;
            } else if (input == '-') isNegative = true;
            else value = value * 10 + (input - 48);
        }
    }
}
