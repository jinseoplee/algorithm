import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int m, n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 입력 처리
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		// 에라토스테네스의 체
		boolean[] isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);

		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i * i <= n; i++) {
			if (isPrime[i]) {
				// 소수의 배수는 소수가 아니다
				for (int j = i * i; j <= n; j += i) {
					isPrime[j] = false;
				}
			}
		}

		// 결과 출력
		for (int i = m; i <= n; i++) {
			if (isPrime[i]) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
	}
}
