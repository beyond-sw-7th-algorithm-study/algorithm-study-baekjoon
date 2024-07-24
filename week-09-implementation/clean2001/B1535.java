import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] L = new int[N+1];
    int[] J = new int[N+1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=1; i<=N; ++i) {
      L[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for(int i=1; i<=N; ++i) {
      J[i] = Integer.parseInt(st.nextToken());
    }

    int[][] dp = new int[N+1][100];

    for(int i=1; i<=N; ++i) {
      for(int j=0; j<100; ++j) { // j: 사용한 체력
        if(j - L[i] >= 0)
          dp[i][j] = Math.max(dp[i-1][j-L[i]]+J[i], dp[i-1][j]);
        else dp[i][j] = dp[i-1][j];
      }
    }

    System.out.println(dp[N][99]);
  }
}
