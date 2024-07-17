package week07.Step03_17503;

// 맥주 축제
/*
3 9 5
2 5
4 6
3 3
4 3
1 4
* */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 축제가 열리는 기간 N (1 ≤ N ≤ 200,000)
        int m = Integer.parseInt(st.nextToken()); // 채워야 하는 선호도의 합 M (1 ≤ M < 231)
        int k = Integer.parseInt(st.nextToken()); // 맥주 종류의 수 K

        Queue<Integer> pq = new PriorityQueue<>(); // 우선순위 큐
        int[][] data = new int[k][2]; // 도수 기준으로 내림차순 할 용도의 이중 배열

        for (int i = 0; i < k; i++) {
            //            [맥주의 선호도]와 [도수 레벨]이 공백을 사이에 두고 주어집니다.
            st = new StringTokenizer(br.readLine());
            int like = Integer.parseInt(st.nextToken()); // 맥주의 선호도
            int level = Integer.parseInt(st.nextToken()); // 도수 레벨
            data[i][0] = level; // 도수 추가
            data[i][1] = like; // 선호도 추가
        }
        Arrays.sort(data, (o1, o2) -> {
            if (o2[0] == o1[0] && o2[1] < o1[1]) {
                return 0;
            }
//            return o2[0] - o1[0];
            return o1[0] - o2[0];
        }); // 도수 기준 오름차순

//        System.out.println(Arrays.deepToString(data));

        int total = 0;
        int answer = -1;
        for (int[] arr : data) {
            pq.add(arr[1]);
            total += arr[1];

            if (pq.size() > n) {
                total -= pq.poll();
            }

            if (pq.size() == n && total >= m) {
                answer = arr[0];
                break;
            }
        }
        System.out.print(answer);
    }
}
