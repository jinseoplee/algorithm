import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static char[][] rgb;
	static boolean[][] visited1, visited2;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		rgb = new char[n][n];
		visited1 = new boolean[n][n];
		visited2 = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			rgb[i] = br.readLine().toCharArray();
		}

		int count1 = 0, count2 = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited1[i][j]) {
					dfs1(i, j);
					count1++;
				}
				if (!visited2[i][j]) {
					dfs2(i, j);
					count2++;
				}
			}
		}

		System.out.println(count1 + " " + count2);
	}

	static void dfs1(int r, int c) {
		visited1[r][c] = true;
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (inRange(nr, nc) && !visited1[nr][nc] && rgb[r][c] == rgb[nr][nc]) {
				dfs1(nr, nc);
			}
		}
	}

	static void dfs2(int r, int c) {
		visited2[r][c] = true;
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (inRange(nr, nc) && !visited2[nr][nc] && isSameColor(rgb[r][c], rgb[nr][nc])) {
				dfs2(nr, nc);
			}
		}
	}

	static boolean inRange(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < n;
	}

	static boolean isSameColor(char a, char b) {
		if (a == 'B') return b == 'B';
		return b == 'R' || b == 'G';
	}
}