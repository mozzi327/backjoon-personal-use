## 📌 0-1 BFS 알고리즘

--- 
```
해당 알고리즘은 간선의 가중치가 0 또는 1인 그래프에서 동작하기 때문에 0-1 BFS라고 불린다. 
시간 복잡도는 O(V * E)로 O(간선의 개수)와 같다.
```
<br>

> 간선의 가중치가 0 또는 1인 임의의 정점 u에서 BFS를 실행해보면 다익스트라 알고리즘처럼 큐에는 오직 이전 정점을 통해 최단 거리가 줄어든 정점만 큐에 삽입한다. 
> 그러면 큐는 항상 시작점으로부터의 거리에 대해 정렬된 상태이다.
> <br> <br>
> 
> 현재 정점 U에 있다고 가정해보자 
> <br>
> 간선(U, V)를 지날 때 두 가지 경우 중 한 가지가 일어난다.
> 1. V와 U는 같은 레벨이다.
> 2. V와 U는 1레벨 아래이다.
> <br>
> 
> 간선의 가중치가 0 또는 1이기 때문에 위 두가지 경우만 나오게 되며, 다시 말해보면
> 1. 가중치가 0이라는 것은 V와 U가 같은 레벨이다.
> 2. 가중치가 1이라는 것은 V는 U의 1레벨 아래이다.
> <br>  
> 
> 이로서, 현재 U의 정점에 있다면, 큐는 레벨이 L[U] 또는 L[U] + 1인 정점만 들어있으며, <br>
> 간선(U, V)에 대해 L[U] 또는 L[U] + 1이 존재한다. <br>
> 그러므로, V 정점이 U에 의해 최단거리가 단축되었고, U와 같은 레벨이라면 큐의 앞부분에 V를 삽입한다. 
> <br>  
> 반대의 경우 큐 뒷부분에 삽입한다. <br>
> 이 행위는 BFS가 제대로 작동하기 위해 큐가 정렬된 상태를 유지하는 것을 도와준다.
> <br>  
> 일반적인 큐 구조로는 사용할 수 없고, 삽입과 정렬 상태를 유지하는 것을 O(1)만에 수행하지 못한다. <br>
> 우선순위 큐(Priority Queue)는 정렬된 상태를 유지하는데 O(logN)을 소모한다.<br>
> <br>
> 그래서 덱(Deque)이라는 자료구조를 사용한다.
> 1. 다음 정점 추출하기
> 2. 가장 앞쪽에 삽입하기
> 3. 가장 뒤쪽에 삽입하기
> <br>
> 
> 덱이라는 자료구조가 위의 모든 기능을 제공한다.

---
## 📌 예시 코드
```java
public class 알고스팟_백준_1261번 {
    private static void bfsRun(int[][] arr) {
        int N = arr[0].length;
        int M = arr.length;
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{-1, 0, 1, -1};
        bfs(N, M, arr, dx, dy);
    }

    private static void bfs(int N, int M, int[][] arr,
                            int[] dx, int[] dy) {
        LinkedList<int[]> deque = new LinkedList<>();
        deque.offer(new int[]{0, 0, 0});
        arr[0][0] = -1;

        int x, y, nx, ny, c;
        int[] poll;
        while (!deque.isEmpty()) {
            poll = deque.poll();
            ;
            x = poll[0];
            y = poll[1];
            c = poll[2];

            if (x == N - 1 && y == M - 1) {
                System.out.println(c);
                return;
            }

            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (checked(nx, ny, N, M)) continue;
                if (arr[ny][nx] == 0) deque.addFirst(new int[]{nx, ny, c});
                else deque.offer(new int[]{nx, ny, c + 1});
                arr[ny][nx] = -1;
            }
        }

        private static boolean checked ( int nx, int ny, int N, int M){
            return (nx < 0 || ny < 0 || nx >= N || ny >= M);
        }

        public static void main (String[]args){
            int[][] arr = new int[][]{
                    {0, 0, 1, 1, 1, 1},
                    {0, 1, 0, 0, 0, 0},
                    {0, 0, 1, 1, 1, 1},
                    {1, 1, 0, 0, 0, 1},
                    {0, 1, 1, 0, 1, 0},
                    {1, 0, 0, 0, 1, 0}
            };
            bfsRun(arr);
        }
    }
}
```
