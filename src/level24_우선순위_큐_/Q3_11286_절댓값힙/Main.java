package level24_우선순위_큐_.Q3_11286_절댓값힙;

import java.io.IOException;
import java.util.PriorityQueue;

/**
 * 문제) 절댓값 힙<br>
 *  절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.<br>
 *  1. 배열에 정수 x (x ≠ 0)를 넣는다.<br>
 *  2. 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.<br>
 *      절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.<br>
 *  프로그램은 처음에 비어있는 배열에서 시작하게 된다.<br>
 *<br>
 *<br>
 * 입력)<br>
 * 첫째 줄에 연산의 개수 N(1≤N≤100,000)이 주어진다.<br>
 * 다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다.<br>
 * 만약 x가 0이 아니라면 배열에 x라는 값을 넣는(추가하는) 연산이고,<br>
 * x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다.<br>
 * 입력되는 정수는 -231보다 크고, 231보다 작다.<br>
 *<br>
 *<br>
 * 출력)<br>
 * 입력에서 0이 주어진 회수만큼 답을 출력한다.<br>
 * 만약 배열이 비어 있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다.<br>
 * 시간 제한 : 1초<br>
 * 메모리 제한 : 256 MB<br>
 *
 */

public class Main {
    public static class Node implements Comparable<Node>{
        private final int number;
        private final int abs;

        public Node(int number, int abs) {
            this.number = number;
            this.abs = abs;
        }

        @Override
        public int compareTo(Node o) {
            if (this.abs == o.abs) return this.number - o.number;
            return Math.abs(this.abs) - Math.abs(o.abs);
        }
    }

    public static void main(String[] args) throws IOException {
        int N = readInt();
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int in;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            in = readInt();
            if (in == 0) {
                if (queue.isEmpty()) result.append(0).append('\n');
                else {
                    result.append(queue.poll().number).append('\n');
                }
            } else queue.add(new Node(in, Math.abs(in)));
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
