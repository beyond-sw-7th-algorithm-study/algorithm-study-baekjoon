import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bk_16953_dfs {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
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
            // 큐의 크기를 미리 저장
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
                // 오른쪽에 1을 추가하는 연산
                if (now * 10 + 1 <= target) {
                    myQue.add(now * 10 + 1);
                }
            }
        }
        System.out.println(-1);
    }
}
