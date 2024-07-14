import java.util.Scanner;

public class code2872 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] books = new int[n];
		for (int i = 0; i < n; i++) {
			books[i] = sc.nextInt();
		}

		int target = n;
		for (int i = n - 1; i >= 0; i--) {
			if(books[i] == target)
				target--;
		}

		System.out.println(target);

	}
}
