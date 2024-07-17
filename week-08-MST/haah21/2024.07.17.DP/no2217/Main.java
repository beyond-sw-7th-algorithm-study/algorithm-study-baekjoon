package no2217;
//로프
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //로프의 개수
        //각각의 로프는 들 수 있는 물체의 중량이 서로 다를 수도 있음.
        Integer[] w = new Integer[N];   //각 로프의 최대중량 저장하는 배열(입력값 저장)
        Integer[] max_weight = new Integer[N];  //로프의 개수별로 가지는 최대 중량 저장할 배열
        for (int i = 0; i < N; i++) {
            w[i]= Integer.valueOf(br.readLine());
        }

        Arrays.sort(w, Collections.reverseOrder()); //최대중량이 큰 순서로 정렬

        for (int i=0; i< w.length; i++){
            max_weight[i] = w[i]*(i+1);
        }
        Arrays.sort(max_weight,Collections.reverseOrder()); //로프의 개수별로 가지는 최대 중량 큰 순서로 정렬
        System.out.println(max_weight[0]);
    }
}
