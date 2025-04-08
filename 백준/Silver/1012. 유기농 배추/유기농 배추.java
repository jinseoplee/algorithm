import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[] dy = { -1, 1, 0, 0 };
	private static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int count = 0;

			boolean[][] map = new boolean[n][m];
			boolean[][] visited = new boolean[n][m];

			while (k-- > 0) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = true;
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!visited[i][j] && map[i][j]) {
						dfs(i, j, n, m, map, visited);
						count++;
					}
				}
			}

			sb.append(count).append("\n");
		}

		System.out.println(sb);
	}

	private static void dfs(int y, int x, int n, int m, boolean[][] map, boolean[][] visited) {
		visited[y][x] = true;
		for (int dir = 0; dir < 4; dir++) {
			int ny = y + dy[dir];
			int nx = x + dx[dir];
			if ((0 <= ny && ny < n && 0 <= nx && nx < m) && map[ny][nx] && !visited[ny][nx]) {
				dfs(ny, nx, n, m, map, visited);
			}
		}
	}
}