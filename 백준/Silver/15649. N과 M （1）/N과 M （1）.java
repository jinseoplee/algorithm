import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] arr;
	static boolean[] selected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 처리
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		selected = new boolean[n + 1];
		arr = new int[m];

		solve(0);

		System.out.println(sb);
	}

	static void solve(int idx) {
		if (idx == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!selected[i]) {
				selected[i] = true;
				arr[idx] = i;
				solve(idx + 1);
				selected[i] = false;
			}
		}
	}
}