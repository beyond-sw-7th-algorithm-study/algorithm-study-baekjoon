package week07.Step05_2776;

// 암기왕
/*
1
5
4 1 5 2 3
5
1 3 7 9 5
---
1
1
0
0
1
* */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트케이스

        for (int a = 0; a < t; a++) {
            int n = Integer.parseInt(br.readLine()); // 수첩 1 개수
            int[] noteN = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                noteN[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(noteN);
            int m = Integer.parseInt(br.readLine()); // 수첩 2 개수

            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < m; i++) {
                int num = Integer.parseInt(st.nextToken());
                int start = 0;
                int end = n - 1;
                int mid = 0;

                whileLoop:
                while (start <= end) {
                    mid = (start + end) / 2;
                    if (num == noteN[mid]) {
                        start = mid;
                        break whileLoop;
                    } else if (num > noteN[mid]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }

                if (num == noteN[start]) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
            sb.delete(sb.length()-1,sb.length());
            System.out.println(sb);
        }
    }
}
