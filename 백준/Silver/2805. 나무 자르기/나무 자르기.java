import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시간 제한 1초 
 * 1 <= n <= 1,000,000 
 * 1 <= m <= 2,000,000,000 
 * 0 <= h <= 1,000,000,000
 * 
 * 파라메트릭 서치 = O(n * log max_height)
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 처리
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] h = new int[n];

		int left = 0; // 절단기의 최소 높이
		int right = 0; // 절단기의 최대 높이

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			h[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, h[i]);
		}

		while (left <= right) {
			int mid = (left + right) / 2;

			// 가져갈 수 있는 나무 길이의 총합 계산
			long total = 0;
			for (int i = 0; i < n; i++) {
				total += (h[i] > mid) ? h[i] - mid : 0;
			}

			if (total < m) {
				// 원하는 길이 m보다 적게 나오는 경우 절단 높이를 낮춰 더 많이 자르도록 한다
				right = mid - 1;
			} else {
				// 원하는 길이 m 이상 확보 가능한 경우 절단 높이를 높여 최대 높이를 찾는다
				left = mid + 1;
			}
		}

		System.out.println(right);
	}
}