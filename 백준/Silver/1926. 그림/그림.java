import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * 시간 제한 2초 
 * 1 <= n <= 500 
 * 1 <= m <= 500
 * 
 * DFS 풀이 = O(n * m) = 500 * 500
 *
 */
public class Main {
	static int n, m;
	static int[][] map;

	static boolean[][] visited;

	// 상, 하, 좌, 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 처리
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];

		// 맵 초기화
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0; // 그림의 개수
		int max = 0; // 가장 넓은 그림의 넓이

		// 맵 순회
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					int area = dfs(i, j);
					count++;
					max = Math.max(max, area);
				}
			}
		}

		// 결과 출력
		System.out.println(count);
		System.out.println(max);
	}

	static int dfs(int r, int c) {
		visited[r][c] = true;

		int count = 1;
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if ((0 <= nr && nr < n && 0 <= nc && nc < m) && !visited[nr][nc] && map[nr][nc] == 1) {
				count += dfs(nr, nc);
			}
		}
		return count;
	}
}