import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new LinkedList<>();

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			list.add(list.size() - sc.nextInt(), i + 1);
		}

		for (int i = 0; i < n; i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}
