import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static int n;
	static String[] map;
	static boolean[][] visited;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		map = new String[n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine();
		}

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i].charAt(j) == '1' && !visited[i][j]) {
					int count = dfs(i, j);
					list.add(count);
				}
			}
		}

		Collections.sort(list);

		sb.append(list.size()).append("\n");
		for (int e : list) {
			sb.append(e).append("\n");
		}
		System.out.println(sb);
	}

	static int dfs(int r, int c) {
		int count = 1;
		visited[r][c] = true;

		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if ((0 <= nr && nr < n && 0 <= nc && nc < n) && !visited[nr][nc] && map[nr].charAt(nc) == '1') {
				count += dfs(nr, nc);
			}
		}

		return count;
	}
}