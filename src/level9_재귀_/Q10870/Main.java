package level9_재귀_.Q10870;

// 문제이름 : 피보나치 수
// 주제    : 재귀
// 문제번호 : 10870번
// 진행여부 : 완료 [@]
// 통과날짜 : 2022-04-15 (금)

// input  : n(0 ~ 20 사이의 자연수 혹은 0)
// return : n번째 피보나치 수 출력

import java.util.*;

public class Main {

    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) {
        ArrayList<Integer> answerList = new ArrayList<>();
        answerList.add(0);
        answerList.add(1);
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 2; i <= N; i++) {
            int sum = fibonacci(i-1) + fibonacci(i-2);
            answerList.add(sum);
        }
        System.out.println(answerList.get(N));
    }
}
