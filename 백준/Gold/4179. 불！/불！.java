import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 시간 제한 1초 
 * 1 <= R, C <= 1,000
 * 
 * 불이 먼저 퍼지고 지훈이를 이동시켜야 한다 
 * BFS 풀이 
 * 시간 복잡도 = O(R * C)
 */
class Node {
	char who;
	int r, c, time;

	Node(char who, int r, int c, int time) {
		this.who = who;
		this.r = r;
		this.c = c;
		this.time = time;
	}
}

public class Main {
	static int R, C;
	static char[][] map;

	static Deque<Node> q = new ArrayDeque<>();

	// 상, 하, 좌, 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 처리
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][];

		// 맵 초기화
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();

			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'J') {
					q.addLast(new Node('J', i, j, 0));
				}
				if (map[i][j] == 'F') {
					q.addFirst(new Node('F', i, j, 0));
				}
			}
		}

		String result = bfs();

		// 결과 출력
		System.out.println(result);
	}

	static String bfs() {
		while (!q.isEmpty()) {
			Node curr = q.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nr = curr.r + dr[dir];
				int nc = curr.c + dc[dir];

				if (curr.who == 'F') { // 불
					if (isIn(nr, nc) && (map[nr][nc] == 'J' || map[nr][nc] == '.')) {
						map[nr][nc] = 'F';
						q.offer(new Node('F', nr, nc, 0));
					}
				} else { // 지훈
					// 가장자리에 도달한 경우
					if (!isIn(nr, nc)) {
						return String.valueOf(curr.time + 1); // 탈출 성공
					}

					if (map[nr][nc] == '.') {
						map[nr][nc] = 'J';
						q.offer(new Node('J', nr, nc, curr.time + 1));
					}
				}
			}
		}

		return "IMPOSSIBLE"; // 탈출 실패
	}

	static boolean isIn(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}
}