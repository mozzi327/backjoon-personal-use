package algorithm_example.KMP_algorithm;

import java.util.Arrays;

/*
    문자열 매칭 알고리즘 O(N)
    접두사와 접미사를 비교해 얼마나 뛰어넘을 수 있을까 생각하는 알고리즘
*/
public class Main {
    public static void main(String[] args) {
        // 접두사와 접미사가 얼마나 일치하는 지를 구해보자.
        String str = "aaaab";
        int strSize = str.length();
        int[] table = new int[strSize];
        int j = 0;
        for (int i = 1; i < strSize; i++) {
            while (j > 0 && (str.charAt(i) != str.charAt(j))) {
                j = table[j - 1];
            }
            if (str.charAt(i) == str.charAt(j)) {
                table[i] = ++j;
            }
        }

        System.out.println(Arrays.toString(table));
    }
}
