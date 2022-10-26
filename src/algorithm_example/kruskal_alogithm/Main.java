package algorithm_example.kruskal_alogithm;

/*
    UNION FiND 알고리즘을 활용한 KRUSKAL 알고리즘
    사이클이 존재하지 안되, 노드를 모두 연결하는 최소 비용을 구하는 알고리즘이다.

    필요한 간선 개수 : 노드의 개수 - 1
    주의점 : 사이클 발생해서는 안됌

*/

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    // cost가 낮은 순으로 정렬
    public static class Node implements Comparable<Node>{
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }


    private static int get(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = get(parent, parent[x]);
    }



    private static void union(int[] parent, int a, int b) {
        a = get(parent, a);
        b = get(parent, b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    private static boolean find(int[] parent, int a, int b) {
        a = get(parent, a);
        b = get(parent, b);
        return (a == b);
    }


    public static void main(String[] args) {
        // 간선 중 가장 적은 비용을 선택해 나간다.
        // 단 사이클이 발생하지 않는 조건이 있어야 함
        // 시작노드, 다음노드, 비용의 노드로 묶어 비용 순으로 정렬

        // 단순히 연결되어있는지만 확인하려면 UNION을 해주면 된다.
        // start 노드 end 노드 값을 받아 FIND 먼저 하고(사이클 존재 여부 확인), 없다면 UNION을 통해 부모 연결.
        // 연결 시 동일한 부모를 갖는다.

        // 사이클이 존재하는지 확인하려면 FIND를 해주면 된다.
        // 비교하려는 start 노드와 end 노드의 부모가 서로 동일하다면 사이클이 있다고 판단, 무시
        int N = 7;
        int M = 11;

        ArrayList<Node> V = new ArrayList<>();
        V.add(new Node(1, 7, 12));
        V.add(new Node(1, 4, 28));
        V.add(new Node(1, 2, 67));
        V.add(new Node(1, 5, 17));
        V.add(new Node(2, 4, 24));
        V.add(new Node(2, 5, 62));
        V.add(new Node(3, 5, 20));
        V.add(new Node(3, 6, 37));
        V.add(new Node(4, 7, 13));
        V.add(new Node(5, 6, 45));
        V.add(new Node(5, 7, 73));

        Collections.sort(V);

        int[] parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int sum = 0;
        for (int i = 0; i < V.size(); i++) {
            // 사이클이 발생하지 않았다면
            if (!find(parent, V.get(i).start, V.get(i).end)) {
                // 간선 비용 값으 더해주고 두 노드를 연결해줌
                sum += V.get(i).cost;
                union(parent, V.get(i).start, V.get(i).end);
            }
        }

        System.out.println(sum);
    }
}
