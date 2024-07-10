import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bk_20444 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            Set<Integer> set = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                set.add(Integer.parseInt(st.nextToken()));
            }
            int k = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (set.contains(temp)) {
                    sb.append(1).append("\n");
                }else {
                    sb.append(0).append("\n");
                }

            }
        }
        System.out.println(sb);
    }
}
