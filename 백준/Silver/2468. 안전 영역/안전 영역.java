import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 시간제한 1초
 * 2 <= n <= 100
 * 1 <= h <= 100
 * 
 * DFS 풀이 = O(n * n * h)
 */
public class Main {
	static int n;
	static int[][] map;
	static boolean[][] visited;

	// 상, 하, 좌, 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 처리
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		int minH = Integer.MAX_VALUE;
		int maxH = Integer.MIN_VALUE;

		// 맵 초기화
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				minH = Math.min(minH, map[i][j]);
				maxH = Math.max(maxH, map[i][j]);
			}
		}

		int answer = 0;
		for (int h = minH - 1; h <= maxH; h++) { // minH - 1 ~ maxH 높이의 비를 내린다
			visited = new boolean[n][n];

			// 맵을 순회하면서 안전 영역 개수를 구한다
			int area = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j] && map[i][j] > h) {
						dfs(i, j, h);
						area++;
					}
				}
			}

			// 안전 영역의 최대 개수를 구한다
			answer = Math.max(answer, area);
		}

		System.out.println(answer);
	}

	static void dfs(int r, int c, int h) {
		visited[r][c] = true;
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if ((0 <= nr && nr < n && 0 <= nc && nc < n) && !visited[nr][nc] && map[nr][nc] > h) {
				dfs(nr, nc, h);
			}
		}
	}
}