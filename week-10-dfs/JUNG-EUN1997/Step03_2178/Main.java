package group08.Step03_2178;



/*
N×M크기의 배열로 표현되는 미로가 있다.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1

미로에서 1은 이동할 수 ((있는)) 칸을 나타내고, 0은 이동할 수 ((없는)) 칸을 나타낸다.
이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

---

4 6
101111
101010
101011
111011

---

15

* */

import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        map = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < str.length; j++) {
                String s = str[j];
                map[i][j] = Integer.parseInt(s);
                dist[i][j] = -1;
            }
        }
        queue.offer(new int[]{0, 0});
        dist[0][0] = 0;
        bfs( queue);
    }

    static void bfs(Queue<int[]> queue) {

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int N = map.length;
        int M = map[0].length;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                // 길이 아니거나, 방문을 했다면 PASS
                if (map[nx][ny] == 0 || dist[nx][ny] != -1) {
                    continue;
                }
                queue.offer(new int[]{nx, ny});
                dist[nx][ny] = dist[temp[0]][temp[1]] + 1;
            }
        }
        System.out.println(dist[N-1][M-1] +1);
    }
}
