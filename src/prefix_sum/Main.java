package prefix_sum;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int N = 5;
        int[] data = new int[]{10, 20, 30, 40, 50};

        // prefix 배열 계산
        int sum = 0;
        int[] prefix_sum = new int[N + 1];
        for (int i = 0; i < N; i++) {
            sum += data[i];
            prefix_sum[i + 1] = sum;
        }

        System.out.println(Arrays.toString(prefix_sum));

        // 구간합 계산
        int left = 3;
        int right = 4;
        System.out.println(prefix_sum[right] - prefix_sum[left - 1]);

    }
}
