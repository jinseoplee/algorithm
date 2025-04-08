import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int r, c, count;

	Node(int r, int c, int count) {
		this.r = r;
		this.c = c;
		this.count = count;
	}
}

public class Main {
	private static int n, m;
	private static int[][] map;

	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		int answer = bfs();
		System.out.println(answer);
	}

	private static int bfs() {
		Queue<Node> bfsQ = new ArrayDeque<>();
		bfsQ.offer(new Node(0, 0, 1));

		boolean[][] visited = new boolean[n][m];
		visited[0][0] = true;

		while (!bfsQ.isEmpty()) {
			Node curr = bfsQ.poll();

			if (curr.r == n - 1 && curr.c == m - 1) {
				return curr.count;
			}

			for (int dir = 0; dir < 4; dir++) {
				int nr = curr.r + dr[dir];
				int nc = curr.c + dc[dir];
				if (canGo(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
					bfsQ.offer(new Node(nr, nc, curr.count + 1));
					visited[nr][nc] = true;
				}
			}
		}

		return -1;
	}

	private static boolean canGo(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < m;
	}
}