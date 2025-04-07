import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int max = 0;
		int idx = 0;

		for (int i = 1; i <= 9; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n > max) {
				max = n;
				idx = i;
			}
		}

		System.out.println(max);
		System.out.println(idx);
	}
}