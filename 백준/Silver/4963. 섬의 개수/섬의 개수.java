import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시간 제한 1초 
 * 1 <= w, h <= 50
 * 
 * DFS 풀이 = O(h * w)
 */
public class Main {
	static int w, h;
	static int[][] map;
	static boolean[][] visited;

	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			// 종료 조건
			if (w == 0 && h == 0) {
				break;
			}

			map = new int[h][w];
			visited = new boolean[h][w];

			// 맵 초기화
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 맵을 순회하면서 섬의 개수를 구한다
			int count = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && map[i][j] == 1) {
						dfs(i, j);
						count++;
					}
				}
			}
			sb.append(count).append("\n");
		}

		// 결과 출력
		System.out.println(sb);
	}

	static void dfs(int r, int c) {
		visited[r][c] = true;
		for (int dir = 0; dir < 8; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if ((0 <= nr && nr < h && 0 <= nc && nc < w) && !visited[nr][nc] && map[nr][nc] == 1) {
				dfs(nr, nc);
			}
		}
	}
}