import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] room;

	// 북, 동, 남, 서
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	// 로봇의 위치와 방향
	static int robotR, robotC, robotDir;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 처리
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 로봇의 위치와 방향
		st = new StringTokenizer(br.readLine());
		robotR = Integer.parseInt(st.nextToken());
		robotC = Integer.parseInt(st.nextToken());
		robotDir = Integer.parseInt(st.nextToken());

		// 맵 초기화
		room = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = clean();

		// 결과 출력
		System.out.println(count);
	}

	static int clean() {
		int count = 0;

		while (true) {
			// 현재 칸을 청소한다
			if (room[robotR][robotC] == 0) {
				room[robotR][robotC] = -1;
				count++;
			}

			boolean canGo = false;

			for (int k = 0; k < 4; k++) {
				// 반시계 방향으로 회전한다
				robotDir = (robotDir + 3) % 4;
				int nextR = robotR + dr[robotDir];
				int nextC = robotC + dc[robotDir];

				// 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 경우
				if (isIn(nextR, nextC) && room[nextR][nextC] == 0) {
					robotR = nextR;
					robotC = nextC;
					canGo = true;
					break;
				}
			}

			if (!canGo) {
				// 바라보는 방향을 유지한 채로 후진을 시도한다
				int backR = robotR - dr[robotDir];
				int backC = robotC - dc[robotDir];

				// 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다
				if (isIn(backR, backC) && room[backR][backC] == 1) {
					break;
				}

				robotR = backR;
				robotC = backC;
			}
		}

		return count;
	}

	static boolean isIn(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < m;
	}
}