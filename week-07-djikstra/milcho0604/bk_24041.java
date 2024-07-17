import java.io.*;
import java.util.*;

public class bk_24041 {
    static long n,g, k;
    static long left = 1, right = Integer.MAX_VALUE -1;
    static Ingredient[] ings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        g = Long.parseLong(st.nextToken());
        k = Long.parseLong(st.nextToken());

        ings = new Ingredient[(int) n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ings[i] = new Ingredient(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

// 며칠후까지 먹을 수 있는지를 이분탐색으로
        while (left < right) {
            int mid = (int)((left + right + 1) / 2);
            boolean isUnderG = chkVirus(mid);

            if(isUnderG) left = mid;
            else right = mid-1;
        }
        System.out.println(left);
    }

    // 먹을 수 없는 지경이면 -1 return
// 아니면 세균수 합 return
    static boolean chkVirus(int x){
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        long cnt = k;
        long sum = 0;// 세균수 합
        for (Ingredient ing : ings) {
            long virus = ing.s * Math.max(1, x - ing.l);// x일 후의 세균 수
            if (ing.o) {// 뺄 수 있는 재료
                pq.add(virus);
            }
            sum += virus;// 총세균수에 더해줬는데
            if (sum > g) {
// 안심하고 먹을 수 없는 지경 더 할 필요 없이
                if (cnt == 0 || pq.isEmpty()) {
                    return false;
                }
                cnt--;
                sum -= pq.poll();
            }
        }
        while(cnt > 0 && !pq.isEmpty()){// 뺄 수 있는거 다 뺴준 세균수 구할라고
            sum -= pq.poll();
            cnt--;
        }
        return sum <= g;
    }

}

class Ingredient {
    long s, l;
    boolean o;

    public Ingredient(long s, long l, int o) {
        this.s = s;
        this.l = l;
        if (o == 1) {// 안중요해서 뺄 수 있음
            this.o = true;
        } else {
            this.o = false;
        }
    }
}