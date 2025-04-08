import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		boolean[] arr = new boolean[2_000_001];

		for (int i = 0; i < n; i++) {
			arr[Integer.parseInt(br.readLine()) + 1_000_000] = true;
		}

		for (int i = 0; i <= 2_000_000; i++) {
			if (arr[i]) sb.append(i - 1_000_000).append("\n");
		}

		System.out.println(sb);
	}
}