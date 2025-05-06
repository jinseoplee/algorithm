import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시간 제한 2초 
 * -1,000,000,000 <= 식의 결과 <= 1,000,000,000
 * 
 * 브루트포스 + 백트레킹
 *
 */
public class Main {
	static int n;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int[] arr;
	static int plus, minus, mul, div;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 처리
		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		plus = Integer.parseInt(st.nextToken());
		minus = Integer.parseInt(st.nextToken());
		mul = Integer.parseInt(st.nextToken());
		div = Integer.parseInt(st.nextToken());

		dfs(1, arr[0]);

		// 결과 출력
		System.out.println(max);
		System.out.println(min);
	}

	static void dfs(int idx, int acc) {
		if (idx == n) {
			min = Math.min(min, acc);
			max = Math.max(max, acc);
			return;
		}

		if (plus > 0) {
			plus--;
			dfs(idx + 1, acc + arr[idx]);
			plus++;
		}

		if (minus > 0) {
			minus--;
			dfs(idx + 1, acc - arr[idx]);
			minus++;
		}

		if (mul > 0) {
			mul--;
			dfs(idx + 1, acc * arr[idx]);
			mul++;
		}

		if (div > 0) {
			div--;
			dfs(idx + 1, acc / arr[idx]);
			div++;
		}
	}
}