import java.io.*;
import java.util.*;
// 2477. 참외밭
class Main {
  static int K; // 1 제곱 미터당 참외의 개수
  static ArrayList<Line> lines;
  static class Line {
    int len;
    int direction;

    Line(int direction, int len) {
      this.len = len;
      this.direction = direction;
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    lines = new ArrayList<>();

    K = Integer.parseInt(br.readLine());

    for(int i=0; i<6; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int d = Integer.parseInt(st.nextToken()); // d는 방향을 의미합니다.
      int l = Integer.parseInt(st.nextToken()); // l은 변의 길이를 의미합니다.

      lines.add(new Line(d, l));
    }

    // 가로, 세로에서 가장 긴 변 구하기
    int maxH = -1, maxV = -1;
    int maxHIdx = -1, maxVIdx = -1;
    boolean[] vis = new boolean[6]; // false로 자동으로 초기화 됩니다. (프로그래머스에서는 가끔 수동으로 초기화 해야 통과되는 문제도 존재)
    for(int i=0; i<6; ++i) {
      Line cur = lines.get(i);
      if(cur.direction == 1|| cur.direction == 2) { // 가로인 경우 (동, 서)
        if(maxH < cur.len) {
          maxHIdx = i;
          maxH = cur.len;
        }
      } else { // 세로인 경우 (남, 북)
        if(maxV < cur.len) {
          maxVIdx = i;
          maxV = cur.len;
        }
      }
    }

    // 가로, 세로에서 가장 긴 변 방문처리
    vis[maxHIdx] = true;
    vis[maxVIdx] = true;

    // 작은 직사각형의 변 구하기 -> vis가 4연속 false라면, 가운데에 있는 두 변이 작은 직사각형의 변이다.
    int smallLen1 = 0, smallLen2 = 0;
    for(int i=0; i<6; ++i) {
      if(!vis[i] && !vis[(i+1)%6] && !vis[(i+2)%6] && !vis[(i+3)%6]) {
        smallLen1 = lines.get((i+1)%6).len;
        smallLen2 = lines.get((i+2)%6).len;
      }
    }

    System.out.println((maxH * maxV - smallLen1 * smallLen2) * K); // 답은 넓이 * K
  }
}