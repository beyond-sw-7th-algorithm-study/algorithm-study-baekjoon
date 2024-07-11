import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        Map<Integer, String> map = new HashMap<>();

        for(int i=0; i<N; ++i) {
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            map.put(i, word);
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; ++i) {
            int t = Integer.parseInt(br.readLine());
            int idx = binarySearch(t);
//            bw.write("idx: " + idx + "\n");
            bw.write(map.get(idx) + "\n");
        }
        bw.flush();
    }

    static int binarySearch(int target) {
        int s = 0, e = arr.length;
        int ans = 0;
        while(s <= e) {
            int mid = (s + e) / 2;

            if(arr[mid] < target) {
                s = mid+1;
            } else { // 되는 거임
                ans = mid;
                e = mid-1;
            }
        }

        return ans;
    }
}
