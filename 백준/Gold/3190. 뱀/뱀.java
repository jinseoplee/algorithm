import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Point {
	int r, c;

	Point(int r, int c) {
		this.r = r;
		this.c = c;
	}

	@Override
	public boolean equals(Object obj) {
		Point other = (Point) obj;
		return this.r == other.r && this.c == other.c;
	}
}

public class Main {
	static final int APPLE = 1;
	static final int EMPTY = 0;

	static int n, k, l;
	static int[][] map;

	// 북, 동, 남, 서
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	// 뱀의 방향 정보 전환
	static Map<Integer, String> dirChange = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 입력 처리
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		// 사과의 위치를 저장한다
		k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int appleR = Integer.parseInt(st.nextToken()) - 1;
			int appleC = Integer.parseInt(st.nextToken()) - 1;
			map[appleR][appleC] = APPLE;
		}

		// 뱀의 방향 전환 정보를 저장한다
		l = Integer.parseInt(br.readLine());
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			dirChange.put(time, dir);
		}

		int endTime = startGame();

		// 결과 출력
		System.out.println(endTime);
	}

	static int startGame() {
		Deque<Point> snake = new ArrayDeque<>();
		snake.addFirst(new Point(0, 0));

		int snakeDir = 1;
		int time = 0;

		while (true) {
			time++;

			Point head = snake.peekFirst();

			int nr = head.r + dr[snakeDir];
			int nc = head.c + dc[snakeDir];

			// 벽이나 자신의 몸에 부딪히면 게임 종료
			if (isOut(nr, nc) || snake.contains(new Point(nr, nc))) {
				break;
			}

			// 이동할 칸에 사과가 있다면
			if (map[nr][nc] == APPLE) {
				map[nr][nc] = EMPTY;
				snake.addFirst(new Point(nr, nc));
			}
			// 이동할 칸에 사과가 없다면
			else {
				snake.addFirst(new Point(nr, nc));
				snake.removeLast();
			}

			// 방향 전환이 필요한 경우
			if (dirChange.containsKey(time)) {
				String nextDir = dirChange.get(time);

				if (nextDir.equals("L")) {
					snakeDir = (snakeDir + 3) % 4; // 반시계 방향
				} else if (nextDir.equals("D")) {
					snakeDir = (snakeDir + 1) % 4; // 시계 방향
				}
			}
		}

		return time;
	}

	static boolean isOut(int r, int c) {
		return r < 0 || r == n || c < 0 || c == n;
	}
}
