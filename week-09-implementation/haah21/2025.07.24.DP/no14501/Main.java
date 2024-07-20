package no14501;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N]; //상담 완료하는데 걸리는 기간
        int[] P = new int[N]; //상담했을때 받을 수 있는 금액
        int[] dp = new int[N+1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            if(i+T[i] <= N){ // N일 이후에는 퇴사해서 못들으므로 N기간 이내로 설정
                dp[i+T[i]] = Math.max(dp[i+T[i]],dp[i]+P[i]);
            }
            dp[i+1] = Math.max(dp[i],dp[i+1]);
        }
        System.out.println(dp[N]);
    }
}
