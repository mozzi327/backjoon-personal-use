package level21_분할정복_Clear.Q9_6549;

/*
문제) 히스토그램에서 가장 큰 직사각형
    히스토그램은 직사각형 여러 개가 아래쪽으로 정렬되어 있는 도형이다.
    각 직사각형은 같은 너비를 가지고 있지만, 높이는 서로 다를 수도 있다.
    예를 들어, 왼쪽 그림은 높이가 2, 1, 4, 5, 1, 3, 3이고 너비가 1인 직사각형으로 이루어진 히스토그램이다.

    히스토그램에서 가장 넓이가 큰 직사각형을 구하는 프로그램을 작성하시오.

입력)
    입력은 테스트 케이스 여러 개로 이루어져 있다.
    각 테스트 케이스는 한 줄로 이루어져 있고, 직사각형의 수 n이 가장 처음으로 주어진다. (1 ≤ n ≤ 100,000)
    그 다음 n개의 정수 h1, ..., hn (0 ≤ hi ≤ 1,000,000,000)가 주어진다.
    이 숫자들은 히스토그램에 있는 직사각형의 높이이며, 왼쪽부터 오른쪽까지 순서대로 주어진다.
    모든 직사각형의 너비는 1이고, 입력의 마지막 줄에는 0이 하나 주어진다.

출력)
    각 테스트 케이스에 대해서, 히스토그램에서 가장 넓이가 큰 직사각형의 넓이를 출력한다.
    시간 제한 : 1초
    메모리 제한 : 1초

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] histogram;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (true) {
            String readLine = br.readLine();

            // 0일 때 프로그램 종료
            if (readLine.charAt(0) == '0') break;

            // 히스토그램 배열 생성
            st = new StringTokenizer(readLine, " ");
            int N = Integer.parseInt(st.nextToken());
            histogram = new int[N];
            for (int i = 0; i < N; i++) {
                histogram[i] = Integer.parseInt(st.nextToken());
            }
            // 가장 큰 넓이 출력
            sb.append(maxAreaHistogram(0, N - 1)).append('\n');
            histogram = null;
        }

        System.out.println(sb);
    }

    private static long maxAreaHistogram(int low, int high) {

        if (high == low) return histogram[low];

        int mid = (low + high) / 2;

        long leftArea = maxAreaHistogram(low, mid);
        long rightArea = maxAreaHistogram(mid + 1, high);

        long maxArea = Math.max(leftArea, rightArea);

        // 구간의 최대 넓이
        // 가장 큰 높이를 구하고 해당 높이에서 옆으로 확장
        maxArea = Math.max(maxArea, maxLrArea(low, high, mid));

        return maxArea;
    }

    private static long maxLrArea(int low, int high, int mid) {
        int toLeft = mid;
        int toRight = mid;

        long height = histogram[mid];

        // 처음에는 너비가 1
        long maxArea = height;

        // 중간으로 쪼개서 왼쪽과 오른쪽으로 확장한다.
        while (low < toLeft && toRight < high) {

            // 만약 toRight + 1의 값이 toLeft + 1보다 높이가 큰 경우
            if (histogram[toLeft - 1] < histogram[toRight + 1]) {
                // 오른쪽으로 확장해준다.
                toRight++;
                // 가장 작은 높이 값과 확장될 값을 비교해야하므로 현재 저장된 높이와 toRight의 높이 중 작은 값을 height에 갱신해준다.
                height = Math.min(height, histogram[toRight]);
            } else { // 아닐 경우
                // 왼쪽으로 확장해준다.
                toLeft--;
                // 가장 작은 높이 값과 확장될 값을 비교해야하므로 현재 저장된 높이와 toLeft의 높이 중 작은 값을 height에 갱신해준다.
                height = Math.min(height, histogram[toLeft]);
            }

            // 최대 넓이 갱신
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        // 왼쪽 구간을 모두 탐색해서 while문이 종료됐는데 오른쪽 구간을 더 확장할 수 있는 경우
        while (toRight < high) {
            toRight++;
            // 역시나 작은 값을 height에 갱신해주고
            height = Math.min(height, histogram[toRight]);

            // 넓이 또한 갱신
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        // 오른쪽 구간을 모두 탐색해서 while문이 종료됐는데 왼쪽 구간을 더 확장할 수 있는 경우
        while (low < toLeft) {
            toLeft--;
            // 역시나 작은 값을 height에 갱신해주고
            height = Math.min(height, histogram[toLeft]);

            // 넓이 또한 갱신
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        return maxArea;
    }
}
