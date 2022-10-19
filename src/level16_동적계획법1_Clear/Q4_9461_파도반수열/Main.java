package level16_동적계획법1_Clear.Q4_9461_파도반수열;

// 피보나치 수와 비슷한 규칙을 찾아 동적 계획법으로 푸는 문제

/*
문제) 파도반 수열
    오른쪽 그림과 같이 삼각형이 나선 모양으로 놓여져 있다.
    첫 삼각형은 정삼각형으로 변의 길이는 1이다.
    그 다음에는 다음과 같은 과정으로 정삼각형을 계속 추가한다.
    나선에서 가장 긴 변의 길이를 k라 했을 때, 그 변에 길이가 k인 정삼각형을 추가한다.
    파도반 수열 P(N)은 나선에 있는 정삼각형의 변의 길이이다.
    P(1)부터 P(10)까지 첫 10개 숫자는 1, 1, 1, 2, 2, 3, 4, 5, 7, 9이다.
    N이 주어졌을 때, P(N)을 구하는 프로그램을 작성하시오.

입력)
    첫째 줄에 테스트 케이스의 개수 T가 주어진다.
    각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. (1 ≤ N ≤ 100)

출력)
    각 테스트 케이스마다 P(N)을 출력한다.

*/


import java.io.*;

public class Main {
    /*
        동적 계획법을 이용한 풀이
        Sudo Code)
            1. 계산 값을 잠시 저장하고, 사용하고 초기화하기 위해 Long타입의 배열을 정적으로 선언한다.
            2. BufferedReader를 통해 input 값을 받는다.
            input
                - N : 테스트 케이스 수
                - num : num 번째, 파도반 수열 인덱스
            3. 계산된 값을 순차적으로 출력하기 위해 BufferedWriter 객체를 생성
            4. 동적 계획법을 이용한 메서드 구현
                - padovanSequence(num) = padovanSequence(num-3) + padovanSequence(num-2)
                - 위 계산식을 통해 재귀적으로 메서드를 구현해준다.
                - 단, 정적으로 선언된 배열에 값이 있는지 확인하고 계산된 값을 리턴하는 식으로 메서드를 구현해준다. (동적 계획법)
            5. 반복문을 돌려 num+1만큼 배열의 크기를 선언하고 계산 메서드에 num을 넘겨준다.
            6. 계산된 값을 BufferedWriter에 쌓아준다.
            7. 계산된 값 순차적으로 출력
    */


    static Long[] padovan = new Long[101];
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            bw.write(String.valueOf(padovanSequence(Integer.parseInt(br.readLine()))+"\n"));
        }
        br.close();
        bw.close();
    }

    public static long padovanSequence(int num) {
        // num 은 파도반 수열의 수
        if (num == 0) return 0;
        else if (num == 1) return 1;
        else if (num == 2) return 1;
        else if (num == 3) return 1;
        if (padovan[num] != null) return padovan[num];
        padovan[num] = padovanSequence(num-3) + padovanSequence(num-2);
        return padovan[num];
    }
}
