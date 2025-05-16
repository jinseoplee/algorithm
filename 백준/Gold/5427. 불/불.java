import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * Deque를 활용한 BFS 풀이 
 * 시간 복잡도 O(t * h * w)
 */
class Node {
	char who;
	int r, c, t;

	Node(char who, int r, int c, int t) {
		this.who = who;
		this.r = r;
		this.c = c;
		this.t = t;
	}
}

public class Main {

	// 상, 하, 좌, 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 입력 처리
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			char[][] map = new char[h][];

			// 불의 이동과 상근이의 이동을 동시에 처리하기 위해서 Deque를 사용한다
			Deque<Node> q = new ArrayDeque<>();

			// 맵 초기화
			for (int i = 0; i < h; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j = 0; j < w; j++) {
					if (map[i][j] == '@') { // 상근
						q.addLast(new Node('@', i, j, 0));
					}
					if (map[i][j] == '*') { // 불
						q.addFirst(new Node('*', i, j, 0));
					}
				}
			}

			String result = bfs(h, w, map, q);

			sb.append(result).append("\n");
		}

		// 결과 출력
		System.out.println(sb);
	}

	static String bfs(int h, int w, char[][] map, Deque<Node> q) {
		while (!q.isEmpty()) {
			Node curr = q.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nr = curr.r + dr[dir];
				int nc = curr.c + dc[dir];

				if (curr.who == '*') { // 불
					if (isIn(nr, nc, h, w) && map[nr][nc] != '#' && map[nr][nc] != '*') {
						q.offer(new Node('*', nr, nc, 0));
						map[nr][nc] = '*';
					}
				} else { // 상근
					if (!isIn(nr, nc, h, w)) { // 범위를 벗어난 경우
						return String.valueOf(curr.t + 1); // 탈출 성공
					}

					if (map[nr][nc] == '.') {
						q.offer(new Node('@', nr, nc, curr.t + 1));
						map[nr][nc] = '@';
					}
				}
			}
		}

		return "IMPOSSIBLE"; // 탈출 실패
	}

	static boolean isIn(int r, int c, int h, int w) {
		return 0 <= r && r < h && 0 <= c && c < w;
	}
}