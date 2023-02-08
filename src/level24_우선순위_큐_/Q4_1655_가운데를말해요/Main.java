package level24_우선순위_큐_.Q4_1655_가운데를말해요;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 문제) 가운데를 말해요<br>
 * 백준이는 동생에게 "가운데를 말해요" 게임을 가르쳐주고 있다.<br>
 * 백준이가 정수를 하나씩 외칠때마다 동생은 지금까지 백준이가 말한 수 중에서 중간값을 말해야 한다.<br>
 * 만약, 그동안 백준이가 외친 수의 개수가 짝수개라면 중간에 있는 두 수 중에서 작은 수를 말해야 한다.<br>
 * 예를 들어 백준이가 동생에게 1, 5, 2, 10, -99, 7, 5를 순서대로 외쳤다고 하면,<br>
 * 동생은 1, 1, 2, 2, 2, 2, 5를 차례대로 말해야 한다.<br>
 * 백준이가 외치는 수가 주어졌을 때, 동생이 말해야 하는 수를 구하는 프로그램을 작성하시오.<br>
 * <br>
 * <br>
 * 입력)<br>
 * 첫째 줄에는 백준이가 외치는 정수의 개수 N이 주어진다.<br>
 * N은 1보다 크거나 같고, 100,000보다 작거나 같은 자연수이다.<br>
 * 그 다음 N줄에 걸쳐서 백준이가 외치는 정수가 차례대로 주어진다.<br>
 * 정수는 -10,000보다 크거나 같고, 10,000보다 작거나 같다.<br>
 * <br>
 * <br>
 * 출력)<br>
 * 한 줄에 하나씩 N줄에 걸쳐 백준이의 동생이 말해야 하는 수를 순서대로 출력한다.<br>
 * 시간 제한 : 0.1초<br>
 * 메모리 제한 : 128 MB<br>
 */

public class Main {

    public static void main(String[] args) throws IOException {
        int N = readInt();
        StringBuilder result = new StringBuilder();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int in;
        for (int i = 0; i < N; i++) {
            in = readInt();
            if (maxHeap.size() == minHeap.size()) maxHeap.offer(in);
            else minHeap.offer(in);

            if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
                if (minHeap.peek() < maxHeap.peek()) {
                    int temp = minHeap.poll();
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(temp);
                }
            }

            result.append(maxHeap.peek()).append('\n');
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
