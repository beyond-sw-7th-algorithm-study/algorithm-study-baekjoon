import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bk_2667 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int[] answer;
    static int count;
    static List<Integer> apart;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

//        정사각형의 map
        int[][] maps = new int[n][n];
        visited = new boolean[n][n];
        apart = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                maps[i][j] = line.charAt(j) - '0';
            }
        }

        // 전체 지도를 탐색하여 단지 찾기,
        // dfs(0,0,maps)로 호출하는 방식을 사용했는데 이와 같은 방식으로 호출하면 올바른 결과값이 나오지 않움
        // 아래에서 bfs를 재귀호출하고 끝나고 나면 다시 현재 반복문으로 오는 것이기 때문에 하나의 단지를 탐색하고
        // 다음 단지를 탐색하는 것과 같음
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (maps[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, maps);
//                    1의 개수만큼 단지 번호이기 때문에 1의 개수를 카운트하여 단지의 번호를 리스트에 추가
                    apart.add(count);
//                    하나의 단지가 끝나고나면 다시 count를 0으로 초기화
                    count = 1;
                }
            }
        }
        System.out.println(apart.size());
        Collections.sort(apart);
        for(int a : apart){
            System.out.println(a);
        }

    }

    private static void bfs(int x, int y, int[][] maps) {
        Queue<int[]> myQue = new LinkedList<>();
        myQue.offer(new int[]{x, y});
        visited[x][y] = true;
        count=1;

        while (!myQue.isEmpty()) {
            int[] now = myQue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];    // 이동할 x 값, 바로 다음
                int ny = now[1] + dy[i];    // 이동할 y 값, 바로 다음
//                maps의 범위를 벗어나지 않고, 이동할 x, y의 값이 1이고, 방문하지 않은 경우메만 방문하는 로직
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    myQue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }
    }
}
