import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] count;
	static int[][] paper;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		count = new int[n];
		paper = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve(0, 0, n);
		System.out.println(count[0]);
		System.out.println(count[1]);
	}

	static void solve(int r, int c, int size) {
		if (equal(r, c, size, paper[r][c])) {
			count[paper[r][c]]++;
			return;
		}

		size /= 2;

		solve(r, c, size);
		solve(r, c + size, size);
		solve(r + size, c, size);
		solve(r + size, c + size, size);
	}

	static boolean equal(int r, int c, int size, int v) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (paper[i][j] != v) {
					return false;
				}
			}
		}
		return true;
	}
}