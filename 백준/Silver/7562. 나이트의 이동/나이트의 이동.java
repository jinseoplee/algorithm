import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int[] dr = { -2, -2, -1, 1, 2, 2, 1, -1 };
	static int[] dc = { -1, 1, 2, 2, 1, -1, -2, -2 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int l = Integer.parseInt(br.readLine());

			// 나이트가 현재 있는 칸
			String[] input = br.readLine().split(" ");
			int startR = Integer.parseInt(input[0]);
			int startC = Integer.parseInt(input[1]);

			// 나이트가 이동하려고 하는 칸
			input = br.readLine().split(" ");
			int endR = Integer.parseInt(input[0]);
			int endC = Integer.parseInt(input[1]);

			// BFS
			int dist = bfs(startR, startC, endR, endC, l);
			sb.append(dist).append("\n");
		}

		System.out.println(sb);
	}

	static int bfs(int startR, int startC, int endR, int endC, int l) {
		Queue<int[]> bfsQ = new ArrayDeque<>();
		boolean[][] visited = new boolean[l][l];

		bfsQ.offer(new int[] { startR, startC, 0 }); // {x, y, dist}
		visited[startR][startC] = true;

		while (!bfsQ.isEmpty()) {
			int[] curr = bfsQ.poll();
			int r = curr[0];
			int c = curr[1];
			int dist = curr[2];

			if (r == endR && c == endC) {
				return dist;
			}

			for (int dir = 0; dir < 8; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if ((0 <= nr && nr < l && 0 <= nc && nc < l) && !visited[nr][nc]) {
					bfsQ.offer(new int[] { nr, nc, dist + 1 });
					visited[nr][nc] = true;
				}
			}
		}

		return -1;
	}
}