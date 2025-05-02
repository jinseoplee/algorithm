import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 시간 제한 2초 
 * 1 <= n <= 15,000 
 * 1 <= m <= 10,000,000
 * 
 * 정렬 + 투 포인터 = O(n log n)
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 처리
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 오름차순 정렬
		Arrays.sort(arr);

		// 투 포인터
		int l = 0;
		int r = n - 1;
		int answer = 0;

		while (l < r) {
			int sum = arr[l] + arr[r];

			if (sum < m) { // 두 수의 합이 m보다 작다면 l을 증가시킨다
				l++;
			} else if (sum > m) { // 두 수의 합이 m보다 크다면 r을 감소시킨다
				r--;
			} else { // 두 수의 합이 m이라면 l을 증가, r을 감소시킨다
				l++;
				r--;
				answer++;
			}
		}

		System.out.println(answer);
	}
}