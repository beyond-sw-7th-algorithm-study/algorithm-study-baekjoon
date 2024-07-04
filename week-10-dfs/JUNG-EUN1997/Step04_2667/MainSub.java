package group08.Step04_2667;



/*
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
---
3
7
8
9
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        map = new int[N][N];
        visited = new boolean[N][N];
        List<ArrayList> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < str.length; j++) {
                String s = str[j];
                map[i][j] = Integer.parseInt(s);
            }
        }

        queue.offer(new int[]{0, 0});
        System.out.println(Arrays.deepToString(map));
        bfs(queue);
    }

    static void bfs(Queue<int[]> queue) {

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int N = map.length;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                // 방문을 거나 0이라면 PASS
                if (map[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                }
                // 여기서 어떻게 그룹여부를 나누징.. :3
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
            }
        }
    }
}
