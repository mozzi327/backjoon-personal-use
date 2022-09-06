package level22_이분탐색_Clear.Q2_10816;
import java.io.IOException;
import java.util.Arrays;

/*
문제) 숫자 카드 2
    숫자 카드는 정수 하나가 적혀져 있는 카드이다.
    상근이는 숫자 카드 N개를 가지고 있다.
    정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.

입력)
    첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다.
    둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다.
    숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
    셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다.
    넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수가 주어지며,
    이 수는 공백으로 구분되어져 있다. 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.

출력)
    첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력한다.
    시간 제한	    메모리 제한	제출	    정답	    맞힌 사람	    정답 비율
    1 초	        256 MB	    78273	28652	20530	    35.885%

*/

// 시간 초과@@@@

/*

class Main2 {
    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] holdingCards = new int[N];
        for (int i = 0; i < N; i++) {
            holdingCards[i] = readInt();
        }
        Arrays.sort(holdingCards);
        int M = readInt();
        StringBuilder answer = new StringBuilder();
        int count;
        int start;
        int end;
        int mid;
        int findCard;
        for (int i = 0; i < M; i++) {
            count = 0;
            start = 0;
            end = N - 1;
            findCard = readInt();
            while (start <= end) {
                mid = (start + end) / 2;
                if (holdingCards[mid] == findCard) {
                    for (int j = mid; -1 < j; j--) {
                        if (holdingCards[j] == findCard) count++;
                        else break;
                    }
                    for (int j = mid+1; j < N; j++) {
                        if (holdingCards[j] == findCard) count++;
                        else break;
                    }
                    break;
                } else if (findCard < holdingCards[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            answer.append(count).append(' ');
        }

        System.out.println(answer);
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

*/



// lower bound 와 upper bound 를 이용한 풀이
// 정렬 뒤 값을 카운트하는게 아닌 배열의 범위를 구하는 풀이 방법

class Main {
    public static void main(String[] args) throws IOException{
        int N = readInt();
        int[] holdingCards = new int[N];
        for (int i = 0; i < N; i++) {
            holdingCards[i] = readInt();
        }
        Arrays.sort(holdingCards);
        int M = readInt();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int findCard = readInt();
            result.append(upperBound(holdingCards, findCard) - lowerBound(holdingCards, findCard)).append(' ');
        }
        System.out.println(result);
    }

    private static int lowerBound(int[] holdingCards, int findCard) {
        int startIdx = 0;
        int endIdx = holdingCards.length;

        while (startIdx < endIdx) {
            int midIdx = (startIdx + endIdx) / 2;
            if (findCard <= holdingCards[midIdx]) endIdx = midIdx;
            else startIdx = midIdx + 1;
        }
        return startIdx;
    }

    private static int upperBound(int[] holdingCards, int findCard) {
        int startIdx = 0;
        int endIdx = holdingCards.length;

        while (startIdx < endIdx) {
            int midIdx = (startIdx + endIdx) / 2;
            if (findCard < holdingCards[midIdx]) endIdx = midIdx;
            else startIdx = midIdx + 1;
        }
        return startIdx;
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