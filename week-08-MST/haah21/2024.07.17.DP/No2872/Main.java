package No2872;

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        int max = n;
        int count = 0;

        //뒤에서부터 찾기
        for (int i = n-1; i >=0 ; i--) {
            if (input[i] == max) max--; //n번째 책이 n번 자리에 있는경우 - 정렬할 필요 없음
            else {
                count++; //다른 책인 경우 위로 올려서 정렬해줘야함
            }
        }
        System.out.println(count);
    }
}
