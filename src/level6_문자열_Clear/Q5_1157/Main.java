package level6_문자열_Clear.Q5_1157;


import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
문제) 단어 공부
    알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오.
    단, 대문자와 소문자를 구분하지 않는다.

입력)
    첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다.
    주어지는 단어의 길이는 1,000,000을 넘지 않는다.

출력)
    첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다.
    단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.

    시간 제한	메모리 제한
    2 초,	128 MB

시간복잡도)
    wordLength(=1,000,000) 1,000,000^2 = 1,000,000,000,000(10000sec) (x) 
    -> 1,000,000(N) o
    

*/
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String inputWord = sc.nextLine().toLowerCase();
        int[] alphabet = new int[26];

        for (int i = 0; i < inputWord.length(); i++) {
            alphabet[(int)inputWord.charAt(i) - 97] += 1;
        }

        int popularWordCountValue = Arrays.stream(alphabet)
                .max().getAsInt();

        int popularWordCountIdx = 0;
        int tmpCount = 0;
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == popularWordCountValue) {
                popularWordCountIdx = i;
                tmpCount++;
            }
        }

        if (tmpCount != 1) {
            System.out.println("?");
        } else {
            System.out.println((char)(popularWordCountIdx+65));
        }

    }
}
