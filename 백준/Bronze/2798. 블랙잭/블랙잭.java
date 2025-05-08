import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시간 제한 1초
 * 
 * 3 <= n <= 100
 * 
 * 카드 3장을 뽑는다 = O(n^3)
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 처리
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// m에 최대한 가까운 카드 3장의 합을 구한다
		int max = 0;
		outer: for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					int sum = arr[i] + arr[j] + arr[k];
					if (sum == m) {
						max = m;
						break outer;
					}
					if (sum < m) {
						max = Math.max(max, sum);
					}
				}
			}
		}

		System.out.println(max);
	}
}
