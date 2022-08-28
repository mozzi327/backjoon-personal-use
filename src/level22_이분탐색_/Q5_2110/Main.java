package level22_이분탐색_.Q5_2110;

/*
문제) 공유기 설치
    도현이의 집 N개가 수직선 위에 있다.
    각각의 집의 좌표는 x1, ..., xN이고, 집 여러개가 같은 좌표를 가지는 일은 없다.

    도현이는 언제 어디서나 와이파이를 즐기기 위해서 집에 공유기 C개를 설치하려고 한다.
    최대한 많은 곳에서 와이파이를 사용하려고 하기 때문에, 한 집에는 공유기를 하나만 설치할 수 있고,
    가장 인접한 두 공유기 사이의 거리를 가능한 크게 하여 설치하려고 한다.

    C개의 공유기를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램을 작성하시오.

입력)
    첫째 줄에 집의 개수 N (2 ≤ N ≤ 200,000)과 공유기의 개수 C
    (2 ≤ C ≤ N)이 하나 이상의 빈 칸을 사이에 두고 주어진다.
    둘째 줄부터 N개의 줄에는 집의 좌표를 나타내는 xi (0 ≤ xi ≤ 1,000,000,000)가 한 줄에 하나씩 주어진다.

출력)
    첫째 줄에 가장 인접한 두 공유기 사이의 최대 거리를 출력한다.
*/

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        int N = readInt();
        int C = readInt();
        int[] wifiArr = new int[N];
        for (int i = 0; i < N; i++) {
            wifiArr[i] = readInt();
        }
        Arrays.sort(wifiArr);
        // 1, 2, 4, 8, 9
        // lo = 1;
        int low = 1;
        int high = wifiArr[N - 1] - wifiArr[0] + 1;

        while (low < high) {
            // 5
            int mid = (low + high) / 2;
            if (canInstall(mid, wifiArr) < C) high = mid;
            else low = mid + 1;
        }
        System.out.println(low - 1);
    }

    private static int canInstall(int distance, int[] wifiArr) {
        int count = 1;
        int lastLocate = wifiArr[0]; // 1

        for (int i = 0; i < wifiArr.length; i++) {
            int curLocate = wifiArr[i]; // 8

            if (curLocate - lastLocate >= distance) {
                count++;
                lastLocate = curLocate;
            }
        }
        return count;
    }

    private static int readInt() throws IOException {
        boolean isNegative = false;
        int value = 0;
        while (true) {
            int input = System.in.read();
            if(input == ' ' || input == '\n') {
                return (isNegative) ? -1 * value
                        : value;
            } else if (input == '-') {
                isNegative = true;
            } else {
                value = value * 10 + (input - 48);
            }
        }

    }
}


class Main2 {
    public static void main(String[] args) throws IOException{
        int N = readInt();
        int C = readInt();
        int[] wifiArr = new int[N];
        for (int i = 0; i < N; i++) {
            wifiArr[i] = readInt();
        }
        Arrays.sort(wifiArr);
        // 1, 2, 4, 8, 9
        // lo = 1;
        int lowGap = 1;
        int highGap = wifiArr[N - 1] - wifiArr[0];
        int result = 0;

        while (lowGap <= highGap) {
            int midGap = (lowGap + highGap) / 2;
            int preValue = wifiArr[0];
            int count = 1;
            for (int i = 0; i < N; i++) {
                if (wifiArr[i] >= preValue + midGap) {
                    preValue = wifiArr[i];
                    count += 1;
                }
            }
            if (count >= C) {
                lowGap = midGap + 1;
                result = midGap;
            } else {
                highGap = midGap - 1;
            }
        }
        System.out.println(result);
    }

    private static int readInt() throws IOException {
        boolean isNegative = false;
        int value = 0;
        while (true) {
            int input = System.in.read();
            if(input == ' ' || input == '\n') {
                return (isNegative) ? -1 * value
                        : value;
            } else if (input == '-') {
                isNegative = true;
            } else {
                value = value * 10 + (input - 48);
            }
        }
    }
}

