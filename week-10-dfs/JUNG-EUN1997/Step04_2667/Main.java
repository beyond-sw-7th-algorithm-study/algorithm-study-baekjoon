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


import java.io.*;
import java.util.*;

public class Main2 {
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < str.length; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        List<Integer> groupSizes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    groupSizes.add(bfs(i, j, N));
                }
            }
        }

        Collections.sort(groupSizes);
        StringBuilder sb = new StringBuilder();
        sb.append(groupSizes.size()).append("\n");
        for (int size : groupSizes) {
            sb.append(size).append("\n");
        }
        System.out.println(sb);
    }

    static int bfs(int x, int y, int N) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        return count;
    }
}
