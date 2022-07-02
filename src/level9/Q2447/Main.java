package level9.Q2447;

// 문제이름 : 별찍기
// 주제    : 재귀
// 문제번호 : 2447번
// 진행여부 : 진행중 [@]
// 통과날짜 : 2022-04-15 (금)

// input  : N(N = 3^k), k(1 ~ 7 사이의 정수)
// return : 첫째 줄부터 N번째 줄까지 별을 출력
import java.util.*;

public class Main {
    public static void main(String[] args){
        String[][] arr;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new String[N][N];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = " ";
            }
        }
    }
    public static void star(String[][] arr, int x, int y, int N) {
        if (N == 1) {
            arr[x][y] = "*";
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != 1 && j != 1) {

                }

            }
        }
    }
}
