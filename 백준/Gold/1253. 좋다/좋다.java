import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 시간 제한 2초 
 * 1 <= n <= 2,000 
 * -1,000,000,000 <= a <= 1,000,000,000
 * 
 * 정렬 + 투 포인터 
 * 시간 복잡도: O(n log n + n^2)
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 오름차순 정렬
		Arrays.sort(arr);

		int count = 0;
		for (int i = 0; i < n; i++) {
			// 투 포인터
			int target = arr[i];
			int l = 0;
			int r = n - 1;

			while (l < r) {
				int sum = arr[l] + arr[r];

				if (sum == target) {
					if (l != i && r != i) {
						count++;
						break;
					} else if (l == i) {
						l++;
					} else if (r == i) {
						r--;
					}
				} else if (sum < target) {
					l++;
				} else {
					r--;
				}
			}
		}

		System.out.println(count);
	}
}