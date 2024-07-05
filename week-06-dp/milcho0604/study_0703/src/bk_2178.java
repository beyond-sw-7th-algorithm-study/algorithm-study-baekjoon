import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bk_2178 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] maps = new int[n][m];
        visited = new boolean[n][m];

//        구글링을 통해서 입력받는 방법을 작성
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                maps[i][j] = line.charAt(j) - '0';
            }
        }
        bfs(0, 0, maps);
    }

    private static void bfs(int x, int y, int[][] maps) {
        Queue<int[]> myQue = new LinkedList<>();
        myQue.offer(new int[]{x, y, 1});    // 큐에다가 거리를 달고 다님, 시작 지점 추가, 시작 지점부터 카운트니 +0이 아닌 +!
        visited[x][y] = true;

        while (!myQue.isEmpty()) {
            int[] now = myQue.poll();
            int cx = now[0];    // 현재 x 값 초기값: 0
            int cy = now[1];    // 현재 y 값 초기값: 0
            int dist = now[2];  // 현재 거리 초기값: 1

            if (cx == n - 1 && cy == m - 1) {   // 종료조건: 목적지에 도착한다면 현재의 x, y 값이
                System.out.println(dist);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];    // 이동할 x 값, 바로 다음
                int ny = cy + dy[i];    // 이동할 y 값, 바로 다음

//                maps의 범위를 벗어나지 않고, 이동할 x, y의 값이 1이고, 방문하지 않은 경우메만 방문하는  로직
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
//                    큐에 이동할 값을 현재 값으로 추가해주고 거리를 1증ㄱ시킨다
                    myQue.add(new int[]{nx, ny, dist + 1});
                }
            }
        }
        System.out.println(-1);
    }
}
