package no1535;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] L = new int[n]; //체력
        int[] J = new int[n]; //기쁨
        int[] dp = new int[100];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n; i++) {
            J[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 99; j >= L[i] ; j--) {
                dp[j] = Math.max(dp[j-L[i]]+J[i], dp[j]);
            }
        }
        System.out.println(dp[99]);
    }
}
