import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] height; // 빙산의 높이를 저장하는 배열

	// 상, 하, 좌, 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 처리
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		height = new int[n][m];

		// 빙산의 높이를 저장한다
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				height[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int year = 0;

		while (true) {
			// 분리된 빙산의 개수를 센다
			int count = count();

			// 분리된 빙산의 개수가 2개 이상인 경우
			if (count >= 2) {
				break;
			}

			// 분리된 빙산이 없는 경우
			if (count == 0) {
				System.out.println("0");
				return;
			}

			// 빙산을 녹인다
			melt();
			year++;
		}

		// 결과 출력
		System.out.println(year);
	}

	static int count() {
		boolean[][] visited = new boolean[n][m];
		int count = 0; // 빙산의 개수

		for (int r = 1; r < n - 1; r++) {
			for (int c = 1; c < m - 1; c++) {
				if (!visited[r][c] && height[r][c] != 0) {
					dfs(r, c, visited);
					count++;
				}
			}
		}

		return count;
	}

	static void dfs(int r, int c, boolean[][] visited) {
		visited[r][c] = true;
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (!visited[nr][nc] && height[nr][nc] != 0) {
				dfs(nr, nc, visited);
			}
		}
	}

	static void melt() {
		int[][] melted = new int[n][m];
		for (int i = 0; i < n; i++) {
			System.arraycopy(height[i], 0, melted[i], 0, m);
		}

		for (int r = 1; r < n - 1; r++) {
			for (int c = 1; c < m - 1; c++) {
				if (height[r][c] != 0) {
					// 인접한 0의 개수 카운팅
					int count = 0;
					for (int dir = 0; dir < 4; dir++) {
						int nr = r + dr[dir];
						int nc = c + dc[dir];
						if (height[nr][nc] == 0) {
							count++;
						}
					}

					if (count >= height[r][c]) {
						melted[r][c] = 0;
					} else {
						melted[r][c] -= count;
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			System.arraycopy(melted[i], 0, height[i], 0, m);
		}
	}
}