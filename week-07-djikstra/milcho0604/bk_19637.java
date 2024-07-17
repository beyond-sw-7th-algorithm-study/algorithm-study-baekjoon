import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk_19637 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] damage = new String[n];
        int[] power = new int[n];

        // 배열을 채우는 과정(입력받는 데미지와 파워)
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            damage[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }

        // 점수를 입력하고 이분 탐색 메서드를 호출
        for (int i = 0; i < m; i++) {
            int score = Integer.parseInt(br.readLine());
            binarySearch(score, damage, power);
        }
        System.out.println(sb);
    }

    private static void binarySearch(int score, String[] damage, int[] power) {
        int left = 0;
        int right = n - 1;
        int target = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (score <= power[mid]) {
                right = mid - 1;
                target = mid;
            } else {
                left = mid + 1;
            }
        }

        if (target != -1) {
            sb.append(damage[target]).append("\n");
        }
    }
}
