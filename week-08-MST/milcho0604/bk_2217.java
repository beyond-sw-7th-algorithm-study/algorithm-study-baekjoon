import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bk_2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] lope = new int[n];

        for (int i = 0; i < n; i++) {
            lope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(lope);
        int maxKg = 0;

        for (int i = 0; i < n; i++) {
            int weight = lope[i] * (n - i);
//            System.out.println(weight);
            maxKg = Math.max(maxKg, weight);
        }
        System.out.println(maxKg);
    }
}
