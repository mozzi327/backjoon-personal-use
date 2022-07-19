package level20_큐_덱_.Q7_5430_2;


import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        int n;
        ArrayList<String> answers = new ArrayList<>();
        Loop1:
        for (int i = 0; i < T; i++) {
            Deque<Integer> deque = new LinkedList<>();
            char[] p = br.readLine().toCharArray();
            n = Integer.parseInt(br.readLine());
            StringBuffer arr = new StringBuffer(br.readLine());
            arr.deleteCharAt(0);
            arr.deleteCharAt(arr.length() - 1);
            StringTokenizer st = new StringTokenizer(arr.toString(), ",");
            for (int j = 0; j < n; j++) {
                String tmp = st.nextToken();
                if(!tmp.equals(""))deque.offer(Integer.valueOf(tmp));
            }

            int totalR = 0;
            boolean trueStackFalseQueue = false;
            Loop2:
            for (char c : p) {
                if (c == 'R') {
                    totalR++;
                    trueStackFalseQueue = !trueStackFalseQueue;
                }
                if (c == 'D' && !deque.isEmpty()) {
                    if (trueStackFalseQueue) {
                        deque.pollLast();

                    } else {
                        deque.pollFirst();

                    }
                } else if (c == 'D' && deque.size() == 0) {
                    sb.append("error\n");
                    continue Loop1;

                }


            }
            if (totalR % 2 == 1) {
                for (int j = 0; j < deque.size() - 1; j++) {
                    deque.offerLast(deque.pollFirst());

                }
                sb.append(deque.toString().replace(" ", "")+"\n");

            } else {
                sb.append(deque.toString().replace(" ", "")+"\n");

            }


        }
        System.out.print(sb);
    }

}

