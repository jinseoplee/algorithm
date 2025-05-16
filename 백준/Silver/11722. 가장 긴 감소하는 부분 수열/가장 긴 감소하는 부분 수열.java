import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시간 제한 1초 
 * 1 <= n <= 1,000 
 * 1 <= a[i] <= 1,000
 * 
 * DP 풀이 
 * 시간 복잡도 = O(n^2)
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 처리
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		int length = 1;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			dp[i] = 1;

			for (int j = i - 1; j >= 0; j--) {
				// arr[i]보다 앞에 있는 값 중 더 큰 수가 있을 경우
				// 감소 수열 가능
				if (arr[j] > arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					length = Math.max(length, dp[i]);
				}
			}
		}

		System.out.println(length);
	}
}