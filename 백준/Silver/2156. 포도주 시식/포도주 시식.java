import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 시간 제한 2초 
 * 1 <= n <= 10,000
 *
 * DP 풀이
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n + 1];
		int[] dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		if (n == 1) {
			System.out.println(arr[1]);
			return;
		}

		dp[1] = arr[1];
		dp[2] = arr[1] + arr[2];

		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
		}

		System.out.println(dp[n]);
	}
}