package no17503;
import java.io.*;
import java.util.*;

class Beer {
    int prefer, alcohol;

    public Beer(int prefer, int alcohol) {
        this.prefer = prefer;
        this.alcohol = alcohol;
    }
}

public class Main {
    static int N, M, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   //축제가 열리는 기간
        M = Integer.parseInt(st.nextToken());   //채워야하는 선호도의 합
        K = Integer.parseInt(st.nextToken());   //마실 수 있는 맥주의 종류

        Queue<Integer> prefers = new PriorityQueue<>();
        List<Beer> beers = new ArrayList<>();

        //k종류의 맥주에 각각 선호도와 도수레벨 매김.
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());   //선호도 : 해당맥주 얼마나 좋아하는지
            int a = Integer.parseInt(st.nextToken());   //도수레벨

            beers.add(new Beer(p, a));
        }
        beers.sort(new Comparator<Beer>() {
            @Override
            public int compare(Beer o1, Beer o2) {
                //알코올 도수 같은 경우
                if (o1.alcohol == o2.alcohol) {
                    return o2.prefer - o1.prefer;
                }
                return o1.alcohol - o2.alcohol;
            }
        });

        int total = 0;
        int answer = -1; //만족할 수 없는경우
        for (Beer beer : beers) {
            prefers.add(beer.prefer);
            total += beer.prefer;

            if (prefers.size() > N) {
                total -= prefers.poll();    //우선순위 큐에서 가장 선호도가 낮은 맥주 빼기
            }
            if (prefers.size() == N && total >= M) {    //큐 사이즈 = N, 누적된 값이 M보다크면 탈출
                answer = beer.alcohol;
                break;
            }
        }
        System.out.print(answer);
    }
}