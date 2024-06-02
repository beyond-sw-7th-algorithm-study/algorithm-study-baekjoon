import java.util.*;

class Main{
    static boolean[][] graph; // 값을 담을 2차원 배열
    static boolean[] visit; // 방문한 적이 있는 곳(재방문을 방지하기 위해서) 즉, 초기화
    static int n, m;
    static int result;

    public static void dfs(int index) {
        result++;
        visit[index] = true;
        for (int i = 1; i<= n; i++){
            if(!visit[i] && graph[index][i])
                dfs(i);
        }
    }
    // visit[1] && graph[1][1] = true 이기에 pass 다음 i++ -> i = 2
    // visit[2] && graph[1][2]인데 visit[1] = true이기 때문에
    // visit[2]= false이다. 그리고 graph[1][2] main메서드에서 1,2로 입력을 주었기 때문에 true가 된다.
    // n = 5 m = 4 입력된 값. n = 정점의 수 m = 간선의 수
    // 1 2
    // 1 3
    // 2 4
    // 3 5
    // if문에 따라 visit[2]= false && graph[1][2] = true이므로 dfs(2)를 호출하게 된다.
    // if(!visit[i] && graph[index][i]) = (visit[i] false이고 graph[index][i]가 true) 참이면 dfs(i)를 호츌
    // 즉, dfs(2)를 호출하고 i = 3, 4, 5는 이후에 실행하게 된다.
    // 여기서 dfs를 호출하게 되면 result는 ++이다.


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   // 정점의 수를 입력
        m = sc.nextInt();   // 간선의 수 입력

        graph = new boolean[n+1][n+1];  // n개의 인덱스까지(인덱스를 1부터 사용하기 위해서 +1) 1~n개까지
        visit = new boolean[n+1];       // 마찬가지이다.

        // 그래프 정보를 입력
        int x,y;
        for(int i=0; i<m; i++){
            x = sc.nextInt();
            y = sc.nextInt();
            graph[x][y] = graph[y][x] = true;   // 입력된 그래프의 값을 참으로 설정
        }
        // dfs 및 결과 출력
        dfs(1);

        System.out.println(result-1);   // result-1을 하는 이유는 처음 dfs에 1을 넣어줬기 때문에 초기값(시작 정점) 1을 제거하는 것이다.
    }
}