package algorithm_example.two_pointer;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int N = 8;
        int target = 10;
        int[] data = new int[]{1, 4, 10, 2, 5, 7, 3, 6};

        int result = 0;
        int start = 0;
        int end = N - 1;
        Arrays.sort(data);

        System.out.println(Arrays.toString(data));
        while (start < end) {
            System.out.println("start = " + start);
            System.out.println("end = " + end);
            if (data[start] + data[end] == target) {
                end--;
                result++;
            }
            else if (data[start] + data[end] > target) end--;
            else if (data[start] + data[end] < target) start++;
        }

        System.out.println(result);
    }
}
