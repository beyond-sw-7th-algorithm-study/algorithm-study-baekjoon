package no24041;
import java.util.*;
import java.io.*;

public class Main{
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