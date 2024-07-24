import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bk_9095 {
    static StringBuilder sb = new StringBuilder();
    static int answer = 0;

    //    재귀를 이용해서 비효율적인 측면을 조금이라도 개선하기 위해,
//    StringBuilder 사용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            answer = 0;
            int m = Integer.parseInt(br.readLine());
            dp(0, m);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void dp(int count, int number) {
        if (count == number) {
            answer++;
            return;
        }
        if (count > number) {
            return;
        }
        for (int i = 1; i <= 3; i++) {
            dp(count + i, number);
        }
    }
}
