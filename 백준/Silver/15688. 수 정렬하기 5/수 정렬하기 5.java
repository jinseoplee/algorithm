import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[2_000_001];

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[num + 1_000_000]++;
		}

		for (int i = 0; i <= 2_000_000; i++) {
			if (arr[i] != 0) {
				for (int j = 0; j < arr[i]; j++) {
					sb.append(i - 1_000_000).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}