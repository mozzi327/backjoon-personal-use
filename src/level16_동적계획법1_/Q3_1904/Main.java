package level16_동적계획법1_.Q3_1904;


/*
문제) 01타일
    지원이에게 2진 수열을 가르쳐 주기 위해, 지원이 아버지는 그에게 타일들을 선물해주셨다.
    그리고 이 각각의 타일들은 0 또는 1이 쓰여 있는 낱장의 타일들이다.

    어느 날 짓궂은 동주가 지원이의 공부를 방해하기 위해 0이 쓰여진 낱장의 타일들을 붙여서 한 쌍으로 이루어진 00 타일들을 만들었다.
    결국 현재 1 하나만으로 이루어진 타일 또는 0타일을 두 개 붙인 한 쌍의 00타일들만이 남게 되었다.

    그러므로 지원이는 타일로 더 이상 크기가 N인 모든 2진 수열을 만들 수 없게 되었다.
    예를 들어, N=1일 때 1만 만들 수 있고, N=2일 때는 00, 11을 만들 수 있다. (01, 10은 만들 수 없게 되었다.)
    또한 N=4일 때는 0011, 0000, 1001, 1100, 1111 등 총 5개의 2진 수열을 만들 수 있다.

    우리의 목표는 N이 주어졌을 때 지원이가 만들 수 있는 모든 가짓수를 세는 것이다.
    단 타일들은 무한히 많은 것으로 가정하자.

입력)
    첫 번째 줄에 자연수 N이 주어진다. (1 ≤ N ≤ 1,000,000)

출력)
    첫 번째 줄에 지원이가 만들 수 있는 길이가 N인 모든 2진 수열의 개수를 15746으로 나눈 나머지를 출력한다.
    시간 제한 : 0.75초
    메모리 제한 : 256MB
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 1, 00타일
    /*
        n = 1일 경우 : 1
        n = 2일 경우 : 11, 00
        n = 3일 경우 : 100(1+00), 111(1+11 or 11+1 or 1+1+1), 001(00+1)
        n = 4일 경우 : 0011, 0000, 1001, 1100, 1111
        n = 5일 경우 : 00001, 00111, 11111, 10011, 10000, 11001, 11100, 00100,
        1 2 3 5 8(피보나치?)
    */

    private static int[] dp = new int[1000001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int a = 1;
        int b = (N==1) ? 1 : 2;

        while (N-->2) {
            int tmp = (a+b) % 15746;
            a = b;
            b = tmp;
        }

        System.out.println(b);
    }

//    private static int tileDp(int N) {
//        if (N == 0) return 0;
//        if (N == 1) return 1;
//        if (N == 2) return 2;
//        if (dp[N] != 0) return dp[N];
//        dp[N] = (tileDp(N-1) + tileDp(N-2)) % 15746;
//        return dp[N] % 15746;
//    }

    private static int readInt() throws IOException {
        boolean isNegative = false;
        int value = 0;
        while (true) {
            int input = System.in.read();
            if (input == '\n' || input == ' ')
                return (isNegative) ? -1 * value : value;
            else if (input == '-') isNegative = true;
            else value = value * 10 + (input - 48);
        }
    }
}

