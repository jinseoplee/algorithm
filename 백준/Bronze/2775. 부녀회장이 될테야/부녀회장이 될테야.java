import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1 <= k, n <= 14
 *
 * DP 풀이
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[][] dp = new int[15][15];

		for (int i = 0; i < 15; i++) {
			dp[0][i] = i + 1;
		}

		for (int i = 1; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if (j == 0) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
				}
			}
		}

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[k][n - 1]).append("\n");
		}
		System.out.println(sb);
	}
}