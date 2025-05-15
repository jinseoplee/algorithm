import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 제한 사항 0.5초 
 * 2 <= n <= 1,000 
 * 1 <= 비용 <= 1,000
 * 
 * DP 풀이 = O(n)
 */
public class Main {
	static final int INF = 1_000_000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] cost = new int[n][3];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken()); // r
			cost[i][1] = Integer.parseInt(st.nextToken()); // g
			cost[i][2] = Integer.parseInt(st.nextToken()); // b
		}

		int result = INF;

		// 첫 번째 집의 색을 r, g, b 중 하나로 고정
		for (int firstColor = 0; firstColor < 3; firstColor++) {
			int[][] dp = new int[n][3];

			// 첫 번째 집은 firstColor로 고정
			for (int c = 0; c < 3; c++) {
				dp[0][c] = (firstColor == c) ? cost[0][c] : INF;
			}

			// DP 테이블 채우기
			for (int i = 1; i < n; i++) {
				dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
				dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
				dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
			}

			// 마지막 집의 색이 첫 번째 집과 다를 때만 고려
			for (int lastColor = 0; lastColor < 3; lastColor++) {
				if (lastColor != firstColor) {
					result = Math.min(result, dp[n - 1][lastColor]);
				}
			}
		}

		System.out.println(result);
	}
}