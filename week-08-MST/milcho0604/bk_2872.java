import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bk_2872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int books[] = new int[n];
        for (int i = 0; i < n; i++) {
            books[i] = Integer.parseInt(br.readLine());
        }

        int books_num = n;  // 현재 맞춰야 할 책의 번호(총 책의 개수로 설정)
//        배열을 뒤에서부터 순회 -> books[i]가 num과 같다면 num을 감소
        for (int i = n - 1; i >= 0; i--) {
            if (books[i] == books_num) {
                books_num--;
            }
        }
//        정렬되지 않은 책의 수
//        즉, 맞추지 못한 책의 수를 출력
        System.out.println(books_num);
    }
}
