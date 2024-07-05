import java.io.*;
import java.util.*;

class Main {
  static int[][] dp;
  static int[][] arr;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    arr = new int[N+1][2];

    for(int i=1; i<=N; ++i) {
      st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }


    dp = new int[N+1][K+1];
//    for(int i=1; i<=N; ++i) {
//      dp[i][arr[i][0]] = arr[i][1];
//    }

    for(int i=1; i<=N; ++i) { // 몇번째 배낭?
      for(int j=0; j<=K; ++j) {
        if(j - arr[i][0] >= 0) {
          dp[i][j] = Math.max(dp[i-1][j-arr[i][0]] + arr[i][1], dp[i-1][j]);
        } else {
          dp[i][j] = dp[i-1][j];
        }

      }
    }


//    System.out.println(Arrays.deepToString(dp));
    System.out.println(dp[N][K]);
  }
}