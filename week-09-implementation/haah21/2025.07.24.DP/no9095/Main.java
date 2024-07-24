package no9095;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[11]; //입력되는 n이 1~10사이의 수이기 때문에

            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int k = 4; k <= n; k++) {
                dp[k] = dp[k-1]+dp[k-2]+dp[k-3];
            }

            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb);
    }
}
