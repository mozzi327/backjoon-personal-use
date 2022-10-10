package dijstra_algorithm;

/*
    다익스트라 알고리즘 예제 : 우선순위 큐 활용
    시간 복잡도 : O(ElogE), E는 ㄷdge의 갯수
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DijstraPath {
    public static class Edge implements Comparable<Edge> {
        public int distance;
        public String vertex;

        public Edge(int distance, String vertex) {
            this.distance = distance;
            this.vertex = vertex;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.distance - edge.distance;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "distance=" + distance +
                    ", vertex='" + vertex + '\'' +
                    '}';
        }
    }

    public static HashMap<String, Integer> dijstraFunc(HashMap<String, ArrayList<Edge>> graph, String start) {
        HashMap<String, Integer> distances = new HashMap<String, Integer>();
        Edge edgeNode, adjcentNode;
        ArrayList<Edge> nodeList;
        int weight, distance, curDistance;
        String adjcent, curNode;
        for (String key : graph.keySet()) {
            distances.put(key, Integer.MAX_VALUE);
        }

        distances.put(start, 0);

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(distances.get(start), start));

        // 알고리즘 작성
        while (priorityQueue.size() > 0) {
            edgeNode = priorityQueue.poll();
            curDistance = edgeNode.distance;
            curNode = edgeNode.vertex;

            if (distances.get(curNode) < curDistance) {
                continue;
            }

            nodeList = graph.get(curNode);
            for (int i = 0; i < nodeList.size(); i++) {
                adjcentNode = nodeList.get(i);
                adjcent = adjcentNode.vertex;
                weight = adjcentNode.distance;
                distance = curDistance + weight;

                if (distance < distances.get(adjcent)) {
                    distances.put(adjcent, distance);
                    priorityQueue.add(new Edge(distance, adjcent));
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(2, "A"));
        priorityQueue.add(new Edge(5, "B"));
        priorityQueue.add(new Edge(1, "C"));
        priorityQueue.add(new Edge(7, "D"));

        System.out.println(priorityQueue);
        Edge edge1 = priorityQueue.poll();
        System.out.println(edge1);
        System.out.println(priorityQueue);

        HashMap<String, ArrayList<Edge>> graph = new HashMap<>();
        graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        graph.put("B", new ArrayList<Edge>());
        graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
        graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));


        System.out.println(dijstraFunc(graph, "A"));

    }
}
