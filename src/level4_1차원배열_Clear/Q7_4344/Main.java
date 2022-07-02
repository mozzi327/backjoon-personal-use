package level4_1차원배열_Clear.Q7_4344;

/*
문제) 평균은 넘겠지
    대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다.
    당신은 그들에게 슬픈 진실을 알려줘야 한다.

입력)
    첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
    둘째 줄부터 각 테스트 케이스마다 학생의 수 N 이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다.
    (1 ≤ N ≤ 1000, N은 정수)
    점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.

출력)
    각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.

*/

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        생각해야할 것들)
        1. 첫째 줄엔 테스트 케이스 개수
        2. 둘째 줄부턴 첫째 칸 학생수, 두번째부터는 점수
        3. 그 줄에서 평균을 구하고 평균보다 큰 학생의 수를 구하는 것
        4. 비율은 반올림해서 소수점 셋째 자리까지 출력해야 함
        5. % 문자열 붙여야하나?
        6. String 배열 Integer 형 ArrayList로 바로 바꾸기
        -> (ArrayList<Integer>) Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt);

        Sudo Code)
        1. 입력을 받기 위한 BufferedReader 를 선언한다.
        2. 첫째 줄에 테스트 케이스의 개수가 주어지므로 Integer 형의 N을 선언한다.
        3. 첫째 칸에 주어지는 사람 수(num)
            , 총합(sum)
            , 평균(avg)
            , 평균보다 높은 사람 수(cnt)
            , 점수(stNum)
            , 평균을 비교하기 위해 점수를 담는 Interger 형의 ArrayList(arr)
            , StringTokenizer(st)
           를 선언한다.
        4. N만큼의 for문을 돌려 첫 번째 토큰은 num에 담는다.(사람 수) -> sum, cnt는 for문이 실행될 때마다 초기화
        5. 1 ~ num + 1 범위만큼 for문을 실행하여 stNum에 점수를 담고 arr에 stNum을 담아준다. -> sum(총합)에 ++ 해준다.
        6. for문을 통해 나온 총합으로 평균(avg)을 구한다. -> avg = sum / num
        7. for문을 실행하여 점수(x) > avg 이면 cnt ++ 해준다.
        8. cnt / (double) num * 100 -> 소수점 셋째짜리까지 출력해준다. (System.out.printf)
        9. BufferedReader를 닫아준다. (br.close())
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num, sum, avg, cnt, stNum;
        ArrayList<Integer> arr;
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            sum = 0;
            cnt = 0;
            arr = new ArrayList<>();
            for (int j = 1; j < num + 1; j++) {
                stNum = Integer.parseInt(st.nextToken());
                arr.add(stNum);
                sum += stNum;
            }
            avg = sum / num;
//            System.out.println(arr.toString());
//            System.out.println(avg);
            for (int x : arr
            ) {
                if (x > avg) {
                    cnt++;
                }
            }
            System.out.printf("%.3f%%\n", (cnt/(double)num)*100);
        }
        br.close();
    }
}
