import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
	int r, c;

	Node(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main {
	static int n, m, answer;
	static int[][] map, copiedMap;

	static List<Node> virus = new ArrayList<>();

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		copiedMap = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) { // 바이러스 위치 저장
					virus.add(new Node(i, j));
				}
			}
		}

		buildWall(0, 0);

		System.out.println(answer);
	}

	static void buildWall(int start, int wallCount) {
		if (wallCount == 3) {
			for (int i = 0; i < n; i++) {
				System.arraycopy(map[i], 0, copiedMap[i], 0, m);
			}

			for (Node v : virus) {
				dfs(v.r, v.c);
			}

			answer = Math.max(answer, safeArea());
			return;
		}

		for (int i = start; i < n * m; i++) {
			int r = i / m;
			int c = i % m;
			if (map[r][c] == 0) {
				map[r][c] = 1;
				buildWall(i + 1, wallCount + 1);
				map[r][c] = 0;
			}
		}
	}

	static void dfs(int r, int c) {
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (inRange(nr, nc) && copiedMap[nr][nc] == 0) {
				copiedMap[nr][nc] = 2;
				dfs(nr, nc);
			}
		}
	}

	static boolean inRange(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < m;
	}

	static int safeArea() {
		int area = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (copiedMap[i][j] == 0) {
					area++;
				}
			}
		}
		return area;
	}
}