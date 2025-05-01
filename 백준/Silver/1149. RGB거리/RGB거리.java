import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시간제한: 0.5초 
 * 2 <= n <= 1,000 
 * 1 <= 비용 <= 1,000

 * DP로 풀이 = O(n)
 * 최소비용의 최댓값 = 1,000 * 1,000 = 1,000,000 (int 자료형 가능)
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n][3];

		StringTokenizer st = new StringTokenizer(br.readLine());
		dp[0][0] = Integer.parseInt(st.nextToken());
		dp[0][1] = Integer.parseInt(st.nextToken());
		dp[0][2] = Integer.parseInt(st.nextToken());

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + r;
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + g;
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + b;
		}

		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			answer = Math.min(answer, dp[n - 1][i]);
		}
		System.out.println(answer);
	}
}