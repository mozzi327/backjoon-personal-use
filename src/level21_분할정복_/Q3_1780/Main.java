package level21_분할정복_.Q3_1780;
import java.io.IOException;

/*
문제) 종이의 개수
    N×N크기의 행렬로 표현되는 종이가 있다. 종이의 각 칸에는 -1, 0, 1 중 하나가 저장되어 있다.
    우리는 이 행렬을 다음과 같은 규칙에 따라 적절한 크기로 자르려고 한다.

    만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
    (1)이 아닌 경우에는 종이를 같은 크기의 종이 9개로 자르고, 각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.
    이와 같이 종이를 잘랐을 때, -1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수,
    1로만 채워진 종이의 개수를 구해내는 프로그램을 작성하시오.

입력)
    첫째 줄에 N(1 ≤ N ≤ 37, N은 3k 꼴)이 주어진다.
    다음 N개의 줄에는 N개의 정수로 행렬이 주어진다.

출력)
    첫째 줄에 -1로만 채워진 종이의 개수를, 둘째 줄에 0으로만 채워진 종이의 개수를,
    셋째 줄에 1로만 채워진 종이의 개수를 출력한다.
    시간 제한 : 2초
    메모리 제한 256MB
*/
public class Main {
    private static int[][] paperArr;
    private static int[] result = new int[3];

    public static void main(String[] args) throws IOException{
        int N = readInt();
        paperArr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                paperArr[i][j] = readInt();
            }
        }
        divideAndConquer(0, 0, N);
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
    }

    private static boolean checked(int row, int col, int divisionN) {
        int firstValue = paperArr[row][col];
        for (int i = row; i < row + divisionN; i++) {
            for (int j = col; j < col + divisionN; j++) {
                if (firstValue != paperArr[i][j]) return false;
            }
        }
        return true;
    }

    private static void divideAndConquer(int row, int col, int N) {
        int inputPaperValue = paperArr[row][col];
        if (checked(row, col, N)) {
               if (inputPaperValue == -1) result[0] ++;
               else if (inputPaperValue == 0) result[1] ++;
               else result[2] ++;
               return;
        }
        int divisionN = N/3;

        // 9등분
        // 1
        divideAndConquer(row, col, divisionN);
        // 2
        divideAndConquer(row, col + divisionN, divisionN);
        // 3
        divideAndConquer(row, col + 2 * divisionN, divisionN);
        // 4
        divideAndConquer(row + divisionN, col, divisionN);
        // 5
        divideAndConquer(row + divisionN, col + divisionN, divisionN);
        // 6
        divideAndConquer(row + divisionN, col + 2 * divisionN, divisionN);
        // 7
        divideAndConquer(row + 2 * divisionN, col, divisionN);
        // 8
        divideAndConquer(row + 2 * divisionN, col + divisionN, divisionN);
        // 9
        divideAndConquer(row + 2 * divisionN, col + 2 * divisionN, divisionN);

    }


    private static int readInt() throws IOException {
        boolean isNegative = false;
        int value = 0;
        while (true) {
            int input = System.in.read();
            if (input == ' ' || input == '\n') {
                return (isNegative) ? -1 * value :
                        value;
            } else if (input == '-') isNegative = true;
            else value = value * 10 + (input - 48);
        }
    }
}
