import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] board;

	// 상, 하, 좌, 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 처리
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int time = 0;

		while (true) {
			int melted = melt();
			if (melted == 0) {
				break;
			}
			time++;
		}

		// 결과 출력
		System.out.println(time);
	}

	static int melt() {
		Queue<int[]> bfsQ = new ArrayDeque<>();
		bfsQ.offer(new int[] { 0, 0 });

		boolean[][] visited = new boolean[n][m];
		visited[0][0] = true;

		int melted = 0;
		int[][] adjCount = new int[n][m];

		while (!bfsQ.isEmpty()) {
			int[] curr = bfsQ.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nr = curr[0] + dr[dir];
				int nc = curr[1] + dc[dir];
				if (isIn(nr, nc) && !visited[nr][nc]) {
					// 치즈가 있는 경우
					if (board[nr][nc] == 1) {
						adjCount[nr][nc]++;
					}
					// 치즈가 없는 경우
					else {
						bfsQ.offer(new int[] { nr, nc });
						visited[nr][nc] = true;
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (adjCount[i][j] >= 2) {
					board[i][j] = 0;
					melted++;
				}
			}
		}

		return melted;
	}

	static boolean isIn(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < m;
	}
}