import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int H, N, M;
	static int[][][] grid;

	static Queue<int[]> bfsQ = new ArrayDeque<>();

	static int[] dh = { -1, 1, 0, 0, 0, 0 };
	static int[] dr = { 0, 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		grid = new int[H][N][M];

		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < M; c++) {
					grid[h][r][c] = Integer.parseInt(st.nextToken());
					if (grid[h][r][c] == 1) {
						bfsQ.offer(new int[] { h, r, c });
					}
				}
			}
		}

		solve();

		int answer = 0;
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (grid[h][r][c] == 0) {
						System.out.println("-1");
						return;
					}
					answer = Math.max(answer, grid[h][r][c]);
				}
			}
		}

		System.out.println(answer - 1);
	}

	static void solve() {
		while (!bfsQ.isEmpty()) {
			int[] curr = bfsQ.poll();
			for (int dir = 0; dir < 6; dir++) {
				int nh = curr[0] + dh[dir];
				int nr = curr[1] + dr[dir];
				int nc = curr[2] + dc[dir];
				if (inRange(nh, nr, nc) && grid[nh][nr][nc] == 0) {
					bfsQ.offer(new int[] { nh, nr, nc });
					grid[nh][nr][nc] = grid[curr[0]][curr[1]][curr[2]] + 1;
				}
			}
		}
	}

	static boolean inRange(int h, int r, int c) {
		return 0 <= h && h < H && 0 <= r && r < N && 0 <= c && c < M;
	}
}