import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int n, m;
	private static int[][] grid;
	private static Queue<int[]> bfsQ = new ArrayDeque<>();

	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		grid = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if (grid[i][j] == 1) {
					bfsQ.offer(new int[] { i, j });
				}
			}
		}

		bfs();

		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 0) {
					System.out.println("-1");
					return;
				}
				answer = Math.max(answer, grid[i][j]);
			}
		}

		System.out.println(answer - 1);
	}

	private static void bfs() {
		while (!bfsQ.isEmpty()) {
			int[] curr = bfsQ.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nr = curr[0] + dr[dir];
				int nc = curr[1] + dc[dir];
				if ((0 <= nr && nr < n && 0 <= nc && nc < m) && grid[nr][nc] == 0) {
					bfsQ.offer(new int[] { nr, nc });
					grid[nr][nc] = grid[curr[0]][curr[1]] + 1;
				}
			}
		}
	}
}