import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {
    static long N, K;
    static List<long[]> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());

        long s = 0, e = (long)Math.round(Math.sqrt(K));

        String ans = "NO";
        while(s <= e) {
            long mid = (s + e) / 2;

            long ret = can(mid);

            if(ret == 0)  {
                ans = "YES"; break;
            } else if(ret < 0) {
                e = mid-1;
            } else {
                s = mid+1;
            }
        }

        System.out.println(ans);

    }

    static long can(long target) {
        long remain = N - target;

        long cnt = (remain + 1) * (target + 1);

        return K - cnt;
    }
}
