package no20444;
import java.io.*;
import java.util.*;
public class Main {
    //문제에서 정수의 범위값 (2^31-1) -> long으로 받아야함
    static long n;
    static long k;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken()); //가위질 횟수
        k = Long.parseLong(st.nextToken()); //색종이 개수

        long start = 0;
        long end = n/2;

        while (start<=end){
            long row = (start+end)/2; //가로로 자른경우
            long col = n-row; //세로로 자른경우
            long total = cut(row,col);

            if (total == k){
                System.out.println("YES");
                return;//종료
            }else if(total>k){
                end = row-1;
            }else{
                start = row+1;
            }
        }
        System.out.println("NO");
    }

    static long cut(long row, long col){
        return (row+1)*(col+1);
    }
}
