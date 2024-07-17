package week07.Step04_24041;
/*
시간이 지나며 세균이 증식을 할 때, 제한된 균수 이하로 밀키트를 구매일로 부터 며칠 후 까지 먹을 수 있는 계산하는 문제이다.
(무슨 이런..). 조건의 제한을 확인했을 때 부패속도 S1은 최대 10^9이며,
구매 후 최대 10^9까지 먹을 수 있기 때문에, 최대 균 수는 10^9 *2가 될 수 있다.
제한된 균 수를 확인하는 과정에서, 모든 균 수마다 비교를 한다면 시간초과가 날 것이기 때문에,
해당 과정에서 효율적인 이분 탐색방법을 사용할 필요가 있다고 생각했다.

이후 풀이 과정은 다음과 같다.

필수인 0과 필수가 아닌 1을 기준으로 [부패속도, 유통기한]을 서로 다른 배열에 저장한다.
이분 탐색을 통해 중앙 값을 잡고, 해당 중앙 값을 최대 세균 수로 가정하여 밀키트의 해당일의 세균수를 확인한다.
해당 날짜와 K개의 자료를 뺀 최소 세균 수를 구한다. 단 0은 필수 재료이므로 세균의 증식 값을 반드시 추가하고,
1일 경우 세균 수가 가장 큰 재료 순으로 정렬하여 K개의 재료를 빼버린 후 나머지를 포함한다.
while 문을 통해 가장 최대 값을 구하기 위해 반복한다.

---

4 36 0
2 14 1
3 8 1
5 12 1
7 10 0

* */


import java.util.*;
import java.io.*;

public class Main {
    static FastScanner fs = new FastScanner();
    static PrintWriter pw = new PrintWriter(System.out);

    static long n, g, k;
    static long left = 1, right = Integer.MAX_VALUE - 1;
    static ing[] ings;

    public static void main(String[] args) {
        n = fs.nextLong();
        g = fs.nextLong();
        k = fs.nextLong();
        ings = new ing[(int)n];

        for (int i=0;i<n;i++){
            ings[i] = new ing(fs.nextLong(), fs.nextLong(), fs.nextInt());
        }

        while (left < right){
            int x = (int)((left + right + 1) / 2);
            boolean flag = solve(x);

            if (flag) left = x;
            else right = x - 1;
        }

        pw.println(left);
        pw.close();
    }

    static boolean solve(int x){
        PriorityQueue<Long> priq = new PriorityQueue<>(Collections.reverseOrder());
        long cnt = k;
        long gsum = 0;
        for (ing now : ings){
            long tmp = now.s * Math.max(1, x - now.l);
            if (now.o) priq.add(tmp);
            gsum += tmp;

            if (gsum > g){
                if (cnt-- == 0 || priq.isEmpty()) return false;
                gsum -= priq.poll();
            }
        }

        while (cnt-- > 0 && !priq.isEmpty()){
            gsum -= priq.poll();
        }

        return gsum <= g;
    }

    static class ing{
        long s, l;
        boolean o;
        // true => not important

        public ing(long s, long l, int o){
            this.s = s;
            this.l = l;
            if (o == 1) this.o = true;
            else this.o = false;
        }
    }

    // ----------input function----------

    static void sort(int[] a) {
        ArrayList<Integer> L = new ArrayList<>();
        for (int i : a)
            L.add(i);
        Collections.sort(L);
        for (int i = 0; i < a.length; i++)
            a[i] = L.get(i);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
