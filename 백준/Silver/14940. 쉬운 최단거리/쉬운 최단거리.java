import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map, dist;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		dist = new int[n][m];

		int startR = 0, startC = 0;

		for (int i = 0; i < n; i++) {
			Arrays.fill(dist[i], -1);
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					startR = i;
					startC = j;
					dist[i][j] = 0;
				}
				if (map[i][j] == 0) {
					dist[i][j] = 0;
				}
			}
		}

		bfs(startR, startC);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(dist[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int startR, int startC) {
		Queue<int[]> bfsQ = new ArrayDeque<>();
		bfsQ.offer(new int[] { startR, startC, 0 });

		boolean[][] visited = new boolean[n][m];
		visited[startR][startC] = true;

		while (!bfsQ.isEmpty()) {
			int[] curr = bfsQ.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nr = curr[0] + dr[dir];
				int nc = curr[1] + dc[dir];
				if (canGo(nr, nc) && !visited[nr][nc]) {
					bfsQ.offer(new int[] { nr, nc, curr[2] + 1 });
					visited[nr][nc] = true;
					dist[nr][nc] = curr[2] + 1;
				}
			}
		}
	}

	private static boolean canGo(int r, int c) {
		return (0 <= r && r < n && 0 <= c && c < m) && map[r][c] == 1;
	}
}