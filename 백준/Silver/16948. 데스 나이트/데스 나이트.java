import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 시간 제한 2초 
 * 5 <= 체스판의 크기 <= 200
 * 
 * (r1, c1)에서 (r2, c2)로 이동하는 최소 이동 횟수를 BFS로 구한다 
 * 시간 복잡도: O(n^2)
 */
public class Main {
	static int n;
	static int r1, c1, r2, c2;

	// 데스 나이트가 움직일 수 있는 방향
	static int[] dr = { -2, -2, 0, 0, 2, 2 };
	static int[] dc = { -1, 1, -2, 2, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());

		int minCount = bfs();

		System.out.println(minCount);
	}

	static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[n][n];

		q.offer(new int[] { r1, c1, 0 });
		visited[r1][c1] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			if (curr[0] == r2 && curr[1] == c2) {
				return curr[2];
			}
			for (int dir = 0; dir < 6; dir++) {
				int nr = curr[0] + dr[dir];
				int nc = curr[1] + dc[dir];
				if (isIn(nr, nc) && !visited[nr][nc]) {
					q.offer(new int[] { nr, nc, curr[2] + 1 });
					visited[nr][nc] = true;
				}
			}
		}

		return -1;
	}

	static boolean isIn(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < n;
	}
}