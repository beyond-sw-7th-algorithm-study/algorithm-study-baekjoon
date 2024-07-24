import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk_14501 {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int answer = 0;

    // 점화식: dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
    // dp[i]: i번째 날까지의 최대 수익
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 일수와 금액을 저장할 배열
        int[] days = new int[n];
        int[] money = new int[n];

        // 최댓값을 구할 dp 배열 (n + 1 크기)
        int[] dp = new int[n + 1];

        // 날짜와 금액을 각각 입력받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            money[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE; // 현재까지의 최대 수익 저장

        // DP 배열을 갱신하며 최대 수익 계산
        for (int i = 0; i < n + 1; i++) {
            // i번째 날까지의 최대 수익 갱신
            dp[i] = Math.max(dp[i], max);

            // if문 : 상담을 진행할 수 있는 걍우를 의미.
            if (i < n && i + days[i] < n + 1) {
                // 점화식 적용: 상담을 진행할 수 있는 경우 -> 수익 갱신
                dp[i + days[i]] = Math.max(dp[i + days[i]], dp[i] + money[i]);
            }
            // 현재까지의 최대 수익 갱신
            max = Math.max(dp[i], max);
        }

        // 최종 최대 수익 출력
        System.out.println(max);
    }
}
