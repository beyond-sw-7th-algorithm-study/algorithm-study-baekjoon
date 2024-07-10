package no19637;
import java.io.*;
import java.util.*;
public class Main {
    static String[] name;
    static int[] power;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //칭호의 개수
        int M = Integer.parseInt(st.nextToken()); //캐릭터들의 개수

        name = new String[N];
        power = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," "); //이거 빼먹어서 런타임에러남
            name[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            binarySearch(Integer.parseInt(st.nextToken())); //이분탐색
        }
        System.out.println(sb);


    }
    static void binarySearch(int num){
        int left = 0;
        int right = power.length;
        int index = 0;
        while (left<=right){
            int mid = (left+right)/2;
            if (power[mid]<num){
                left = mid+1;
            }else {
                right=mid-1;
                index = mid;
            }
        }
        sb.append(name[index]).append("\n");
    }

}
