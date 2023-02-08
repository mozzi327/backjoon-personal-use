package level24_우선순위_큐_.Q1_11279_최대힙;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 문제) 최대 힙<br>
 *   널리 잘 알려진 자료구조 중 최대 힙이 있다.<br>
 *   최대 힙을 이용하여 다음과 같은 연산을 지원하는 프로그램을 작성하시오.<br>
 *       1. 배열에 자연수 x를 넣는다.<br>
 *       2. 배열에서 가장 큰 값을 출력하고, 그 값을 배열에서 제거한다.<br>
 *<br>
 * 입력)<br>
 *   첫째 줄에 연산의 개수 N(1 ≤ N ≤ 100,000)이 주어진다.<br>
 *   다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다.<br>
 *   만약 x가 자연수라면 배열에 x라는 값을 넣는(추가하는) 연산이고,<br>
 *   x가 0이라면 배열에서 가장 큰 값을 출력하고 그 값을 배열에서 제거하는 경우이다.<br>
 *   입력되는 자연수는 2^31보다 작다.<br>
 *<br>
 * 출력)<br>
 *   입력에서 0이 주어진 회수만큼 답을 출력한다.<br>
 *   만약 배열이 비어 있는 경우인데 가장 큰 값을 출력하라고 한 경우에는 0을 출력하면 된다.<br>
 *   시간 제한 : 1초<br>
 *   메모리 제한 : 256 MB<br>
 */

public class Main {
    public static void main(String[] args) throws IOException {
        int N = readInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int in;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            in = readInt();
            if (in == 0) {
                if (queue.isEmpty()) result.append(0).append('\n');
                else result.append(queue.poll()).append('\n');
            } else queue.add(in);
        }

        System.out.println(result);
    }


    private static int readInt() throws IOException {
        boolean isNegative = false;
        int value = 0, input;
        while (true) {
            input = System.in.read();
            if (input == '\n' || input == ' ')
                return (isNegative) ? -1 * value : value;
            else if (input == '-') isNegative = true;
            else value = value * 10 + (input - 48);
        }
    }
}
