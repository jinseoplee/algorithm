import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 시간 제한 2초
 *
 * 1 <= n <= 500,000 
 * 1 <= m <= 500,000
 * 
 * 이진 탐색 = O(m * log n)
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 배열 초기화
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 오름차순 정렬
		Arrays.sort(arr);

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < m; i++) {
			int findNum = Integer.parseInt(st.nextToken());

			// 이진 탐색
			int result = binarySearch(findNum, arr);

			sb.append(result).append(" ");
		}

		// 결과 출력
		System.out.println(sb);
	}

	static int binarySearch(int findNum, int[] arr) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2;

			if (arr[mid] < findNum) {
				start = mid + 1;
			} else if (arr[mid] > findNum) {
				end = mid - 1;
			} else {
				return 1;
			}
		}

		return 0;
	}
}