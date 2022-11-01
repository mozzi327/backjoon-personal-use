package level32_유니온파인드_Clear.Q3_4195_친구네트워크;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/*
문제) 친구 네트워크
    민혁이는 소셜 네트워크 사이트에서 친구를 만드는 것을 좋아하는 친구이다.
    우표를 모으는 취미가 있듯이, 민혁이는 소셜 네트워크 사이트에서 친구를 모으는 것이 취미이다.

    어떤 사이트의 친구 관계가 생긴 순서대로 주어졌을 때,
    두 사람의 친구 네트워크에 몇 명이 있는지 구하는 프로그램을 작성하시오.

    친구 네트워크란 친구 관계만으로 이동할 수 있는 사이를 말한다.

입력)
    첫째 줄에 테스트 케이스의 개수가 주어진다.
    각 테스트 케이스의 첫째 줄에는 친구 관계의 수 F가 주어지며, 이 값은 100,000을 넘지 않는다.
    다음 F개의 줄에는 친구 관계가 생긴 순서대로 주어진다.
    친구 관계는 두 사용자의 아이디로 이루어져 있으며, 알파벳 대문자 또는 소문자로만 이루어진 길이 20 이하의 문자열이다.

출력)
    친구 관계가 생길 때마다, 두 사람의 친구 네트워크에 몇 명이 있는지 구하는 프로그램을 작성하시오.
    시간 제한 : 3초
    메모리 제한 256 MB


*/

public class Main {
    private static int[] parent;
    private static int[] level;
    public static void main(String[] args) throws IOException {
        int T = readInt();
        int F;

        StringBuilder result = new StringBuilder();
        while (T-- > 0) {
            F = readInt();

            parent = new int[F * 2];
            level = new int[F * 2];
            for (int i = 0; i < F * 2; i++) {
                parent[i] = i;
                level[i] = 1;
            }
            
            int idx = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < F; i++) {
                String first = readString();
                String second = readString();

                if (!map.containsKey(first)) map.put(first, idx++);
                if (!map.containsKey(second)) map.put(second, idx++);

                result.append(union(map.get(first), map.get(second))).append('\n');
            }
        }
        System.out.println(result);
    }


    private static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    private static int union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
            level[x] += level[y];

            level[y] = 1;
        }

        return level[x];
    }

    private static int readInt() throws IOException {
        boolean isNegative = false;
        int value = 0, input;
        while (true) {
            input = System.in.read();
            if (input == '\n' || input == ' ') {
                return (isNegative) ? -1 * value : value;
            } else if (input == '-') isNegative = true;
            else value = value * 10 + (input - 48);
        }
    }


    private static String readString() throws IOException {
        char input;
        StringBuilder str = new StringBuilder();
        while (true) {
            input = (char)System.in.read();
            if (input == '\n' || input == ' ')
                return str.toString();
            else str.append(input);
        }
    }
}
