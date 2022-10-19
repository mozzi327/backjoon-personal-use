package level6_문자열_Clear.Q9_2941_크로아티아알파벳;

/*
문제) 크로아티아 알파벳
    예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다. 따라서, 다음과 같이 크로아티아 알파벳을 변경해서 입력했다.

        크로아티아 알파벳	    변경
                č	        c=
                ć	        c-
                dž	        dz=
                đ	        d-
                lj	        lj
                nj	        nj
                š	        s=
                ž	        z=
    예를 들어, ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다.
    단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
    dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다.
    lj와 nj도 마찬가지이다. 위 목록에 없는 알파벳은 한 글자씩 센다.

입력)
    첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다.
    단어는 크로아티아 알파벳으로 이루어져 있다. 문제 설명의 표에 나와있는 알파벳은 변경된 형태로 입력된다.

출력)
    입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
    시간 제한	    메모리 제한	제출	    정답	    맞힌 사람	    정답 비율
        1 초	    128 MB	    110402	48826	41492	    44.690%

*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] croatiaAlphabetArray = {"c=", "c-" ,"d-", "lj", "nj", "s=", "z="};
        Scanner sc = new Scanner(System.in);
        String inputCroatiaWord = sc.nextLine();
        String isTrueCroatiaAlphabet;
        String isTrueThreeWordCroatiaAlphabet;
        int totalNumOfCroatiaAlphabet = inputCroatiaWord.length();
        Boolean isTrue = false;


        for (int i = 0; i < inputCroatiaWord.length() - 1; i++) {
            isTrueCroatiaAlphabet = inputCroatiaWord.substring(i, i+2);
            for (int j = 0; j < croatiaAlphabetArray.length; j++) {
                if(isTrueCroatiaAlphabet.equals(croatiaAlphabetArray[j])) {
                    totalNumOfCroatiaAlphabet--;
                }
            }
        }

        for (int i = 0; i < inputCroatiaWord.length()-2; i++) {
            isTrueThreeWordCroatiaAlphabet = inputCroatiaWord.substring(i, i+3);
            if (isTrueThreeWordCroatiaAlphabet.equals("dz=")) totalNumOfCroatiaAlphabet--;
        }
        System.out.print(totalNumOfCroatiaAlphabet);
    }
}
