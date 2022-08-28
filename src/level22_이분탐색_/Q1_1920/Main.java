package level22_이분탐색_.Q1_1920;


/*
문제) 수찾기
    N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

입력)
    첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다.
    다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다.
    모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.

출력)
    M개의 줄에 답을 출력한다.
    존재하면 1을, 존재하지 않으면 0을 출력한다.
    시간 제한	    메모리 제한	제출	    정답	    맞힌 사람	    정답 비율
    1 초	        128 MB	    154067	45582	30306	    29.847%

*/


import java.io.IOException;
import java.util.Arrays;

public class Main {
    private static void main(String[] args) throws IOException {
        int N = readInt();
        int [] ArraysForCompare = new int[N];
        for (int i = 0; i < N; i++) {
            ArraysForCompare[i] = readInt();
        }
        Arrays.sort(ArraysForCompare);
        int M = readInt();

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int comparisonNumber = readInt();
            answer.append(isIncluded(ArraysForCompare, comparisonNumber)).append("\n");
        }

        System.out.println(answer);
    }

    private static int isIncluded(int[] arr, int findNum) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start+end) / 2;
            if (arr[mid] == findNum) {
                return 1;
            } else if (findNum < arr[mid]) {
                end = mid - 1;
            } else  {
                start = mid + 1;
            }
        }
        return 0;
    }

    private static int readInt() throws IOException {
        boolean isNegative = false; // 음수니?
        int value = 0;
        while (true) {
            // 입력 문자의 ASCII코드 값.
            // 가령 '0'이 들어왔으면 숫자 0이 아니라 '0'의 ASCII 코드값인 48이다.
            int input = System.in.read();
            if (input == ' '||input=='\n') { // 개행문자거나 공백이면 연산을 끊음
                return (isNegative)
                        ? -1 * value // 음수면 - 붙여서 반환
                        : value; // 양수면 그냥 반환
            } else  if (input == '-') { // 문자를 읽었는데 -가 붙어있으면 이 값은 음수임
                isNegative = true;
            } else {
                value = value * 10 + (input - 48); // 기존 값을 10배하고 입력된 추가값을 파싱하여 더함
            }
        }
    }
}
