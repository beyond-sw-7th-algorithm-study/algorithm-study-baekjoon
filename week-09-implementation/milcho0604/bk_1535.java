import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk_1535 {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int health = 100; // 초기 체력 설정
        int[] stamina = new int[n]; // 체력 소비량 배열
        int[] happy = new int[n]; // 행복 값 배열
        int[] dp = new int[health + 1];

        // 체력 소비량 입력 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            stamina[i] = Integer.parseInt(st.nextToken());
        }

        // 행복 값 입력 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            happy[i] = Integer.parseInt(st.nextToken());
        }

        // 점화식 적용(n번 반복)
        for (int i = 0; i < n; i++) {
            for (int j = health; j > stamina[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stamina[i]] + happy[i]);
            }
        }

        int maxHappy = 0;
        for (int i = 1; i <= health; i++) {
            maxHappy = Math.max(maxHappy, dp[i]);
        }

        System.out.println(maxHappy);
    }
}
