import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시간 제한 1초 
 * 4 <= n <= 100 
 * 0 <= 칸에 적혀있는 수 < 9 
 * 칸에 적혀있는 수가 0이면 중복 경로가 발생하기 때문에 메모리 초과, BFS 풀이 불가능
 * 경로의 개수 2^63 - 1, long 자료형 사용
 * 
 * DP 풀이 = O(n^2) = n * n = 100 * 100
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 처리
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];

		// 맵 초기화
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		long[][] dp = new long[n][n];
		dp[0][0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0 || dp[i][j] == 0) continue;
				if (i + map[i][j] < n) {
					dp[i + map[i][j]][j] += dp[i][j];
				}
				if (j + map[i][j] < n) {
					dp[i][j + map[i][j]] += dp[i][j];
				}
			}
		}

		// 결과 출력
		System.out.println(dp[n - 1][n - 1]);
	}
}