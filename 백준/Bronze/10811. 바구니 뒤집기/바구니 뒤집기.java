import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = i;
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			for (int k = 0; k < (j - i + 1) / 2; k++) {
				int tmp = arr[i + k];
				arr[i + k] = arr[j - k];
				arr[j - k] = tmp;
			}
		}

		for (int i = 1; i <= n; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb);
	}
}