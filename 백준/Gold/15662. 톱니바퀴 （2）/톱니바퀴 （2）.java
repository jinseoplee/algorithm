import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static char[][] gear; // n개의 톱니바퀴

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 처리
		n = Integer.parseInt(br.readLine());
		gear = new char[n][];

		for (int i = 0; i < n; i++) {
			gear[i] = br.readLine().toCharArray();
		}

		int k = Integer.parseInt(br.readLine());
		while (k-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			rotate(num, dir);
		}

		// 12시 방향이 S극인 톱니바퀴의 개수를 구한다
		int count = 0;
		for (int i = 0; i < n; i++) {
			count += gear[i][0] == '1' ? 1 : 0;
		}

		// 점수 출력
		System.out.println(count);
	}

	static void rotate(int num, int dir) {
		// 톱니바퀴의 회전 방향을 구한다
		int[] dirs = findDir(num, dir);

		// 톱니바퀴를 회전시킨다
		for (int i = 0; i < n; i++) {
			if (dirs[i] != 0) {
				if (dirs[i] == 1) {
					cw(i); // 시계 방향 회전
				} else if (dirs[i] == -1) {
					acw(i); // 반시계 방향 회전
				}
			}
		}
	}

	// 톱니바퀴의 회전 방향을 구한다
	static int[] findDir(int num, int dir) {
		int[] dirs = new int[n];
		dirs[num] = dir;

		for (int i = num - 1; i >= 0; i--) {
			if (gear[i][2] == gear[i + 1][6]) {
				break;
			}
			dirs[i] = (dirs[i + 1] == 1) ? -1 : 1;
		}

		for (int i = num + 1; i < n; i++) {
			if (gear[i][6] == gear[i - 1][2]) {
				break;
			}
			dirs[i] = (dirs[i - 1] == 1) ? -1 : 1;
		}

		return dirs;
	}

	// 시계 방향 회전
	static void cw(int num) {
		char tmp = gear[num][7];
		for (int i = 7; i > 0; i--) {
			gear[num][i] = gear[num][i - 1];
		}
		gear[num][0] = tmp;
	}

	// 반시계 방향 회전
	static void acw(int num) {
		char tmp = gear[num][0];
		for (int i = 0; i < 7; i++) {
			gear[num][i] = gear[num][i + 1];
		}
		gear[num][7] = tmp;
	}
}