import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		String[] map = new String[n];
		boolean[][] visited = new boolean[n][m];

		int startR = 0, startC = 0;
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine();
			for (int j = 0; j < m; j++) {
				if (map[i].charAt(j) == 'I') {
					startR = i;
					startC = j;
				}
			}
		}

		int count = dfs(startR, startC, n, m, map, visited);
		System.out.println(count == 0 ? "TT" : count);
	}

	static int dfs(int r, int c, int n, int m, String[] map, boolean[][] visited) {
		visited[r][c] = true;
		int count = map[r].charAt(c) == 'P' ? 1 : 0;

		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if ((0 <= nr && nr < n && 0 <= nc && nc < m) && map[nr].charAt(nc) != 'X' && !visited[nr][nc]) {
				count += dfs(nr, nc, n, m, map, visited);
			}
		}

		return count;
	}

}