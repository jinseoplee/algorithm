import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean[][] arr = new boolean[100][100];

		int k = Integer.parseInt(br.readLine());
		while (k-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					arr[i][j] = true;
				}
			}
		}

		int area = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (arr[i][j]) {
					area++;
				}
			}
		}
		System.out.println(area);
	}
}
