package no2776;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine()); //테스트 케이스의 개수 T반큼 반복

        for (int i = 0; i < T; i++) {
            Set<String> note1 = new HashSet<>(); //글자만 비교할거니까 integer로 안받아도 됨.

            int N = Integer.parseInt(br.readLine()); //‘수첩 1’에 적어 놓은 정수의 개수
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                note1.add(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine()); //‘수첩 2’에 적어 놓은 정수의 개수
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if (note1.contains(st.nextToken())){
                    sb.append("1").append("\n");
                }else sb.append("0").append("\n");
            }
        }
        System.out.println(sb);

    }
}
