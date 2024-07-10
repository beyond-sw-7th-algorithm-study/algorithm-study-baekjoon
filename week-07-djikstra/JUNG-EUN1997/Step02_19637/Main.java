package week07.Step02_19637;

/*
IF문 좀 대신 써줘

첫 번째 줄에는 칭호의 개수 N (1 ≤ N ≤ 105)과
칭호를 출력해야 하는 캐릭터들의 개수 M (1 ≤ M ≤ 105)이 빈칸을 사이에 두고 주어진다. (1 ≤ N, M ≤ 105)

두 번째 줄부터 N개의 줄에 각 칭호의 이름을 나타내는 길이 1 이상, 11 이하의 영어 대문자로만 구성된 문자열과
해당 칭호의 전투력 상한값을 나타내는 109 이하의 음이 아닌 정수가 주어진다. 칭호는 전투력 상한값의 비내림차순으로 주어진다.

N + 2번째 줄부터 M개의 각 줄에는 캐릭터의 전투력을 나타내는 음이 아닌 정수가 주어진다.
해당하는 칭호가 없는 전투력은 입력으로 주어지지 않는다.

---
3 8
WEAK 10000
NORMAL 100000
STRONG 1000000
0
9999
10000
10001
50000
100000
500000
1000000
---
WEAK
WEAK
WEAK
NORMAL
NORMAL
NORMAL
STRONG
STRONG

* */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer,String> defaultData = new HashMap<>(); // 숫자가 아닌 string값을 찾기위한 map
        int[] arr = new int[n]; // 실제 값을 검색하기 위한 array
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String value = st.nextToken();
            Integer key = Integer.parseInt(st.nextToken());
            arr[i] = key;
            if(!defaultData.containsKey(key)){ // 중복 시 처음의 값만 사용하기 위함
                defaultData.put(key,value);
            }
        }

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());
            int start = 0;
            int end = arr.length - 1;
            int mid;
            while (start <= end){
                mid = (start + end) / 2; // mid는 아래 if문에서 조건식 판별을 해주지 않으므로 참거짓 판별을 할 수 없음
                if(num > arr[mid]){
                    start = mid + 1;
                }else{
                    end = mid - 1; // 특별한 조건 없이 -1을 함으로 출력 시 가장 큰 값으로 남지 않을 수 있음
                }
            }
            sb.append(defaultData.get(arr[start])).append("\n"); // 따라서 왼쪽부터 올라가는 left로 값 추출
        }
        System.out.println(sb);
    }
}
