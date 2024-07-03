package no2667;

import java.io.*;
import java.util.*;
public class Main {
    static int[][] Map;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static List<Integer> result;
    static int cnt, N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        result = new LinkedList<>();
        N = Integer.parseInt(br.readLine());
        Map = new int[N][N];
        visited = new boolean[N][N]; //단지에 속해있는지
        cnt = 1; //기준이 아파트(단지로 묶일 첫 아파트)가 포함될 때니 1로 초기화

        for(int i=0;i<N;i++) {
            String str = br.readLine(); //한줄을 통으로 받고
            for(int j=0;j<N;j++) {
                Map[i][j] = str.charAt(j)-'0'; //글자 한개씩 잘라서 map에 넣음
            }
        }

        for(int x=0;x<N;x++) {
            for(int y=0;y<N;y++) {
                if(Map[x][y]==1 && !visited[x][y]) {
                    dfs(x,y);
                    result.add(cnt);
                    cnt = 1;
                }
            }
        }

        Collections.sort(result);

        bw.write(result.size()+"\n");
        for(int r : result) bw.write(r+"\n");
        bw.flush();
        bw.close();

    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i=0;i<4;i++) { //아래, 위, 왼, 오 순으로탐색
            int nx = dx[i]+x;
            int ny = dy[i]+y;

            if(nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny] && Map[nx][ny]==1) {
                cnt++;
                dfs(nx,ny);
            }
        }
    }
}


