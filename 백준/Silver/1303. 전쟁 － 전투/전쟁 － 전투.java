import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시간 제한 2초 
 * 1 <= n, m <= 100
 * 
 * DFS 풀이 = O(m * n)
 */
public class Main {
	static int m, n;
	static int wPower, bPower;
	static char[][] map;
	static boolean[][] visited;

	// 동, 서, 남, 북
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 처리
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 가로
		m = Integer.parseInt(st.nextToken()); // 세로

		map = new char[m][n];
		visited = new boolean[m][n];

		// 맵 초기화
		for (int i = 0; i < m; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// 맵 순회
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					// 같은 색상의 병사 수를 구한다
					int count = dfs(i, j, map[i][j]);

					// 위력의 합을 구한다
					if (map[i][j] == 'W') {
						wPower += count * count;
					} else {
						bPower += count * count;
					}
				}
			}
		}

		// 결과 출력
		System.out.println(wPower + " " + bPower);
	}

	static int dfs(int r, int c, char color) {
		int count = 1;
		visited[r][c] = true;
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if ((0 <= nr && nr < m && 0 <= nc && nc < n) && !visited[nr][nc] && map[nr][nc] == color) {
				count += dfs(nr, nc, color);
			}
		}
		return count;
	}
}