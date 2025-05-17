import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 시간 제한 1초 
 * 3 <= n <= 50
 *  
 * 브루트 포스
 * 시간 복잡도: O(n^4)
 */
public class Main {

	static int n;
	static int maxCount;
	static char[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		arr = new char[n][];
		for (int r = 0; r < n; r++) {
			arr[r] = br.readLine().toCharArray();
		}

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				// 오른쪽 인접한 사탕과 교환한다
				if (c < n - 1) {
					swap(r, c, r, c + 1);
					calcCount();
					swap(r, c + 1, r, c);
				}

				// 아래쪽 인접한 사탕과 교환한다
				if (r < n - 1) {
					swap(r, c, r + 1, c);
					calcCount();
					swap(r + 1, c, r, c);
				}
			}
		}

		System.out.println(maxCount);
	}

	static void swap(int r1, int c1, int r2, int c2) {
		char temp = arr[r1][c1];
		arr[r1][c1] = arr[r2][c2];
		arr[r2][c2] = temp;
	}

	static void calcCount() {
		// 가로 방향 계산
		for (int r = 0; r < n; r++) {
			int count = 1;
			for (int c = 1; c < n; c++) {
				if (arr[r][c] == arr[r][c - 1]) {
					count++;
				} else {
					count = 1;
				}
				maxCount = Math.max(maxCount, count);
			}
		}

		// 세로 방향 계산
		for (int c = 0; c < n; c++) {
			int count = 1;
			for (int r = 1; r < n; r++) {
				if (arr[r][c] == arr[r - 1][c]) {
					count++;
				} else {
					count = 1;
				}
				maxCount = Math.max(maxCount, count);
			}
		}
	}
}