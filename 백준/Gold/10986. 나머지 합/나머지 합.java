import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시간 제한 1초 
 * 1 <= n <= 1,000,000 
 * 2 <= m <= 1,000 
 * 0 <= a <= 1,000,000,000
 * 
 * 구간합 + 조합 = O(n + m)
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 처리
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		long answer = 0;
		long[] s = new long[n];
		long[] c = new long[m];

		st = new StringTokenizer(br.readLine());
		s[0] = Integer.parseInt(st.nextToken());

		for (int i = 1; i < n; i++) {
			s[i] = s[i - 1] + Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			int r = (int) (s[i] % m);
			if (r == 0) {
				answer++;
			}
			c[r]++;
		}

		for (int i = 0; i < m; i++) {
			if (c[i] > 1) {
				answer += c[i] * (c[i] - 1) / 2;
			}
		}

		System.out.println(answer);
	}
}