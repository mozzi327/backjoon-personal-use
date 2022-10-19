package level2_조건문_Clear.Q7_2480_주사위세개;

/*
문제) 주사위 세개
    1에서부터 6까지의 눈을 가진 3개의 주사위를 던져서 다음과 같은 규칙에 따라 상금을 받는 게임이 있다.
        1. 같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.
        2. 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
        3. 모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.
    예를 들어, 3개의 눈 3, 3, 6이 주어지면 상금은 1,000+3×100으로 계산되어 1,300원을 받게 된다.
    또 3개의 눈이 2, 2, 2로 주어지면 10,000+2×1,000 으로 계산되어 12,000원을 받게 된다.
    3개의 눈이 6, 2, 5로 주어지면 그중 가장 큰 값이 6이므로 6×100으로 계산되어 600원을 상금으로 받게 된다.

    3개 주사위의 나온 눈이 주어질 때, 상금을 계산하는 프로그램을 작성 하시오.

입력)
    첫째 줄에 3개의 눈이 빈칸을 사이에 두고 각각 주어진다.

출력)
    첫째 줄에 게임의 상금을 출력 한다.

*/

import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static int Calc(int dice, ArrayList<Integer> arr) {
        int cnt = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (dice == arr.get(i)) {
                cnt ++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dc = sc.nextLine();

        // 자바 스트림을 이용해 String 배열을 Integer 배열로 형변환
        Integer[] dcArray = Stream.of(dc.split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        ArrayList<Integer> cvtArray = new ArrayList<>(List.of(dcArray));

        int calcAmount = 0;

        // 카운트를 세서 3, 2 일 경우 계산하고 break문을 통해 for문 탈출,
        // 둘 다 아닐 경우 Collections.max 메소드를 사용해 가장 큰 값을 계산
        for (int i = 0; i < cvtArray.size(); i++) {
            int dcnt = Calc(cvtArray.get(i), cvtArray);
            if (dcnt == 3) {
                calcAmount = 10000 + cvtArray.get(i) * 1000;
                break;
            } else if (dcnt == 2) {
                calcAmount = 1000 + cvtArray.get(i) * 100;
                break;
            } else {
                int maxDice = Collections.max(cvtArray);
                calcAmount = maxDice * 100;
            }
        }
        System.out.println(calcAmount);
    }
}
