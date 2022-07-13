package level16_동적계획법1_.Q11_2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] grapeArr = new int[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        int ans = 0;
        int arr[] = new int[N];

        if (N < 3) {
            ans += Integer.valueOf(br.readLine());
        } else {
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.valueOf(br.readLine());
            }
        }


    }

    static int drinkGrape(int[] arr) {
        if (grapeArr[2]==0) grapeArr[2] = Math.max((arr[0]+ arr[1]), Math.max((arr[1]+arr[2]), (arr[0]+arr[2])));
        if (grapeArr[3]==0) grapeArr[3] = grapeArr[0] + 1;


        return 1;
    }
}
