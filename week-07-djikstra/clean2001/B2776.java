import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static int[] arr1;
    static int[] arr2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(T-- >0) {
            N = Integer.parseInt(br.readLine());
            arr1 = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; ++i) {
                arr1[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr1);

            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; ++i) {
                int t = Integer.parseInt(st.nextToken());

                bw.write(binarySearch(t) + "\n");
            }

            bw.flush();
        }
    }

    static int binarySearch(int target) {
        int s = 0, e = arr1.length-1;
        while(s <= e) {
            int mid = (s + e) / 2;

            if(target == arr1[mid]) {
                return 1;
            }

            if(arr1[mid] < target) {
                s = mid+1;
            } else {
                e = mid-1;
            }
        }

        return 0;
    }
}
