import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, l, r;
	static int[][] population;

	static boolean[][] visited;
	static Queue<int[]> q = new ArrayDeque<>();

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 처리
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		population = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				population[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int days = 0;

		while (true) {
			boolean moved = false; // 인구 이동 발생 여부
			visited = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j]) {
						dfs(i, j);
						if (q.size() > 1) {
							move(); // 인구 이동 시작
							moved = true;
						} else {
							q.clear();
						}
					}
				}
			}

			days++;

			if (!moved) { // 이동이 없었으면 종료
				break;
			}
		}

		System.out.println(days - 1);
	}

	static void dfs(int r, int c) {
		visited[r][c] = true;
		q.offer(new int[] { r, c });

		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (inRange(nr, nc) && !visited[nr][nc] && canGo(r, c, nr, nc)) {
				dfs(nr, nc);
			}
		}
	}

	static boolean inRange(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < n;
	}

	static boolean canGo(int r1, int c1, int r2, int c2) {
		int diff = Math.abs(population[r1][c1] - population[r2][c2]);
		return l <= diff && diff <= r;
	}

	static void move() {
		int sum = 0;
		int cnt = q.size();

		for (int i = 0; i < cnt; i++) {
			int[] pos = q.poll();
			sum += population[pos[0]][pos[1]];
			q.offer(pos);
		}

		int newPopulation = sum / cnt;

		while (!q.isEmpty()) {
			int[] pos = q.poll();
			population[pos[0]][pos[1]] = newPopulation;
		}
	}
}