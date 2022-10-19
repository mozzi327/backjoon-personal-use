package level6_문자열_Clear.Q4_2675_문자열반복;

/*
문제) 문자열 반복
    문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오.
    즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다. S에는 QR Code "alphanumeric" 문자만 들어있다.
    QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.

입력)
    첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8), 문자열 S가 공백으로 구분되어 주어진다.
    S의 길이는 적어도 1이며, 20글자를 넘지 않는다.

출력)
    각 테스트 케이스에 대해 P를 출력한다.

시간복잡도)
    S(=20), R(=8) 160^2 = 25,600 < 100,000,000(1sec)


*/

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numOfTestCase = Integer.parseInt(br.readLine());


        for (int i = 0; i < numOfTestCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int numOfRepeat = Integer.parseInt(st.nextToken());
            String inputString = st.nextToken();

            for (int i1 = 0; i1 < inputString.length(); i1++) {
                for (int i2 = 0; i2 < numOfRepeat; i2++) {
                    bw.write(inputString.charAt(i1));
                }
            }
            bw.write("\n");
        }


        br.close();
        bw.close();
    }
}
