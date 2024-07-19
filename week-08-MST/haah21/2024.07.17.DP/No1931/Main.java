package No1931;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //최대 사용할 수 있는 회의의 최대 개수
        int[][] times = new int [n][2];

        for (int i = 0; i <n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            times[i][0] = Integer.parseInt(st.nextToken()); //회의 시작하는 시간 저장
            times[i][1] = Integer.parseInt(st.nextToken()); //회의 끝나는 시간 저장
        }

        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]==o2[1]){ //끝나는 시간이 같을경우
                    return o1[0]-o2[0]; //회의 시간이 빠른순으로 정렬
                }
                return o1[1]-o2[1];
            }
        });

        int count = 0;
        int start_time = 0;
        for (int i = 0; i < n; i++) {
            //직전 종료 시간이 다음 회의 시작 시간보다 작거나 같으면 갱신
            if (start_time <= times[i][0]){
                start_time=times[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
