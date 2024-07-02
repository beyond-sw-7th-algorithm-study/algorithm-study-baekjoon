import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while(true) {
      int n, m;
      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = (int)Math.round((Double.parseDouble(st.nextToken()) * 100.0));

      if(n == 0) break; // 종료

      int[][] dp = new int[n+1][m+1]; // 담기는 수: 칼로리

      ArrayList<int[]> list = new ArrayList<>();
      list.add(new int[] {0, 0});
      for(int i=1; i<=n; ++i) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = (int)Math.round((Double.parseDouble(st.nextToken()) * 100.0));
        list.add(new int[] {a, b});
      }
      list.sort((a, b) -> a[1] - b[1]);

      for(int i=1; i<=n; ++i) {
        for(int j=0; j<=m; ++j) {
          if(j - list.get(i)[1] >= 0) {
            dp[i][j] = Math.max(dp[i-1][j-list.get(i)[1]] + list.get(i)[0], Math.max(dp[i][j-list.get(i)[1]] + list.get(i)[0], dp[i-1][j]));
          } else {
            dp[i][j] = dp[i-1][j];
          }
        }
      }

      bw.write(dp[n][m] + "\n");
    }

    bw.flush();
  }

}