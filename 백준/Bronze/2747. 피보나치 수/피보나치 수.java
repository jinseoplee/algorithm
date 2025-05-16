import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 시간 제한 1초 
 * 1 <= n <= 45
 * 
 * DP 풀이 
 * 시간 복잡도 = O(n)
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 처리
		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[46];
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		System.out.println(dp[n]);
	}
}