import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[][] input;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        input = new int[2][N+1];
        dp = new int[N+2];

        for(int i=1; i<=N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            input[0][i] = Integer.parseInt(st.nextToken());
            input[1][i] = Integer.parseInt(st.nextToken());
        }


        for(int i=1; i<=N; ++i) {
            int time = input[0][i];
            for(int j=i+time; j<=N+1; ++j) {
                dp[j] = Math.max(input[1][i] + dp[i], dp[j]);
            }
        }

        int ans = 0;
        for(int i=1; i<=N+1; ++i) {
//            System.out.print(dp[i] + " ");
            ans = Math.max(dp[i], ans);
        }

        System.out.println(ans);
    }
}