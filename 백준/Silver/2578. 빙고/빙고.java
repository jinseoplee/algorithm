import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 빙고판
		boolean[][] bingo = new boolean[5][5];

		// 숫자의 위치
		Map<Integer, int[]> map = new HashMap<>();

		// 빙고판 초기화
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				map.put(num, new int[] { i, j });
			}
		}

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());

				// 숫자의 위치
				int[] pos = map.get(num);

				// 빙고 체크
				bingo[pos[0]][pos[1]] = true;

				// 빙고 체크
				int count = getCount(bingo);

				// 선이 세 개 이상 그어지는 순간
				if (count >= 3) {
					System.out.println(5 * i + j + 1);
					return;
				}
			}
		}
	}

	static int getCount(boolean[][] bingo) {
		int total = 0;

		// 가로, 세로 체크
		for (int i = 0; i < 5; i++) {
			int wCount = 0;
			int hCount = 0;

			for (int j = 0; j < 5; j++) {
				if (bingo[i][j]) {
					wCount++;
				}
				if (bingo[j][i]) {
					hCount++;
				}
			}

			if (wCount == 5) {
				total++;
			}

			if (hCount == 5) {
				total++;
			}
		}

		// 대각선 체크
		int lCount = 0, rCount = 0;
		for (int i = 0; i < 5; i++) {
			if (bingo[i][i]) {
				lCount++;
			}
			if (bingo[i][5 - i - 1]) {
				rCount++;
			}
		}

		if (lCount == 5) {
			total++;
		}
		if (rCount == 5) {
			total++;
		}

		return total;
	}
}