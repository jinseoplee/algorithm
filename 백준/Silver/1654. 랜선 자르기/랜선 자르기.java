import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시간 제한 2초 
 * 1 <= k <= 10,000 
 * 1 <= n <= 1,000,000 
 * 1 <= 각 랜선의 길이 <= 2^31 - 1
 * 
 * 파라메트릭 서치 풀이 = O(k * log max_len)
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 처리
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		long left = 1; // 가장 짧은 랜선의 길이
		long right = 0; // 입력 값 중 가장 긴 랜선의 길이

		int[] lan = new int[k];
		for (int i = 0; i < k; i++) {
			lan[i] = Integer.parseInt(br.readLine());
			right = Math.max(right, lan[i]);
		}

		// 파라메트릭 서치
		while (left <= right) {
			long mid = (left + right) / 2;

			// mid 길이로 잘랐을 때 얻을 수 있는 랜선 개수 계산
			long count = 0;
			for (int i = 0; i < k; i++) {
				count += lan[i] / mid;
			}

			if (count < n) {
				// 필요한 개수보다 적게 나오는 경우 길이를 줄여 더 많은 랜선이 만들어지도록 한다
				right = mid - 1;
			} else {
				// 필요한 랜선 개수를 만족하는 경우 더 긴 길이로 최대값을 탐색한다
				left = mid + 1;
			}
		}

		System.out.println(right);
	}
}