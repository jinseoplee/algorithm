import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 제한 사항 
 * 시간 제한 2초 
 * 1 <= n <= 90
 * 
 * DP 풀이
 * 
 * 시간 복잡도 = O(n)
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		long[] dp = new long[n + 1];
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		System.out.println(dp[n]);
	}
}