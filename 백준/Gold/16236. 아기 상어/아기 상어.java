import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;

	static Shark shark;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Shark {
		int r, c, size, eat;

		Shark(int r, int c) {
			this.r = r;
			this.c = c;
			this.size = 2;
			this.eat = 0;
		}
	}

	static class Fish implements Comparable<Fish> {
		int r, c, dist;

		Fish(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

		@Override
		public int compareTo(Fish o) {
			if (this.dist != o.dist) {
				return this.dist - o.dist;
			} else if (this.r != o.r) {
				return this.r - o.r;
			}
			return this.c - o.c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 처리
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		// 맵 초기화
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark = new Shark(i, j);
					map[i][j] = 0;
				}
			}
		}

		int time = 0;

		while (true) {
			Fish fish = bfs();

			// 먹을 물고기가 없는 경우
			if (fish == null) {
				break; // 종료
			}

			shark.r = fish.r;
			shark.c = fish.c;
			time += fish.dist;
			map[shark.r][shark.c] = 0;

			shark.eat++;
			if (shark.eat == shark.size) {
				shark.eat = 0;
				shark.size++;
			}
		}

		System.out.println(time);
	}

	static Fish bfs() {
		Queue<int[]> bfsQ = new ArrayDeque<>();
		bfsQ.offer(new int[] { shark.r, shark.c, 0 });

		boolean[][] visited = new boolean[n][n];
		visited[shark.r][shark.c] = true;

		PriorityQueue<Fish> pq = new PriorityQueue<>();

		while (!bfsQ.isEmpty()) {
			int[] curr = bfsQ.poll();
			int r = curr[0];
			int c = curr[1];
			int dist = curr[2];

			for (int dir = 0; dir < 4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
				if (visited[nr][nc]) continue;
				if (map[nr][nc] > shark.size) continue;

				bfsQ.offer(new int[] { nr, nc, dist + 1 });
				visited[nr][nc] = true;

				if (map[nr][nc] != 0 && map[nr][nc] < shark.size) {
					pq.offer(new Fish(nr, nc, dist + 1));
				}
			}
		}

		return pq.isEmpty() ? null : pq.poll();
	}
}