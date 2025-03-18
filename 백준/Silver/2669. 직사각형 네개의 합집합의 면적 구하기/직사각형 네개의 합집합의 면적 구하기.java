import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int area = 0;
		boolean[][] occupied = new boolean[101][101];

		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int x = x1; x < x2; x++) {
				for (int y = y1; y < y2; y++) {
					if (!occupied[x][y]) {
						occupied[x][y] = true;
						area++;
					}
				}
			}
		}

		System.out.println(area);
	}
}
