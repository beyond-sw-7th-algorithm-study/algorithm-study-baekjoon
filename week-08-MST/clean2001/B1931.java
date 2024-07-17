import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<long[]> list = new ArrayList<>();

        for(int i=0; i<N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long s = Integer.parseInt(st.nextToken());
            long e = Integer.parseInt(st.nextToken());
            list.add(new long[] {s, e});
        }

        list.sort((v, w) -> {
            if(v[1] == w[1]) return Long.compare(v[0], w[0]);

            return Long.compare(v[1], w[1]);
        }); // 끝나는 시간 오름차순

        long prev = -1;
        int cnt = 0;
        for (long[] v : list) {
            if(prev > v[0]) continue;
            cnt++;
            prev = v[1];
        }

        System.out.println(cnt);
    }
}
