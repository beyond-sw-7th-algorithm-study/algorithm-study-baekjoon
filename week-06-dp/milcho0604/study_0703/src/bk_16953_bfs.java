import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bk_16953_bfs {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[][] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        bfs(n, m);
    }

    private static void bfs(long start, long target) {
        Queue<Long> myQue = new LinkedList<>();
        myQue.offer(start);
        while (!myQue.isEmpty()) {
            count++;
//            루프 실행 중 큐의 크기가 변경될 수 있기 때문에 미리 size 변수를 선언(myQue.add로직이 있기 때문)
            int size = myQue.size();
            for (int i = 0; i < size; i++) {
                long now = myQue.poll();
                if (now == target) {
                    System.out.println(count);
                    return;
                }
                if (now * 2 <= target) {
                    myQue.add(now * 2);
                }
//                맨 오른쪽에 1을 추가하는 연산 *10을 해주고 마지막 값에 1을 추가할 수 있음 그렇지 않으면, char로 변환하거나 하는 골치 아픈 상황 발
                if (now * 10 + 1 <= target) {
                    myQue.add(now * 10 + 1);
                }
            }
        }
        System.out.println(-1);
    }
}
