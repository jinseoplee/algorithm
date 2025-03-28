import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int area = 0;
		boolean[][] occupied = new boolean[101][101];

		int n = Integer.parseInt(br.readLine());
		for (int k = 0; k < n; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					if (!occupied[i][j]) {
						occupied[i][j] = true;
						area++;
					}
				}
			}
		}

		System.out.println(area);
	}
}
